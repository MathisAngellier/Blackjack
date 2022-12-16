import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PakKaarten extends Kaart {
    private List<Kaart> kaarten;

    public PakKaarten(int waarde, Symbool symbool) {
        super(waarde, symbool);
        kaarten = new ArrayList<>();
    }

    public void vulKaarten(Kaart kaart){
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0 -> vulKaarten(new Kaart(i, Symbool.HARTEN));
                    case 1 -> vulKaarten(new Kaart(i, Symbool.RUITEN));
                    case 2 -> vulKaarten(new Kaart(i, Symbool.SCHOPPEN));
                    case 3 -> vulKaarten(new Kaart(i, Symbool.KLAVEREN));
                    default -> System.out.println("Er was een fout bij het vullen van de arrayList");
                }
            }
        }
    }

    public void schudden(){
        Collections.shuffle(this.kaarten);
    }

    public List<Kaart> getKaarten() {
        return kaarten;
    }

    public void setKaarten(List<Kaart> kaarten) {
        this.kaarten = kaarten;
    }
}

