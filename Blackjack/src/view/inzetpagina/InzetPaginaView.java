package view.inzetpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class InzetPaginaView extends BorderPane {

    private Button bevestigen;
    private Label geld;
    public InzetPaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        bevestigen = new Button("bevestigen");

        Label label = new Label();


    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        //setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(bevestigen,1,0);
        setTop(gp);

    }


    public Button getBevestigen() {
        return bevestigen;
    }
}
