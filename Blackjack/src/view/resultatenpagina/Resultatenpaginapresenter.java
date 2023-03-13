package view.resultatenpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Spel;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;
import view.startpagina.StartpaginaView;

public class Resultatenpaginapresenter {
    private Spel model;
    private StartpaginaView view;
    private Stage presenter;
    public Resultatenpaginapresenter(Spel blackjack, StartpaginaView startpaginaView, Stage presenter) {
        this.model = blackjack;
        this.view = startpaginaView;
        this.presenter = presenter;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        view.getNiewegame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartpaginaView startpaginaView = new StartpaginaView();
                Stage keuzePr = presenter;

                presenter.setTitle("Applicatie");

                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(startpaginaView);
                startpaginaView.getScene().getWindow().sizeToScene();
            }
        });
    }

}
