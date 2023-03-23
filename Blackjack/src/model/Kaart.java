package model;

public class Kaart {
    private int waarde;
    private String kleur;
    private String naam;

    public Kaart(int waarde, String kleur, String naam) {
        this.waarde = waarde;
        this.kleur = kleur;
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "";
    }

    public int getWaarde() {
        return waarde;
    }


    public String getKleur() {
        return kleur;
    }





    public String getNaam() {
        return naam;
    }
}
