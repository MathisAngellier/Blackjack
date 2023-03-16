package view.niewspelaanmaakpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Spel;
import view.speleraanmaakpagina.SpeleraanmaakpaginaView;

public class NiewspelaanmaakpaginaPresenter {
    private Spel model;
    private NiewspelaanmaakpaginaView view;
    private Stage stage;


    public NiewspelaanmaakpaginaPresenter(Spel blackjack, NiewspelaanmaakpaginaView niewspelaanmaakpaginaView,Stage stage) {
        this.model = blackjack;
        this.view = niewspelaanmaakpaginaView;
        this.stage = stage;
        this.addEventHandlers();
    }

    private void addEventHandlers () {
            view.getBevestigen().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        System.out.println(view.getHoeveelspelers().getText());
                        int hoeveelheid = (Integer.parseInt(view.getHoeveelspelers().getText()));
                        SpeleraanmaakpaginaView speleraanmaakpaginaView = new SpeleraanmaakpaginaView(hoeveelheid);
                        stage.setHeight(450);
                        stage.setWidth(800);
                        stage.setResizable(false);
                        stage.setTitle("Blackjack");

                        //Om te kunnen switchen van mainView naar Applicatie
                        view.getScene().setRoot(speleraanmaakpaginaView);
                        speleraanmaakpaginaView.getScene().getWindow();

                    } catch (NumberFormatException e) {
                        System.out.println("bb");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("foutmelding");
                        alert.setContentText("geef een geheel getal tussen 1 en 5.");
                        alert.showAndWait();
                    }
                }
            });
        }

}