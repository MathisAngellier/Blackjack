package view.startpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.ReaderWriter;
import model.Spel;
import view.inzetpagina.InzetPaginaView;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaPresenter;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;



public class  StartpaginaPresenter {
    private Spel model;
    private StartpaginaView view;
    private ReaderWriter readerWriter;
    private Stage stage;
    public StartpaginaPresenter(Spel blackjack, StartpaginaView startpaginaView, Stage stage) {
        this.model = blackjack;
        this.view = startpaginaView;
        this.stage = stage;
        this.readerWriter = new ReaderWriter(model);
        this.addEventHandlers();
    }
    private void addEventHandlers() {
            view.getNiewegame().setOnAction(new EventHandler<ActionEvent>() {
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
            view.getLoadgame().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    readerWriter.loadSpelers();

                    InzetPaginaView inzetPaginaView = new InzetPaginaView();
                    //InzetpaginaPresenter inzetpaginaPresenter = new InzetpaginaPresenter(model , inzetPaginaView, stage);
                    stage.setTitle("Applicatie");

                    //Om te kunnen switchen van mainView naar Applicatie
                    view.getScene().setRoot(inzetPaginaView);
                    inzetPaginaView.getScene().getWindow();
                }
            });

        }

}

