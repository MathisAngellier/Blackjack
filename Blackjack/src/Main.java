import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Spel;
import view.Presenter;
import view.View;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Spel blackjack = new Spel();
        View view = new View();
        Presenter presenter = new Presenter(blackjack, view);
        Scene scene = new Scene(view);
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

