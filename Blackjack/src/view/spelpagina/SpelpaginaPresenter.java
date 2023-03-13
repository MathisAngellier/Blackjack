package view.spelpagina;

import javafx.stage.Stage;
import model.Spel;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;

public class SpelpaginaPresenter {

    private Spel model;
    private SpelpaginaView view;
    private Stage presenter;
    public SpelpaginaPresenter(Spel blackjack, SpelpaginaView view, Stage presenter) {
        this.model = blackjack;
        this.view = view;
        this.presenter = presenter;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
    }
}
