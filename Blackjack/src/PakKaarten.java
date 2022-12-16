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
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                kaarten.add(new Kaart(i, Symbool.HARTEN));
                switch (j) {
                    case 0 : kaarten.add(new Kaart(i, Symbool.HARTEN)); break;
                    case 1 : kaarten.add(new Kaart(i, Symbool.RUITEN)); break;
                    case 2 : kaarten.add(new Kaart(i, Symbool.SCHOPPEN)); break;
                    case 3 : kaarten.add(new Kaart(i, Symbool.KLAVEREN)); break;
                    default : System.out.println("Er was een fout bij het vullen van de arrayList"); break;
                }
            }
        }
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

