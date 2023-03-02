package view.startpagina;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StartpaginaView extends BorderPane {
    private Button niewegame;
    private Button loadgame;
    public StartpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        niewegame = new Button("niew");
        loadgame = new Button("load");

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        gp.add(niewegame, 0, 0);
        gp.add(loadgame,1,0);
        setCenter(gp);

    }

}
