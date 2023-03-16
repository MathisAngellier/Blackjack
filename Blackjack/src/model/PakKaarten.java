package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PakKaarten {
    private List<Kaart> kaarten;
    private int index;
    private Kaart kaart;

    public PakKaarten() {
        this.kaarten = new ArrayList<>();
    }

    public void vulKaarten(){
        String[] kleuren = {"Schoppen","Harten","Ruiten","Klaveren"};
        for(int i = 1; i <= 13; i++) {
            for(int j = 0; j < kleuren.length; j++) {
                //kaarten.add(new Kaart(i, kleuren[j]));
            }
        }
    }

    @Override
    public String toString() {
        return "model.PakKaarten{" +
                "kaarten=" + kaarten +
                '}';
    }

    public void schudden(){
        Collections.shuffle(kaarten);
    }

    public Kaart volgendeKaart(){
        return kaarten.get(index++);
    }

    public List<Kaart> getKaarten() {
        return kaarten;
    }

    public void setKaarten(List<Kaart> kaarten) {
        this.kaarten = kaarten;
    }
}

