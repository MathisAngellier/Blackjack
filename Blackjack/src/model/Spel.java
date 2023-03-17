package model;


import view.speleraanmaakpagina.SpeleraanmaakpaginaPresenter;

import java.util.ArrayList;

//TODO alle logica naar hier verplaatsen
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

private Dealer dealer;
private int aantalSpelers = 3;




    public void setAantalSpelers(int hoeveelheidspelers) {
        this.aantalSpelers = aantalSpelers;
    }

    public Spel() {
        this.spelersArray = spelersArray;
        Dealer dealer = new Dealer();
        PakKaarten pakKaarten = new PakKaarten();
        pakKaarten.vulKaarten();
        pakKaarten.schudden();


        /*
        System.out.println(pakKaarten);

        System.out.println("Welkom bij het spel BLACKJACK");
        int aantalSpelers = 0;
        do {
            //System.out.print("Met hoeveel spelers wil je spelen tot 5? ");
            //aantalSpelers = input.nextInt();
        } while (aantalSpelers <= 0 || aantalSpelers > 5);

        //Spelers initialiseren
        for (int i = 0; i < aantalSpelers; i++) {
            //System.out.print("Wat is de naam van speler" + (i + 1) + "? ");

            //String naam = input.next();
            //System.out.print("Hoeveel geld heeft de speler" + (i + 1) + "? ");
            //int geld = input.nextInt();
            //spelers[i] = new Speler(naam, geld);
        }

        //elke speler die nog geld heeft krijgt een prompt om geld in te zetten
        //er wordt ook gekeken of de inzet niet
        for (int i = 0; i < aantalSpelers; i++) {
            if (spelers[i].getGeld() > 0) {
                //te veranderen
                int inzet=0;
                do {
                    //System.out.print("Hoeveel wil je inzetten " + spelers[i].getNaam() + ", je hebt nog " + spelers[i].getGeld() + ": ");
                    //inzet = input.nextInt();
                    //spelers[i].setInzet(inzet);
                } while (inzet <= 0 || inzet > spelers[i].getGeld());
            }
        }

        //elke speler die nog geld heeft krijgt 2 kaarten in zijn hand + de dealer krijgt ook zijn 2 kaarten
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < aantalSpelers; j++) {
                if (spelers[j].getGeld() > 0) {
                    spelers[j].voegKaartToe(pakKaarten.volgendeKaart());
                }
            }
            dealer.voegKaartToe(pakKaarten.volgendeKaart());
        }

         */


    }

}


