package com.selenium.test;

import com.selenium.test.Parser;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String... args){
        ArrayList<SheetNote> noteList = Parser.parse("testfile1.xls");
        for(SheetNote note : noteList) {
            System.out.println("Categorie: " + note.getCategorie() +
                    " Personnage: " + note.getPersonnage() +
                    " Titre: " + note.getTitre() +
                    " Lien: " + note.getLien());
        }
    }

}
