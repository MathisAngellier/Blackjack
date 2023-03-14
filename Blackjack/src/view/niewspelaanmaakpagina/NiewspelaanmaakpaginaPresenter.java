package view.niewspelaanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Spel;
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
        view.getConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO: 14/03/2023  hier moet de output van vraag genomen worden en in aantalspeelers gezet worden
            }
        });
    }

}
