package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Kaart> kaarten;
    private int waarde;
    private int aantalKaarten = 0;

    public Hand(){
        kaarten = new ArrayList<>();
        waarde = 0;
    }

    public void voegKaartToe(Kaart kaart){
        kaarten.add(kaart);
        waarde += kaart.getWaarde();

    }

    @Override
    public String toString() {
        for (int i = 0; i < kaarten.size(); i++) {
            kaarten.get(i);
        }
        return "Hand{" +
                "kaarten=" +

                kaarten +
                ", waarde=" + waarde +
                ", aantalKaarten=" + aantalKaarten +
                '}';
    }

    public void verwijderHand(){
        kaarten.clear();
        aantalKaarten = 0;

    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public List<Kaart> getKaarten() {
        return kaarten;
    }
}
