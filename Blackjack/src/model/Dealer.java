package model;

import model.Hand;
import model.Kaart;

public class Dealer {

    private Hand hand;
    private int totaal;

    public Dealer(){
        this.hand = new Hand();
        this.totaal = totaal;
    }

    public void voegKaartToe(Kaart kaart){
        hand.voegKaartToe(kaart);
    }

    public void verwijderHand(){
        hand.verwijderHand();
    }

    public int getTotaal(){
        return hand.getWaarde();
    }

    public void setTotaal(int totaal) {
        this.totaal = totaal;
    }

    @Override
    public String toString() {
        return "model.Dealer{" +
                "hand=" + hand +
                '}';
    }

    public Hand getHand() {
        return hand;
    }
}
