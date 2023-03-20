package model;

import javafx.scene.image.Image;

public class Kaart {
    private int waarde;
    private String kleur;
    private String naam;
    private Image image;


    public Kaart(int waarde, String kleur, String naam, Image img) {
        this.waarde = waarde;
        this.kleur = kleur;
        this.naam = naam;
        this.image = img;
    }

    @Override
    public String toString() {
        return "";
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public Image getImage() {
        return image;
    }

    public String getNaam() {
        return naam;
    }
}
