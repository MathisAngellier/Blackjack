package view.startpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class StartpaginaView extends BorderPane {
    private Button niewegame;
    private Button loadgame;
    private Label label;
    public StartpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        label = new Label("", new ImageView("recourses/startpaginaAfbeeldingKlein.png"));
        niewegame = new Button("niew");
        loadgame = new Button("load");

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        gp.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        gp.add(niewegame, 0, 0);
        gp.add(loadgame,1,0);
        gp.add(label,0,1);
        setTop(gp);

    }

    public Button getNiewegame() {
        return niewegame;
    }

    public Button getLoadgame() {
        return loadgame;
    }
}
