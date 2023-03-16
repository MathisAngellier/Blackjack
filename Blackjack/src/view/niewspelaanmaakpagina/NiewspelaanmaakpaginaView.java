package view.niewspelaanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class NiewspelaanmaakpaginaView extends BorderPane {
    private Label vraagspelers;
    private TextField hoeveelspelers;
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
        gp.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
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

