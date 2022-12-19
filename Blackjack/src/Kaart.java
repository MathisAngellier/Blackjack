public class Kaart {
    private int waarde;
    private String kleur;

    public Kaart(int waarde, String kleur) {
        this.waarde = waarde;
        this.kleur = kleur;
    }

    public Kaart() {

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
