package view.inzetpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Spel;
import model.Speler;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaPresenter;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;


public class InzetpaginaPresenter {
    private Spel model;
    private InzetPaginaView view;
    private Stage stage;



    public InzetpaginaPresenter(Spel blackjack, InzetPaginaView inzetPaninaView, Stage stage) {
        this.model = blackjack;
        this.view = inzetPaninaView;
        this.stage = stage;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NiewspelaanmaakpaginaView niewspelaanmaakpaginaView = new NiewspelaanmaakpaginaView();
                NiewspelaanmaakpaginaPresenter niewspelaanmaakpaginaPresenter = new NiewspelaanmaakpaginaPresenter(model , niewspelaanmaakpaginaView, stage);
                stage.setTitle("Applicatie");

                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(niewspelaanmaakpaginaView);
                niewspelaanmaakpaginaView.getScene().getWindow();
            }
        });
    }

}