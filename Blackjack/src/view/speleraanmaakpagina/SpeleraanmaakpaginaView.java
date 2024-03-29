package view.speleraanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashMap;


public class SpeleraanmaakpaginaView extends BorderPane {
    private HashMap<Label, TextField[]> map = new HashMap<>();
    private Button bevestigen;
    private int hoeveelheid;

    public SpeleraanmaakpaginaView(int  hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        bevestigen = new Button("bevestigen");
    }
    private void layoutNodes() {
        VBox v = new VBox();
        setCenter(v);
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        for (int i = 1; i <= hoeveelheid; i++) {
            Label label = new Label("Speler " + i);
            label.setTextFill(Color.WHITE);
            TextField textField1 = new TextField("naam");
            TextField textField2 = new TextField("geld in €");
            TextField[] textFields = {textField1, textField2};
            map.put(label, textFields);
            v.getChildren().addAll(label, textField1, textField2);
        }
        v.getChildren().add(bevestigen);
    }

    public HashMap<Label, TextField[]> getMap() {
        return map;
    }

    public Button getBevestigen() {
        return bevestigen;
    }

}

