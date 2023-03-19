package view.resultatenpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Spel;
import model.ReaderWriter;
import view.startpagina.StartpaginaView;

public class Resultatenpaginapresenter {
    private Spel model;
    private ResultatenpaginaView view;
    private Stage stage;
    private ReaderWriter writer;
    public Resultatenpaginapresenter(Spel blackjack, ResultatenpaginaView resultatenpaginaView, Stage stage) {
        this.model = blackjack;
        this.view = resultatenpaginaView;
        this.stage = stage;
        this.addEventHandlers();
    }
    private void addEventHandlers() {

        view.getSave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                writer.saveSpelersArray((model.getSpelersArray()));
            }
        });
        view.getTerugnaarstart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartpaginaView startpaginaView = new StartpaginaView();
                Scene scene = new Scene(startpaginaView);

                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(startpaginaView);
                startpaginaView.getScene().getWindow().sizeToScene();
            }
        });
    }

}
