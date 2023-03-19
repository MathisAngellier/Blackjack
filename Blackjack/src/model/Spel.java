package model;


import view.speleraanmaakpagina.SpeleraanmaakpaginaPresenter;
import view.spelpagina.SpelpaginaPresenter;
import view.spelpagina.SpelpaginaView;
import java.util.ArrayList;


public class Spel {

    ArrayList<Speler> spelers = SpeleraanmaakpaginaPresenter.getSpelers();

    public Speler[] spelersArray = spelers.toArray(new Speler[0]);

    public void setSpelersArrayList(ArrayList<Speler> spelersArrayList) {
        this.spelersArray = spelersArrayList.toArray(new Speler[0]);
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public Speler[] getSpelersArray() {
        return spelersArray;
    }

    public void setSpelersArray(Speler[] spelersArray) {
        this.spelersArray = spelersArray;
    }

    private Dealer dealer;
    private int aantalSpelers = 3;
    private Speler speler;
    private PakKaarten pakKaarten;
    private SpelpaginaView spelpaginaView;
    private SpelpaginaPresenter spelpaginaPresenter;

    public void setAantalSpelers(int hoeveelheidspelers) {
        this.aantalSpelers = aantalSpelers;
    }

    public Spel() {
        this.spelersArray = spelersArray;
        dealer = new Dealer();
        pakKaarten = new PakKaarten();
    }

    public void deelKaartenUit(SpelpaginaPresenter spelpaginaPresenter){
        for (int i = 0; i < spelers.size(); i++) {
            System.out.println(spelers.get(i));
            spelers.get(i).verwijderHand();
            spelers.get(i).setTotaal();
        }

        dealer.verwijderHand();
        pakKaarten.vulKaarten();
        pakKaarten.schudden();
        //elke speler die nog geld heeft krijgt 2 kaarten in zijn hand + de dealer krijgt ook zijn 2 kaarten
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < spelers.size(); j++) {
                spelers.get(j).voegKaartToe(pakKaarten.volgendeKaart());
            }
            dealer.voegKaartToe(pakKaarten.volgendeKaart());
        }
        spelpaginaPresenter.updateView();
    }

    public void hit(SpelpaginaPresenter spelpaginaPresenter){
        for (int i = 0; i < spelers.size(); i++) {
            spelers.get(i).voegKaartToe(pakKaarten.volgendeKaart());
            spelpaginaPresenter.updateView();
            if (spelers.get(i).getTotaal() > 21){
                eindeSpel(false);
            }
        }
    }

    public void stand(SpelpaginaPresenter spelpaginaPresenter){
        while (dealer.getTotaal() < 17) {
            dealer.voegKaartToe(pakKaarten.volgendeKaart());
        }
        spelpaginaPresenter.updateView();
        for (int i = 0; i < spelers.size(); i++) {
            if (speler.getTotaal() > 21 || spelers.get(i).getTotaal() > dealer.getTotaal()) {
                eindeSpel(true);
            } else {
                eindeSpel(false);
            }
        }

    }

    public void eindeSpel(boolean winnaar){
        String resultaat;
        if (winnaar){
            resultaat = "speler wint";
        } else {
            resultaat = "dealer wint";
        }
    }

    public Dealer getDealer() {
        return dealer;
    }

    public PakKaarten getPakKaarten() {
        return pakKaarten;
    }

}


