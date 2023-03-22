package view.inzetpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Spel;
import model.Speler;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaPresenter;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;
import view.spelpagina.SpelpaginaPresenter;
import view.spelpagina.SpelpaginaView;

import java.util.Arrays;
import java.util.List;


public class InzetpaginaPresenter {
    private Spel model;
    private InzetPaginaView view;
    private Stage stage;



    public InzetpaginaPresenter(Spel blackjack, InzetPaginaView inzetPaninaView, Stage stage) {
        this.model = blackjack;
        System.out.println(model);
        this.view = inzetPaninaView;
        this.stage = stage;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.saveInzet();

                System.out.println(Arrays.toString(model.spelersArray));

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