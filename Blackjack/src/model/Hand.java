package model;

public class Hand {

    //ik weet niet hoeveel kaarten er in een hand kunnen zijn dus ik heb gewoon 10 gepakt
    private Kaart[] hand = new Kaart[10];
    private int aantalKaarten = 0;

    public Hand(){

    }

    public void voegKaartToe(Kaart kaart){
        hand[aantalKaarten++] = kaart;
    }

    public void verwijderHand(){
        aantalKaarten = 0;
    }

    public int berekenTotaal(){
        int totaal = 0;
        for (int i = 0; i < aantalKaarten; i++) {
            totaal += hand[i].getWaarde();
        }
        return totaal;
    }

    public int dealerEersteKaart(){
        int waardeKaart = hand[0].getWaarde();
        return waardeKaart;
    }


    @Override
    public String toString() {
        StringBuilder handTekst= new StringBuilder();
        for (Kaart kaart : hand) {
            if (kaart != null)
                handTekst.append(kaart);
        }
        return handTekst.toString();
    }
}
