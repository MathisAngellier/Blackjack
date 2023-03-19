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
    }

    private void deelKaartenUit(){
        model.deelKaartenUit();
    }
    private void hit (){
        model.hit();
    }

    private void stand(){
        model.stand();
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
