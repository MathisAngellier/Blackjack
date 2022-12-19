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

    @Override
    public String toString() {
        return "Dealer{" +
                "hand=" + hand +
                '}';
    }
}
