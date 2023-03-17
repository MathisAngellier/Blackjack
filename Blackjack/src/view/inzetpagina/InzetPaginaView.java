package view.inzetpagina;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.List;

public class InzetPaginaView extends BorderPane {
    private GridPane gp;

    private Button bevestigen;



    public InzetPaginaView() {
        this.gp = new GridPane();
        initialiseNodes();
        layoutNodes();
    }
    public void addToGrid(String naam, int geld, int rowIndex) {
        Label nameLabel = new Label(naam);
        Label geldLabel = new Label(Integer.toString(geld));
        gp.add(nameLabel, 0, rowIndex);
        gp.add(geldLabel, 1, rowIndex);
    }

    private void initialiseNodes() {
        bevestigen = new Button("bevestigen");
    }

    private void layoutNodes() {
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        setTop(gp);

    }

    public Button getBevestigen() {
        return bevestigen;
    }

}
