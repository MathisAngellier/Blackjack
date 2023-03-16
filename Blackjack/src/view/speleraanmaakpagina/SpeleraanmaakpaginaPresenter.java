package view.speleraanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Spel;
import model.Speler;

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

                   /* // Loop through the keys in the map using a for-each loop
                    for (Label key : view.getMap().keySet()) {
                        // Retrieve the value associated with the current key
                        Object value = view.getMap().get(key);

                        // Do something with the retrieved value
                        if (value != null) {
                            // Value was found in the map
                            System.out.println("Value for " + key + ": " + value);
                        } else {
                            // Value was not found in the map
                            System.out.println(key + " not found in map");
                        }
                    }
                                    for (int i = 0; i < view.getHoeveelheid(); i++) {
                    String spelerid = ("speler"+i);
                    String naam = view.getMap().get(spelerid)[0].getText();
                    System.out.println(naam);
                    int geld = Integer.parseInt(view.getMap().get(spelerid)[1].getText());

                    Speler speler = new Speler(naam, geld);
                    spelers.add(speler);
                }

                    */
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