package view.speleraanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Spel;
import model.Speler;
import view.inzetpagina.InzetPaginaView;
import view.inzetpagina.InzetpaginaPresenter;

import java.util.ArrayList;

public class SpeleraanmaakpaginaPresenter {
    private Spel model;
    private ArrayList<Speler> spelers = new ArrayList<>();
    private SpeleraanmaakpaginaView view;
    private Stage stage;
    public SpeleraanmaakpaginaPresenter(Spel blackjack, SpeleraanmaakpaginaView speleraanmaakpaginaView, Stage stage) {
        this.model = blackjack;
        this.view = speleraanmaakpaginaView;
        this.stage = stage;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    for (Label key : view.getMap().keySet()) {
                        String naam = view.getMap().get(key)[0].getText();
                        System.out.println(naam);
                        int geld = Integer.parseInt(view.getMap().get(key)[1].getText());

                        Speler speler = new Speler(naam, geld);
                        spelers.add(speler);
                    }
                    System.out.println(spelers);
                    InzetPaginaView inzetpaginaView = new InzetPaginaView();
                    InzetpaginaPresenter inzetpaginaPresenter = new InzetpaginaPresenter(model, inzetpaginaView,stage);
                    stage.setHeight(450);
                    stage.setWidth(800);
                    stage.setResizable(false);
                    stage.setTitle("Blackjack");

                    //Om te kunnen switchen van mainView naar Applicatie
                    view.getScene().setRoot(inzetpaginaView);
                    inzetpaginaView.getScene().getWindow();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("foutmelding");
                    alert.setContentText("geef een geheel getal bij geld.");
                    alert.showAndWait();
                }

            }
        });

    }

}