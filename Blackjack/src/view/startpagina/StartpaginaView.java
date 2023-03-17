package view.startpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StartpaginaView extends BorderPane {
    private Button niewegame;
    private Button loadgame;
    private Label label;
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
        //setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        setBackground(new Background(new BackgroundImage(new Image("resources/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(niewegame, 0, 0);
        gp.add(loadgame,1,0);
        setTop(gp);

    }

    public Button getNiewegame() {
        return niewegame;
    }

    public Button getLoadgame() {
        return loadgame;
    }
}
