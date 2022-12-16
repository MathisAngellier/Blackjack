public class Speler {
    private String naam;
    private int totaal;
    private double geld;
    private boolean isKapot; //als de speler meer dan 21 heeft

    public Speler(String naam, double geld) {
        this.naam = naam;
        this.totaal = 0;
        this.geld = geld;
        this.isKapot = false;
    }

    //hier laten we de speler kaarten trekken
    public void trek(Kaart kaart){
        this.totaal += kaart.getWaarde();
        if (this.totaal > 21){
            this.isKapot = true;
        }
    }

    @Override
    public String toString() {
        return "Speler{" +
                "naam='" + naam + '\'' +
                ", totaal=" + totaal +
                ", geld=" + geld +
                ", isKapot=" + isKapot +
                '}';
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getTotaal() {
        return totaal;
    }

    public void setTotaal(int totaal) {
        this.totaal = totaal;
    }

    public double getGeld() {
        return geld;
    }

    public void setGeld(double geld) {
        this.geld = geld;
    }

    public boolean isKapot() {
        return isKapot;
    }

    public void setKapot(boolean kapot) {
        isKapot = kapot;
    }
}
