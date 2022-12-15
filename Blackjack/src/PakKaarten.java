import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PakKaarten {
    private List<Integer> kaarten;

    //maken hier ons pak aan; misch later ook het symbool bijhouden
    public PakKaarten() {
        this.kaarten = new ArrayList<Integer>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                this.kaarten.add(i);
            }
        }
    }
    //schudden hier ons pak kaarten
    public void schudden(){
        Collections.shuffle(this.kaarten);
    }
    //hier trekken we een kaart
    public int trek(){
        if (this.kaarten.size()>0){
            return this.kaarten.remove(0);
        }
        return -1; //test of PakKaarten goed werkt
    }
}

