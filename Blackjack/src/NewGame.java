import java.io.File;
import java.io.IOException;

//hier maken we een bestand aan om het geld van alle spelers bij te houden
public class NewGame {

    public void insert(){
        try {
            File myObj = new File("geld.txt");
            if (myObj.createNewFile()) {
                System.out.println("Bestand aangemaakt: " + myObj.getName());
            } else {
                System.out.println("bestand bestaat al.");
            }
        } catch (IOException e){
            System.out.println("Er is een fout gebeurt.");
            e.printStackTrace();
        }
    }
}