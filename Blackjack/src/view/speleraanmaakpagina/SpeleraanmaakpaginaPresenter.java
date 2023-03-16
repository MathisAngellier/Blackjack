package view.speleraanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Spel;
import model.Speler;

import java.util.ArrayList;

public class SpeleraanmaakpaginaPresenter {
    private Spel model;
    private ArrayList<Speler> spelers = new ArrayList<>();
    private SpeleraanmaakpaginaView view;
    private Stage presenter;
    public SpeleraanmaakpaginaPresenter(Spel blackjack, SpeleraanmaakpaginaView speleraanmaakpaginaView, Stage presenter) {
        this.model = blackjack;
        this.view = speleraanmaakpaginaView;
        this.presenter = presenter;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (int i = 0; i < view.getHoeveelheid(); i++) {
                    String naam = view.getMap().get(i)[0].getText();
                    System.out.println(naam);
                    //int geld = Integer.parseInt(textField2.getText());

                    //Speler speler = new Speler(naam, geld);
                    //spelers.add(speler);
                }

            }
        });

    }

}