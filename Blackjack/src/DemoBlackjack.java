import java.util.Arrays;
import java.util.Scanner;

public class DemoBlackjack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //je kan maar met 5 spelers spelen
        Speler[] spelers = new Speler[5];
        Dealer dealer = new Dealer();
        //nieuw object pakKaarten dat wordt gevuld en geshuffeld
        PakKaarten pakKaarten = new PakKaarten();
        pakKaarten.vulKaarten();
        pakKaarten.schudden();

        System.out.println(pakKaarten);

        System.out.println("Welkom bij het spel BLACKJACK");
        int aantalSpelers = 0;
        do {
            System.out.print("Met hoeveel spelers wil je spelen tot 5? ");
            aantalSpelers = input.nextInt();
        } while (aantalSpelers <= 0 || aantalSpelers > 5);

        //Spelers initialiseren
        for (int i = 0; i < aantalSpelers; i++) {
            System.out.print("Wat is de naam van speler" +(i+1)+"? ");
            String naam = input.next();
            System.out.print("Hoeveel geld heeft de speler" +(i+1)+ "? ");
            int geld = input.nextInt();
            spelers[i] = new Speler(naam,geld);
        }

        //elke speler die nog geld heeft krijgt een prompt om geld in te zetten
        //er wordt ook gekeken of de inzet niet
        for (int i = 0; i < aantalSpelers; i++) {
            if (spelers[i].getGeld() > 0){
                int inzet;
                do {
                    System.out.print("Hoeveel wil je inzetten " + spelers[i].getNaam() + ", je hebt nog " + spelers[i].getGeld()+ ": ");
                    inzet = input.nextInt();
                    spelers[i].setInzet(inzet);
                } while (inzet <= 0 || inzet > spelers[i].getGeld());
            }
        }

        //elke speler die nog geld heeft krijgt 2 kaarten in zijn hand + de dealer krijgt ook zijn 2 kaarten
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < aantalSpelers; j++) {
                if (spelers[j].getGeld() > 0){
                    spelers[j].voegKaartToe(pakKaarten.volgendeKaart());
                }
            }
            dealer.voegKaartToe(pakKaarten.volgendeKaart());
        }

        System.out.println("De eerste kaart van de dealer is " + dealer.eersteKaart());

        //toont de kaarten aan de speler en laat het totaal zien en laat dan vragen of hij wil hitten of folden
        for (int i = 0; i < aantalSpelers; i++) {
            System.out.println(spelers[i].getNaam() + " dit zijn je kaarten: " + spelers[i].getHand());
            System.out.println("Je totaal is: " + spelers[i].getTotaal());
            char keuze;
            do {
                System.out.print("Wil je een extra kaart(H) of wil je stoppen(F): ");
                keuze = input.next().toUpperCase().charAt(0);
            } while (keuze != 'H' && keuze != 'F');
            if (keuze == 'H'){
                if (spelers[i].getTotaal() >= 21){
                    //methode vergelijk dealer ofzo
                }
                while (keuze == 'H' && spelers[i].getTotaal() < 21) {
                    spelers[i].voegKaartToe(pakKaarten.volgendeKaart());
                    System.out.println("Dit is je nieuwe hand: " + spelers[i].getHand());
                    System.out.println("Je totaal is: " + spelers[i].getTotaal());
                    do {
                        System.out.print("Wil je een extra kaart(H) of wil je stoppen(F): ");
                        keuze = input.next().toUpperCase().charAt(0);
                    } while (keuze != 'H' && keuze != 'F');
                }
            }
        }

        //hier speelt de dealer
        while(dealer.getTotaal() < 17){
            System.out.println("De dealer heeft " + dealer);
        }


        //printen van de spelers
        System.out.print("array van spelers" + Arrays.toString(spelers));
        System.out.println(dealer);

    }

    public void vergelijkDealer(){

    }
}
