package view.spelpagina;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        view.getDealButton().setOnAction(event -> deelKaartenUit());
        view.getHitButton().setOnAction(event -> hit());
        view.getStandButton().setOnAction(event -> stand());
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

    private void addEventHandlers() {
//        view.getFoldButton().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //view.saveInzet();
//
//                System.out.println(Arrays.toString(model.spelersArray));
//
//                ResultatenpaginaView resultatenpaginaView = new ResultatenpaginaView();
//                Resultatenpaginapresenter resultatenpaginapresenter = new Resultatenpaginapresenter(model , resultatenpaginaView, presenter);
//                presenter.setTitle("Blackjack");
//                presenter.setHeight(700);
//                presenter.setWidth(1400);
//                //Om te kunnen switchen van mainView naar Applicatie
//                view.getScene().setRoot(resultatenpaginaView);
//                resultatenpaginaView.getScene().getWindow();
//            }
//        });
    }
}
