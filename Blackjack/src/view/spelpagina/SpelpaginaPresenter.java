package view.spelpagina;

import javafx.stage.Stage;
import model.Dealer;
import model.Spel;
import model.Speler;
import view.niewspelaanmaakpagina.NiewspelaanmaakpaginaView;

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
        view.getFoldButton().setOnAction(event -> stand());
    }

    private void deelKaartenUit(){
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
            view.setLabel(speler.get(i).getNaam());
            view.updatePlayerCards(speler.get(i));
        }

    }

    private void addEventHandlers() {

    }
}
