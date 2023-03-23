package view.resultatenpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Spel;
import model.Speler;

public class ResultatenpaginaView extends BorderPane {
    private GridPane gp;
    private VBox vbox;
    private VBox top;
    private Spel model;
    private Label titel;
    private Button terugnaarstart;
    private Button save;
    public ResultatenpaginaView() {
        this.gp = new GridPane();
        this.vbox = new VBox();
        this.top = new VBox();
        this.model = new Spel();
        initialiseNodes();
        layoutNodes();
        displayLabels();
    }
    private void initialiseNodes() {
        terugnaarstart = new Button("Terug naar start");
        titel = new Label("resultaten:");
        save = new Button("opslaan");

    }
    private void layoutNodes() {
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        vbox.getChildren().add(terugnaarstart);
        vbox.getChildren().add(save);
        top.getChildren().add(titel);
        titel.setTextFill(Color.WHITE);
        titel.setFont(Font.font(30));

        setTop(top);
        setBottom(vbox);
        setCenter(gp);

    }
    public void displayLabels() {
        // Iterate over the array of Speler objects in the model and create a label for each naam and geld value
        int row = 0;
        for (Speler speler : model.getSpelersArray()) {
            Label naamLabel = new Label(speler.getNaam());
            Label geldLabel = new Label(" totaal €"+ (speler.getGeld()));
            naamLabel.setTextFill(Color.WHITE);
            geldLabel.setTextFill(Color.WHITE);
            gp.add(naamLabel, 0, row);
            gp.add(geldLabel, 1, row);
            row++;
        }
    }

    public Button getTerugnaarstart() {
        return terugnaarstart;
    }

    public Button getSave() {
        return save;
    }

}
