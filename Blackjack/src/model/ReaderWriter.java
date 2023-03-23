package model;

import java.io.*;

public class ReaderWriter {
    private Spel spel;
    private String spelersFile;

    public ReaderWriter(Spel spel) {
        this.spel = spel;
        this.spelersFile = "spelers.txt";
    }

    public void saveSpelers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(spelersFile))) {
            for (Speler speler : spel.getSpelersArray()) {
                writer.write(speler.getNaam() + "," + speler.getGeld() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSpelers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(spelersFile))) {
            String line;
            Speler[] spelersArray = new Speler[100]; // assuming a maximum of 100 players
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String naam = parts[0];
                int score = Integer.parseInt(parts[1]);
                spelersArray[i] = new Speler(naam, score);
                i++;
            }
            spel.setSpelersArray(spelersArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
