public class Speler {
    private String naam;
    private int geld;
    private int inzet;
    private boolean isKapot; //als de speler meer dan 21 heeft
    private Hand hand;

    public Speler(String naam, int geld) {
        this.naam = naam;
        this.geld = geld;
        this.isKapot = false;
        this.hand = new Hand();
    }

    public Speler(String naam, int geld, int inzet, boolean isKapot, Hand hand) {
        this.naam = naam;
        this.geld = geld;
        this.inzet = inzet;
        this.isKapot = isKapot;
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Speler{" +
                "naam='" + naam + '\'' +
                ", geld=" + geld +
                ", inzet=" + inzet +
                ", isKapot=" + isKapot +
                ", hand=" + hand +
                '}';
    }
    public void voegKaartToe(Kaart kaart){
        hand.voegKaartToe(kaart);
    }

    public void verwijderKaart(){
        hand.verwijderHand();
    }

    public int getInzet() {
        return inzet;
    }

    public void setInzet(int inzet) {
        this.inzet = inzet;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public boolean isKapot() {
        return isKapot;
    }

    public void setKapot(boolean kapot) {
        isKapot = kapot;
    }
}
