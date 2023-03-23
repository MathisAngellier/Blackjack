package model;

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

    @Override
    public String toString() {
        return "model.Speler{" +
                "naam='" + naam + '\'' +
                ", geld=" + geld +
                ", inzet=" + inzet +
                ", isKapot=" + isKapot +
                ", hand=" + hand +
                '}';
    }
    public int getTotaal(){
        return hand.getWaarde();
    }


    public void voegKaartToe(Kaart kaart){
        hand.voegKaartToe(kaart);
    }



    public void setInzet(int inzet) {
        this.inzet = inzet;
    }

    public Hand getHand() {
        return hand;
    }


    public String getNaam() {
        return naam;
    }


    public int getGeld() {
        return geld;
    }



    public void verwijderHand() {
        hand.verwijderHand();

    }

}
