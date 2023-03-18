package view.inzetpagina;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Spel;
import model.Speler;

import java.util.ArrayList;
import java.util.List;


public class InzetPaginaView extends BorderPane {

    private GridPane top;
    private GridPane gp;
    private GridPane bottom;
    private Spel model;
    private List<TextField> inzetFields;

    private Button bevestigen;


    public InzetPaginaView() {
        this.top = new GridPane();
        this.gp = new GridPane();
        this.bottom = new GridPane();
        this.model = new Spel();
        this.inzetFields = new ArrayList<>();
        initialiseNodes();
        layoutNodes();
        displayLabels();
    }

    private void initialiseNodes() {
        bevestigen = new Button("bevestigen");
    }

    private void layoutNodes() {
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"), null, null, null, null)));
        bottom.add(bevestigen, 0, 0);
        setTop(top);
        setCenter(gp);
        setBottom(bottom);

    }


    public void displayLabels() {
        // Iterate over the array of Speler objects in the model and create a label for each naam and geld value
        int row = 0;
        for (Speler speler : model.getSpelersArray()) {
            Label naamLabel = new Label(speler.getNaam());
            Label geldLabel = new Label(" totaal €"+ String.valueOf(speler.getGeld()));
            Label inzetLabel = new Label(" inzet :");
            TextField inzetfield = new TextField();
            naamLabel.setTextFill(Color.WHITE);
            geldLabel.setTextFill(Color.WHITE);
            inzetLabel.setTextFill(Color.WHITE);
            gp.add(naamLabel, 0, row);
            gp.add(geldLabel, 1, row);
            gp.add(inzetLabel,2,row);
            gp.add(inzetfield,3,row);
            inzetFields.add(inzetfield); // add the inzetfield to the list of inzet fields
            System.out.println(model.getSpelersArray().length);
            row++;
        }
    }
    public Button getBevestigen() {
        return bevestigen;
    }
    public void saveInzet() {
        int row = 0;
        for (Speler speler : model.getSpelersArray()) {
            TextField inzetfield = (TextField) gp.getChildren().get(row * 4 + 3);
            try {
                int inzet = Integer.parseInt(inzetfield.getText());
                if (inzet <= speler.getGeld()) {
                    speler.setInzet(inzet);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Inzet is meer dan het beschikbare geld.");
                    alert.showAndWait();
                    return;
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ongeldige inzet waarde.");
                alert.showAndWait();
                return;
            }
            row++;
        }
    }



    public GridPane getGp() {
        return gp;
    }


    public Spel getModel() {
        return model;
    }
}
