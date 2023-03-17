package model;

import javafx.scene.image.Image;

public class Kaart {
    private int waarde;
    private String kleur;
    private String path;
    private Image image;


    public Kaart(int waarde, String kleur, String path, Image img) {
        this.waarde = waarde;
        this.kleur = kleur;
        this.path = path;
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
}
