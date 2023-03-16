package view.resultatenpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ResultatenpaginaView extends BorderPane {
    private Button terugnaarstart;
    public ResultatenpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        terugnaarstart = new Button("Terug naar start.");

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        setBackground(new Background(new BackgroundImage(new Image("recourses/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(terugnaarstart,0,0);
        setTop(gp);

    }
}
