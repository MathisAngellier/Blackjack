package view.niewspelaanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class NiewspelaanmaakpaginaView extends BorderPane {
    private TextField hoeveelspelers;
    public NiewspelaanmaakpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        hoeveelspelers = new TextField("met hoeveel wilt u spelen?");

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        gp.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
        gp.add(hoeveelspelers,0,0);
        GridPane.setColumnSpan(hoeveelspelers, GridPane.REMAINING);
        setTop(gp);
    }
}

