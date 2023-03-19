package view.spelpagina;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Kaart;
import model.Speler;

public class SpelpaginaView extends BorderPane {

    private Button hit;
    private Button fold;
    private Button deal;
    private Label aantalGeld;
    private Label naamSpeler;
    private Label dealer;
    private Speler speler;
    private Kaart kaart;
    private ImageView spelerKaarten;
    private ImageView dealerKaarten;
    private GridPane spelerKaartenPane;


    public SpelpaginaView() {
        layoutNodes();
        initialiseNodes();
    }

    private void initialiseNodes() {
        fold = new Button("Fold");
        hit = new Button("Hit");
        deal = new Button("Deal");
    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        spelerKaartenPane = new GridPane();
        //setBottom(spelerKaartenPane);
        setBackground(new Background(new BackgroundImage(new Image("resources/vecteezy_poker-table-green-cloth-on-dark-background-vector-illustration_6325236.jpg"),null,null,null,null)));
        gp.add(deal,0,0);
        setTop(gp);
    }

    public void setLabel(String naam){
        naamSpeler = new Label(naam);
    }

    public void updatePlayerCards(Speler speler) {
        Platform.runLater(() -> {
            spelerKaartenPane.getChildren().clear();
            int index = 0;
            for (int i = 0; i < speler.getHand().getAantalKaarten(); i++) {
                Image image = kaart.getImage();
                ImageView imageView = new ImageView(image);
                spelerKaartenPane.add(imageView, index, 0);
            }
        });
    }

    public Button getHitButton() {
        return hit;
    }

    public Button getFoldButton() {
        return fold;
    }

    public Button getDealButton() {
        return deal;
    }

}
