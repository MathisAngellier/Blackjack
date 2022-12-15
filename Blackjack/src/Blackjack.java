import java.util.List;

public class Blackjack {
    private PakKaarten pakKaarten;
    private List<Speler> spelers;

    public Blackjack(PakKaarten pakKaarten, List<Speler> spelers) {
        this.pakKaarten = pakKaarten;
        this.spelers = spelers;
    }

    public Void nieweSpeler(String naam){
        this.spelers.add(new Speler(naam))
    }
}//test om te zien of github werkt

