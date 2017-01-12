package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class GoogleSearchPage {
    protected WebDriver driver;

    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(name="btnG")
    private WebElement searchButton;

    @FindBy(xpath = ".//*[@id='rso']/div[1]/div[1]/div/h3/a")
    private WebElement firstResult;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
    }

    public void waitFor(final String searchTerm) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(searchTerm);
            }
        });
    }

    public void firstResult() {
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firstResult.click();
        waitFor("wikipedia.org");

    }

public String getCurrentUrl () {
    return driver.getCurrentUrl();
}

}