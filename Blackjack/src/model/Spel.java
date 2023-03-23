package model;


import view.speleraanmaakpagina.SpeleraanmaakpaginaPresenter;
import view.spelpagina.SpelpaginaPresenter;
import java.util.ArrayList;

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

    /**
     * Hier maakt men de dealer aan en een niew pakkaarten.
     */
    public Spel() {
        dealer = new Dealer();
        pakKaarten = new PakKaarten();
    }

    /**
     * Hier haalt men de kaarten op en geeft de spelers en dealer 2 kaarten,
     * men schudt ook het pakkaarten zodat men een willekeurige kaart krijgt,
     * men roept deze methode op in Spelpresenter.
     * @param spelpaginaPresenter
     */

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

    /**
     * Hier geeft men de speler een extra kaart en controleert men of de speler niet meer dan 21 heeft,
     * als dit zo is zet men winnaar op false, word opgeroepen in de Spelpaginapresenter.
     * @param spelpaginaPresenter
     */

    public void hit(SpelpaginaPresenter spelpaginaPresenter){

        for (int i = 0; i < spelers.size(); i++) {
            spelers.get(i).voegKaartToe(pakKaarten.volgendeKaart());

            if (spelers.get(i).getTotaal() > 21){
                eindeSpel(false);
            }
            spelpaginaPresenter.updateView();
        }
    }

    /**
     * Hier geeft men de dealer kaarten tot de waarde van de kaarten meer is dan 17,
     * vervolgens controleert men wie gewonnen is en past men de boolean eindespel aan,
     * deze methode word opgeroepen in de klasse Spelpaginapresenter.
     * @param spelpaginaPresenter
     */

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


