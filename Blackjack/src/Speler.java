public class Speler {
    private String naam;
    private int totaal;
    private boolean isKapot; //of de speler meer dan 21 heeft

    public Speler(String naam, int totaal, boolean isKapot) {
        this.naam = naam;
        this.totaal = 0;
        this.isKapot = false;
    }

    //hier laten we de speler kaarten trekken
    public void trek(int kaart){
        this.totaal += kaart;
        if (this.totaal > 21){
            this.isKapot = true;
        }
    }
}
