package model;


//TODO alle logica naar hier verplaatsen
public class Spel {
    private Speler[] spelers ;

    public Spel() {
        spelers = new Speler[5];
        Dealer dealer = new Dealer();
        PakKaarten pakKaarten = new PakKaarten();
        pakKaarten.vulKaarten();
        pakKaarten.schudden();
    }
}


