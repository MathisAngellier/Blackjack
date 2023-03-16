package view.niewspelaanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class NiewspelaanmaakpaginaView extends BorderPane {
     private TextField hoeveelspelers;
     private Label vraagspelers;
    private Button bevestigen;

    public NiewspelaanmaakpaginaView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        hoeveelspelers = new TextField();
        vraagspelers = new Label("met hoeveel spelers wilt u spelen (max 5)");
        bevestigen = new Button("Bevestigen");
    }

    private void layoutNodes() {
        GridPane gp = new GridPane();
        setBackground(new Background(new BackgroundImage(new Image("recourses/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(hoeveelspelers, 0, 1);
        gp.add(vraagspelers, 0, 0);
        gp.add(bevestigen, 0, 2);
        GridPane.setColumnSpan(hoeveelspelers, GridPane.REMAINING);
        setTop(gp);
    }

    public TextField getHoeveelspelers() {
        return hoeveelspelers;
    }

    public Button getBevestigen() {
        return bevestigen;
    }
}

