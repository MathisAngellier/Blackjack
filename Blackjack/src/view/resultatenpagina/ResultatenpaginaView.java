package view.resultatenpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ResultatenpaginaView extends BorderPane {
    private Button startpagina;
    public ResultatenpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        startpagina = new Button("startpagina");

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        gp.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        gp.add(startpagina, 0, 0);
        setTop(gp);

    }

    public Button getNiewegame() {
        return startpagina;
    }

}
