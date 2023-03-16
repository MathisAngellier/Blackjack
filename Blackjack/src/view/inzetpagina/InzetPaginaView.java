package view.inzetpagina;

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
    public GridPane getGp() {
        return gp;
    }



    private void initialiseNodes() {
        bevestigen = new Button("bevestigen");
    }

    private void layoutNodes() {
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(bevestigen,0,2);
        setTop(gp);

    }
    public void setLabels(List<String> namen, List<Integer> geld) {
        gp.getChildren().clear();
        for (int i = 0; i < namen.size(); i++) {
            Label naamLabel = new Label(namen.get(i));
            Label geldLabel = new Label(geld.get(i).toString());
            gp.add(naamLabel, 0, i+1);
            gp.add(geldLabel, 1, i+1);
        }
    }


    public Button getBevestigen() {
        return bevestigen;
    }

}
