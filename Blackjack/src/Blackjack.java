import java.util.List;

public class Blackjack {
    private PakKaarten pakKaarten;
    private List<Speler> splers;

    public Blackjack(PakKaarten pakKaarten, List<Speler> splers) {
        this.pakKaarten = pakKaarten;
        this.splers = splers;
    }

    public Void nieweSpeler(String naam){
        this.splers.add(new Speler(naam))
    }
}
