import java.util.Arrays;

public class Hand {

    //ik weet niet hoeveel kaarten er in een hand kunnen zijn dus ik heb gewoon 10 gepakt
    private Kaart[] hand = new Kaart[10];
    private int aantalKaarten = 0;

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

    @Override
    public String toString() {
        return Arrays.toString(hand);
    }
}
