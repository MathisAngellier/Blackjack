package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeldOphalen {
    public void geldOphalen(){
            try {
        File myObj = new File("geld.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    } catch (
    FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
}
