package com.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import net.thucydides.core.pages.WebElementFacade;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenAUserSearchesOnGoogle {
    private GoogleSearchPage page;

    @Before
    public void openTheBrowser() {
        WebDriver driver;
        String browser = java.lang.System.getProperties().getProperty("webbrowser");
        if (browser.contains("IE")) {
            driver = new InternetExplorerDriver();
        }
        else if (browser.contains("chrome")){
            driver = new ChromeDriver();
        }
        else {
            System.out.println("Браузер выбран неверно, по умолчанию приложение будет запущено в браузере Firefox");
            driver = new FirefoxDriver();
        }
        page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.open("http://google.com/");

    }

    @After
    public void closeTheBrowser() {
        page.close();
    }

    @Test
    public void whenTheUserSearchesForSeleniumTheResultPageTitleShouldContainCats() {
        page.searchFor("Википедия");
        page.firstResult();
        assertThat(page.getCurrentUrl(), containsString("wikipedia.org"));
    }
    }

