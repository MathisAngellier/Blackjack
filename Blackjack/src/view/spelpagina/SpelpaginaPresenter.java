package view.spelpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Dealer;
import model.Spel;
import model.Speler;
import view.resultatenpagina.ResultatenpaginaView;
import view.resultatenpagina.Resultatenpaginapresenter;

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
                ResultatenpaginaView resultatenpaginaView = new ResultatenpaginaView();
                Resultatenpaginapresenter resultatenpaginapresenter = new Resultatenpaginapresenter(model, resultatenpaginaView,stage);
                stage.setHeight(450);
                stage.setWidth(800);
                stage.setResizable(false);
                stage.setTitle("Blackjack");

                //Om te kunnen switchen van mainView naar Applicatie
                view.getScene().setRoot(resultatenpaginaView);
                resultatenpaginaView.getScene().getWindow();
            }
        });
        view.getVolgendeBeurt().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deelKaartenUit();
            }
        });
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
