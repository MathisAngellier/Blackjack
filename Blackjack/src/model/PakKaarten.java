package model;

import javafx.scene.image.Image;

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

    public void vulKaarten() {
        String[] symbols = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] waarden = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        String[] namen = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < waarden.length; j++) {
                kaarten.add(new Kaart(waarden[j],symbols[i],namen[j],new Image(String.format("file:resources/pakKaarten/%s_%s.png", namen[j].toLowerCase(), symbols[i].toLowerCase()),200,290.4,false,true)));
            }
        }
    }

    @Override
    public String toString() {
        return "PakKaarten{" +
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

