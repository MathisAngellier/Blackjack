package view.speleraanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Spel;

public class SpeleraanmaakpaginaPresenter {
    private Spel model;

    private SpeleraanmaakpaginaView view;
    private Stage presenter;
    public SpeleraanmaakpaginaPresenter(Spel blackjack, SpeleraanmaakpaginaView speleraanmaakpaginaView, Stage presenter) {
        this.model = blackjack;
        this.view = speleraanmaakpaginaView;
        this.presenter = presenter;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        for (int i = 0; i < model.getAantalSpelers(); i++) {

        }
    }

}