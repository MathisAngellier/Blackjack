import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DemoBlackjack {
    public static void main(String[] args) {

        Speler[] spelers = new Speler[5];
        Scanner input = new Scanner(System.in);
        System.out.println("Welkom bij het spel BLACKJACK");
        int aantalSpelers = 0;
        do {
            System.out.print("Met hoeveel spelers wil je spelen? ");
            aantalSpelers = input.nextInt();
        } while (aantalSpelers <= 0 || aantalSpelers > 5);

        String naam = "";
        double geld = 0;

        for (int i = 0; i < aantalSpelers; i++) {
            System.out.print("Wat is de naam van speler" +(i+1)+"? ");
            naam = input.next();
            System.out.print("Hoeveel geld heeft de speler" +(i+1)+ "? ");
            geld = input.nextDouble();
            spelers[i] = new Speler(naam,geld);
        }
        System.out.print("array van spelers" + Arrays.toString(spelers));
    }
}
