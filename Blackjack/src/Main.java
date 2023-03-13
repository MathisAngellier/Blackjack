import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Spel;
import view.startpagina.StartpaginaPresenter;
import view.startpagina.StartpaginaView;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Spel blackjack = new   Spel();
        StartpaginaView startpaginaView = new StartpaginaView();
        StartpaginaPresenter presenter = new StartpaginaPresenter(blackjack, startpaginaView,stage);
        Scene scene = new Scene(startpaginaView);
        stage.setTitle("Blackjack");
        stage.setHeight(450);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

