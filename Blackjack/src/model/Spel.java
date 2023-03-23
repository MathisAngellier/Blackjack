package model;


import view.speleraanmaakpagina.SpeleraanmaakpaginaPresenter;
import view.spelpagina.SpelpaginaPresenter;
import java.util.ArrayList;

/// TODO: 23/03/2023 documentatie in deze klasse
/**
 *
 */
public class Spel {
    private Dealer dealer;
    private PakKaarten pakKaarten;

    ArrayList<Speler> spelers = SpeleraanmaakpaginaPresenter.getSpelers();

    public Speler[] spelersArray = spelers.toArray(new Speler[0]);

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public Speler[] getSpelersArray() {
        return spelersArray;
    }

    public void setSpelersArray(Speler[] spelersArray) {
        this.spelersArray = spelersArray;
    }

    public Spel() {
        dealer = new Dealer();
        pakKaarten = new PakKaarten();
    }

    public void deelKaartenUit(SpelpaginaPresenter spelpaginaPresenter){
        for (int i = 0; i < spelers.size(); i++) {
            spelers.get(i).verwijderHand();
            spelers.get(i).getHand().setWaarde(0);
        }
        dealer.verwijderHand();
        dealer.getHand().setWaarde(0);

        pakKaarten.vulKaarten();
        pakKaarten.schudden();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < spelers.size(); j++) {
                spelers.get(j).voegKaartToe(pakKaarten.volgendeKaart());
            }

        }
        dealer.voegKaartToe(pakKaarten.volgendeKaart());
        spelpaginaPresenter.updateView();
    }

    public void hit(SpelpaginaPresenter spelpaginaPresenter){

        for (int i = 0; i < spelers.size(); i++) {
            spelers.get(i).voegKaartToe(pakKaarten.volgendeKaart());

            if (spelers.get(i).getTotaal() > 21){
                eindeSpel(false);
            }
            spelpaginaPresenter.updateView();
        }
    }


    public void stand(SpelpaginaPresenter spelpaginaPresenter){
        while (dealer.getTotaal() < 17) {
            dealer.voegKaartToe(pakKaarten.volgendeKaart());
        }

        for (int i = 0; i < spelers.size(); i++) {
            if (dealer.getTotaal() > 21){
                eindeSpel(false);
            } else if (dealer.getTotaal() > spelers.get(i).getTotaal() && dealer.getTotaal() < 22){
                eindeSpel(false);
            } else if (spelers.get(i).getTotaal() > dealer.getTotaal()){
                eindeSpel(true);
            } else {
                eindeSpel(false);
            }
        }
        spelpaginaPresenter.updateView();

    }

    private boolean gewonnen;
    public void eindeSpel(boolean winnaar){
        gewonnen = winnaar;
    }


    public boolean isGewonnen() {
        return gewonnen;
    }

    public Dealer getDealer() {
        return dealer;
    }



}


