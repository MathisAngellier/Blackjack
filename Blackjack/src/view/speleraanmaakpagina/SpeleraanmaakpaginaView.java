package view.speleraanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SpeleraanmaakpaginaView extends BorderPane {
    private HashMap<Label, TextField[]> map = new HashMap<>();
    private Button bevestigen;
    private int hoeveelheid;

    public SpeleraanmaakpaginaView(int  hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
        initialiseNodes(hoeveelheid);
        layoutNodes();
    }
    private void initialiseNodes(int hoeveelheid) {
        bevestigen = new Button("bevestigen");
    }
    private void layoutNodes() {
        VBox fields = new VBox();
        setCenter(fields);
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        for (int i = 1; i <= hoeveelheid; i++) {
            Label label = new Label("Speler " + i);
            TextField textField1 = new TextField();
            TextField textField2 = new TextField();

            TextField[] textFields = {textField1, textField2};
            map.put(label, textFields);
            fields.getChildren().addAll(label, textField1, textField2);
            fields.getChildren().add(bevestigen);
        }
    }

    public HashMap<Label, TextField[]> getMap() {
        return map;
    }

    public Button getBevestigen() {
        return bevestigen;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }
}

