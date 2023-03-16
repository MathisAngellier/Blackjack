package view.speleraanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class SpeleraanmaakpaginaView extends BorderPane {

    public SpeleraanmaakpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        gp.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
        setTop(gp);
    }

}

