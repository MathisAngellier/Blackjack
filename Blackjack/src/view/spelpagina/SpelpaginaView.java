package view.spelpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Dealer;
import model.Kaart;
import model.Speler;

import static javax.swing.text.StyleConstants.setBackground;

public class SpelpaginaView extends BorderPane {

    private Button hit;
    private Button fold;
    private Label aantalGeld;
    private Label naamSpeler;
    private Label dealer;
    private Speler speler;
    private Kaart kaart;


    public SpelpaginaView() {
        layoutNodes();
        initialiseNodes();
    }

    private void initialiseNodes() {
        fold = new Button("Fold");
        hit = new Button("Hit");
        aantalGeld = new Label(""+ speler.getGeld());
        naamSpeler = new Label(speler.getNaam());
        dealer = new Label("Dealer");

    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        setBackground(new Background(new BackgroundImage(new Image("recourses/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(fold, 0, 0);
        gp.add(hit,1,0);
        gp.add(aantalGeld,3,0);
        gp.add(naamSpeler,2,2);
        gp.add(dealer,1,1);

    }

}
