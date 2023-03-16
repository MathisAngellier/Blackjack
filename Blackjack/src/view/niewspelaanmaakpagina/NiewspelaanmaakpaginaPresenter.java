package view.niewspelaanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Spel;
import view.speleraanmaakpagina.SpeleraanmaakpaginaView;
import view.startpagina.StartpaginaView;

public class NiewspelaanmaakpaginaPresenter {
    private Spel model;
    private NiewspelaanmaakpaginaView view;
    private Stage presenter;
    public NiewspelaanmaakpaginaPresenter(Spel blackjack, NiewspelaanmaakpaginaView niewspelaanmaakpaginaView, Stage presenter) {
        this.model = blackjack;
        this.view = niewspelaanmaakpaginaView;
        this.presenter = presenter;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.setAantalSpelers(Integer.parseInt(view.getHoeveelspelers().getText()));
            }
        });
        view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpeleraanmaakpaginaView speleraanmaakpaginaView = new SpeleraanmaakpaginaView();
                Stage stage = presenter;

                presenter.setTitle("Blackjack");

                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(speleraanmaakpaginaView);
                speleraanmaakpaginaView.getScene().getWindow().sizeToScene();
            }
        });
    }
}