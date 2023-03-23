package view.inzetpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Spel;
import view.spelpagina.SpelpaginaPresenter;
import view.spelpagina.SpelpaginaView;


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
                view.saveInzet();
                SpelpaginaView spelpaginaView = new SpelpaginaView();
                SpelpaginaPresenter spelpaginaPresenter = new SpelpaginaPresenter(model , spelpaginaView, stage);
                stage.setTitle("Blackjack");
                stage.setHeight(700);
                stage.setWidth(1300);
                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(spelpaginaView);
                spelpaginaView.getScene().getWindow();
                spelpaginaPresenter.deelKaartenUit();
            }
        });
    }

}