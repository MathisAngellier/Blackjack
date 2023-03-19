package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriter {
    private String fileName = "spelersArray.txt";

    public void saveSpelersArray(Speler[] spelersArray) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Speler speler : spelersArray) {
                writer.write(speler.getNaam() + "," + speler.getGeld() + "\n");
            }
            writer.close();
            System.out.println("Spelers array saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving spelers array to file: " + fileName);
            e.printStackTrace();
        }
    }

    public Speler[] loadSpelersArray() {
        List<Speler> spelersList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String naam = parts[0];
                    int geld = Integer.parseInt(parts[1]);
                    Speler speler = new Speler(naam, geld);
                    spelersList.add(speler);
                }
            }
            reader.close();
            System.out.println("Spelers array loaded from file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error loading spelers array from file: " + fileName);
            e.printStackTrace();
        }
        return spelersList.toArray(new Speler[0]);
    }
}
    /*private static final String FILENAME = "model/spelersArray.txt" ;

    public static void writeToFile(List<Speler> spelersArray) throws IOException {
        File file = new File(FILENAME);
        FileWriter writer = new FileWriter(file);

        for (Speler speler : spelersArray) {
            writer.write(speler.getNaam() + "," + speler.getGeld() + "\n");
        }

        writer.close();
    }

    public static String readFromFile() throws IOException {
        File file = new File(FILENAME);
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }

        scanner.close();
        return sb.toString();
    }*/

