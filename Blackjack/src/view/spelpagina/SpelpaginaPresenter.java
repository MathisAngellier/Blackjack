package view.spelpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Dealer;
import model.Spel;
import model.Speler;

import java.util.List;

public class SpelpaginaPresenter {

    private Spel model;
    Spel spel = new Spel();

    private boolean winnaar;
    private SpelpaginaView view;
    private Stage stage;
    private boolean isWinnaar;
    public SpelpaginaPresenter(Spel model, SpelpaginaView view, Stage stage) {
        this.model = model;
        this.view = view;
        this.stage = stage;
        this.addEventHandlers();
    }

    public void setWinnaar(boolean winnaar) {
        this.winnaar = winnaar;
    }

    private void addEventHandlers() {
        view.getStoppen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        view.getVolgendeSpeler().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        view.getDealButton().setOnAction(event -> deelKaartenUit());
        view.getStandButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stand();
                if (winnaar = true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ronde gedaan");
                alert.setContentText("u heeft gewonnen!");
                alert.showAndWait();
                }else if (winnaar = false){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Ronde gedaan");
                    alert.setContentText("u heeft verloren.");
                    alert.showAndWait();
                }
                view.getRechts().setVisible(true);
            }
        });

        view.getHitButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hit();
            }
        });
    }

    public void deelKaartenUit(){
        model.deelKaartenUit(this);
    }
    private void hit (){
        model.hit(this);
    }

    private void stand(){
        model.stand(this);
    }


    public void updateView(){
        List<Speler> speler = model.getSpelers();
        Dealer dealer = model.getDealer();

        for (int i = 0; i < model.getSpelers().size(); i++) {
            //view.setLabel(speler.get(i).getNaam());
            view.updatePlayerCards(speler.get(i));
            view.updateDealerCards(dealer);
            view.updatePlayerScore(speler.get(i).getTotaal());
            view.updateDealerScore(dealer.getTotaal());
        }

    }

}
