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

/*public class ReaderWriter {
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
    private static final String FILENAME = "model/spelersArray.txt" ;

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

