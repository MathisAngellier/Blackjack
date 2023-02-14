package model;

import model.Hand;
import model.Kaart;

public class Dealer {

    private Hand hand;

    public Dealer(){
        this.hand = new Hand();
    }

    public void voegKaartToe(Kaart kaart){
        hand.voegKaartToe(kaart);
    }

    public void verwijderHand(){
        hand.verwijderHand();
    }

    public int eersteKaart(){
        return hand.dealerEersteKaart();
    }

    public int getTotaal(){
        return hand.berekenTotaal();
    }

    @Override
    public String toString() {
        return "model.Dealer{" +
                "hand=" + hand +
                '}';
    }
}
