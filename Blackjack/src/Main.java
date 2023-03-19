import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Spel;
import view.resultatenpagina.ResultatenpaginaView;
import view.resultatenpagina.Resultatenpaginapresenter;
import view.speleraanmaakpagina.SpeleraanmaakpaginaPresenter;
import view.speleraanmaakpagina.SpeleraanmaakpaginaView;
import view.spelpagina.SpelpaginaPresenter;
import view.spelpagina.SpelpaginaView;
import view.startpagina.StartpaginaPresenter;
import view.startpagina.StartpaginaView;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Spel blackjack = new Spel();
        StartpaginaView startpaginaView = new StartpaginaView();
        StartpaginaPresenter presenter = new StartpaginaPresenter(blackjack, startpaginaView,stage);
        Scene scene = new Scene(startpaginaView);
        stage.setTitle("Blackjack");
        stage.setHeight(450);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
//    @Override
//    public void start(Stage stage) throws Exception {
//        //test main
//        Spel blackjack = new   Spel();
//         ResultatenpaginaView resultatenpaginaView = new ResultatenpaginaView();
//         Resultatenpaginapresenter resultatenpaginapresenter = new Resultatenpaginapresenter(blackjack , resultatenpaginaView, stage);
//
//        Scene scene = new Scene(resultatenpaginaView);
//        stage.setTitle("Blackjack");
//        stage.setHeight(450);
//        stage.setWidth(800);
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        launch(args);
    }
}

