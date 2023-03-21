package model;


import view.speleraanmaakpagina.SpeleraanmaakpaginaPresenter;
import view.spelpagina.SpelpaginaPresenter;
import view.spelpagina.SpelpaginaView;
import java.util.ArrayList;
import java.util.List;


public class Spel {
    private Dealer dealer;
    private int aantalSpelers = 3;
    private Speler speler;
    private PakKaarten pakKaarten;
    private SpelpaginaView spelpaginaView;
    private SpelpaginaPresenter spelpaginaPresenter;

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
        System.out.println(pakKaarten);
        System.out.println("dealer = " + dealer.getTotaal());
        System.out.println("speler = " + spelers.get(0).getTotaal());
        //spelpaginaPresenter.updateView();
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
                System.out.println("dealer kapot");
            } else if (dealer.getTotaal() > spelers.get(i).getTotaal() && dealer.getTotaal() < 22){
                eindeSpel(false);
            } else if (spelers.get(i).getTotaal() > dealer.getTotaal()){
                eindeSpel(true);
            } else {
                eindeSpel(false);
                System.out.println("gelijke waarde dus dealer wint");
            }
        }
        spelpaginaPresenter.updateView();

    }

    public void berekenScore(){

    }

    public void eindeSpel(boolean winnaar){
        String resultaat;
        if (winnaar){
            resultaat = "speler wint";
            System.out.println("speler wint");
        } else {
            resultaat = "dealer wint";
            System.out.println("dealer wint");
        }
    }

    public Dealer getDealer() {
        return dealer;
    }

    public PakKaarten getPakKaarten() {
        return pakKaarten;
    }

}


