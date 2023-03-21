package view.spelpagina;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Dealer;
import model.Spel;
import model.Speler;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;
import view.resultatenpagina.ResultatenpaginaView;
import view.resultatenpagina.Resultatenpaginapresenter;

import java.util.Arrays;
import java.util.List;

public class SpelpaginaPresenter {

    private Spel model;
    private SpelpaginaView view;
    private Stage presenter;
    public SpelpaginaPresenter(Spel model, SpelpaginaView view, Stage presenter) {
        this.model = model;
        this.view = view;
        this.presenter = presenter;
        this.addEventHandlers();
    }
    private void addEventHandlers() {
        view.getDealButton().setOnAction(event -> deelKaartenUit());
        view.getStandButton().setOnAction(event -> stand());
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
