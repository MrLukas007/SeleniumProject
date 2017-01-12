package com.selenium.test;

/**
 * Created by dimusia on 11.01.17.
 */
public class SheetNote {
    private String categorie;
    private String personnage;
    private String titre;
    private String lien;

    public SheetNote(String categorie, String personnage, String titre, String lien) {
        this.categorie = categorie;
        this.personnage = personnage;
        this.titre = titre;
        this.lien = lien;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "SheetNote{" +
                "categorie='" + categorie + '\'' +
                ", personnage='" + personnage + '\'' +
                ", titre='" + titre + '\'' +
                ", lien='" + lien + '\'' +
                '}';
    }
}
