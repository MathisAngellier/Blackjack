import java.util.Scanner;

public class DemoBlackjack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welkom bij het spel BLACKJACK");
        int aantalSpelers = 0;
        do {
            System.out.print("Met hoeveel spelers wil je spelen? ");
            aantalSpelers = input.nextInt();
        } while (aantalSpelers <= 0 || aantalSpelers > 5);

        String naam;
        double geld;

        for (int i = 0; i < aantalSpelers; i++) {
            System.out.print("Wat is de naam van de speler? ");
            naam = input.nextLine();
            System.out.print("Hoeveel geld heeft de speler? ");
            geld = input.nextDouble();
            Speler s1 = new Speler(naam,geld);

        }





    }
}
