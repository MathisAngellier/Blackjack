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

    public Spel() {
        dealer = new Dealer();
        pakKaarten = new PakKaarten();
    }

    /**
     * Hier word iedere speler zijn hand leeg gezet,
     * dan vult men het pakkaarten opniew en zet de volgorde random,
     * vervolgens geeft men iedere speler en de dealer hun kaarten.
     * Deze methode wordt aangeroepen wanneer men naar de spelpagina gaat of
     * wanneer de volgende speler aan de beurt is.
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
     * Deze methode word aangeroepen als men de hit knopt indrukt op de Spelpagina.
     * Men geeft de speler een extra kaart en controleert of de speler niet meer dan 21 heeft,
     * indien dit het geval is zet men boolean winnaar op false
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
     * Deze methode word aangeroepen als men de stand knopt indrukt op de Spelpagina.
     * men geeft de dealer kaarten tot hij meer dan 17 heeft, als dit zo is controleert men wie er gewonnen is.
     * vervolgens past men de boolean eindeSpel aan.
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


