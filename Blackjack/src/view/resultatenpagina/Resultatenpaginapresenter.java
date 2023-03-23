package view.resultatenpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Spel;
import model.ReaderWriter;
import view.startpagina.StartpaginaPresenter;
import view.startpagina.StartpaginaView;

public class Resultatenpaginapresenter {
    private Spel model;
    private ResultatenpaginaView view;
    private Stage stage;
    private ReaderWriter readerWriter;
    public Resultatenpaginapresenter(Spel blackjack, ResultatenpaginaView resultatenpaginaView, Stage stage) {
        this.model = blackjack;
        this.view = resultatenpaginaView;
        this.stage = stage;
        this.readerWriter = new ReaderWriter(model);
        this.addEventHandlers();
    }
    private void addEventHandlers() {

        view.getSave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                readerWriter.saveSpelers();
            }
        });
        view.getTerugnaarstart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartpaginaView startpaginaView1 = new StartpaginaView();
                StartpaginaPresenter startpaginaPresenter = new StartpaginaPresenter(model,startpaginaView1,stage);
                stage.setHeight(450);
                stage.setWidth(800);
                stage.setResizable(false);
                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(startpaginaView1);
            }
        });
    }

}
