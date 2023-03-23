package model;



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

    public int getTotaal(){
        return hand.getWaarde();
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
