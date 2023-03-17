package view.inzetpagina;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import model.Spel;
import model.Speler;

import java.util.ArrayList;
import java.util.List;


public class InzetPaginaView extends BorderPane {


    private GridPane gp;
    private Spel model;

    private Button bevestigen;


    public InzetPaginaView() {
        this.gp = new GridPane();
        this.model = new Spel();
        initialiseNodes();
        layoutNodes();
        displayLabels();
    }

    private void initialiseNodes() {
        bevestigen = new Button("bevestigen");
    }

    private void layoutNodes() {
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"), null, null, null, null)));
        gp.add(bevestigen, 0, 0);
        setTop(gp);

    }

    public void displayLabels() {
        // Iterate over the array of Speler objects in the model and create a label for each naam and geld value
        int row = 0;
        for (Speler speler : model.getSpelersArray()) {
            Label naamLabel = new Label(speler.getNaam());
            Label geldLabel = new Label(String.valueOf(speler.getGeld()));
            gp.add(naamLabel, 0, row);
            gp.add(geldLabel, 1, row);
            row++;
        }
    }
    public Button getBevestigen() {
        return bevestigen;
    }

}