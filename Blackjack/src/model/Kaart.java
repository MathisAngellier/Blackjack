package model;

import javax.swing.text.html.ImageView;

public class Kaart {
    private int waarde;
    private String kleur;
    private ImageView imageView;

    public Kaart(int waarde, String kleur ) {
        this.waarde = waarde;
        this.kleur = kleur;
    }

    public Kaart(int i, Symbool klaveren) {

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public String toString() {
        if (waarde > 10){
            return prentNaam() +" "+ waarde+" ";
        } else {
            return kleur+" "+waarde+" ";
        }

    }

    public String prentNaam(){
        String naam = "";
        switch (waarde){
            case 1: naam = "Aas"; waarde = 10; break;
            case 11: naam = "Boer"; waarde = 10; break;
            case 12: naam = "Dame"; waarde = 10; break;
            case 13: naam = "Koning"; waarde = 10; break;
        }
        return naam;
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
