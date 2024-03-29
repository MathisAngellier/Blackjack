package view.spelpagina;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Dealer;
import model.Kaart;
import model.Speler;

import java.util.List;

public class SpelpaginaView extends BorderPane {

    private Button hit;
    private Button stand;
    private HBox buttonBox;
    private Button stoppen;
    private Button volgendeBeurt;
    private GridPane rechts;
    private VBox scoreBox;
    private GridPane spelerKaartenPane;
    private BorderPane gamePane;
    private BorderPane bottom;
    private GridPane dealerKaartenPane;
    private Label playerScoreLabel;
    private Label dealerScoreLabel;


    public SpelpaginaView() {
        initialiseNodes();
        layoutNodes();
        show();
    }

    private void initialiseNodes() {
        gamePane = new BorderPane();
        spelerKaartenPane = new GridPane();
        dealerKaartenPane = new GridPane();
        playerScoreLabel = new Label();
        dealerScoreLabel = new Label();
        bottom = new BorderPane();
        rechts = new GridPane();
        stoppen = new Button("stop spel");
        volgendeBeurt = new Button("volgende beurt");
        stand = new Button("Stand");
        hit = new Button("Hit");
        buttonBox = new HBox(10, hit, stand);
        scoreBox = new VBox(10,  dealerScoreLabel,playerScoreLabel);

    }
    private void layoutNodes() {
        spelerKaartenPane.setPadding(new Insets(10));
        spelerKaartenPane.setHgap(5);
        spelerKaartenPane.setVgap(10);
        dealerKaartenPane.setPadding(new Insets(10));
        dealerKaartenPane.setHgap(5);
        dealerKaartenPane.setVgap(10);
        playerScoreLabel.setAlignment(Pos.CENTER);
        dealerScoreLabel.setAlignment(Pos.CENTER);
        playerScoreLabel.setTextFill(Color.WHITE);
        // TODO: 19/03/2023 dealerscoreLabel moet weg wanneer alles werkt
        buttonBox.setAlignment(Pos.CENTER);
        scoreBox.setAlignment(Pos.CENTER);
        rechts.add(volgendeBeurt,0,0);
        rechts.add(stoppen,0,1);
        setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        gamePane.setCenter(new VBox(10,  dealerKaartenPane,spelerKaartenPane));
        gamePane.setBottom(bottom);
        bottom.setLeft(buttonBox);
        bottom.setRight(rechts);
        gamePane.setTop(scoreBox);
        rechts.setVisible(false);

    }

    public void show() {
        this.getChildren().add(gamePane);
    }


    public void updatePlayerCards(Speler speler) {
        Platform.runLater(() -> {
            spelerKaartenPane.getChildren().clear();
            int index = 0;
            List<Kaart> spelerHand = speler.getHand().getKaarten();
            for (int i = 0; i < spelerHand.size(); i++) {
                Kaart kaart = spelerHand.get(i);
                String kaartNaam = kaart.getKleur();
                String kaartWaarde = kaart.getNaam();
                Image image = new Image(String.format("resources/pakKaarten/%s_%s.png",kaartWaarde.toLowerCase(),kaartNaam.toLowerCase()),true);
                ImageView imageView = new ImageView(image);
                spelerKaartenPane.add(imageView, index, 0);
                index++;
            }
        });
    }

    public GridPane getRechts() {
        return rechts;
    }

    public Button getStoppen() {
        return stoppen;
    }

    public Button getVolgendeBeurt() {
        return volgendeBeurt;
    }

    public void updateDealerCards(Dealer dealer) {
        Platform.runLater(() -> {
            dealerKaartenPane.getChildren().clear();
            int index = 0;
            List<Kaart> dealerHand = dealer.getHand().getKaarten();
            for (int i = 0; i < dealerHand.size(); i++) {
                Kaart kaart = dealerHand.get(i);
                String kaartNaam = kaart.getKleur();
                String kaartWaarde = kaart.getNaam();
                Image image = new Image(String.format("resources/pakKaarten/%s_%s.png",kaartWaarde.toLowerCase(),kaartNaam.toLowerCase()),true);
                ImageView imageView = new ImageView(image);
                dealerKaartenPane.add(imageView, index, 0);
                index++;
            }
            Image achterkant = new Image("resources/achterkand kaart.png");
            ImageView achterkantView = new ImageView(achterkant);
            dealerKaartenPane.add(achterkantView,index +1,0);
        });
    }


    public Button getHitButton() {
        return hit;
    }

    public Button getStandButton() {
        return stand;
    }


}
