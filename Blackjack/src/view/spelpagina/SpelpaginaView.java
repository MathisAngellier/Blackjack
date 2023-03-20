package view.spelpagina;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Dealer;
import model.Kaart;
import model.Speler;

import java.util.List;
import java.util.Objects;

public class SpelpaginaView extends BorderPane {

    private Button hit;
    private Button fold;
    private Button deal;
    private Label aantalGeld;
    private Label naamSpeler;
    private Label dealer;
    private Speler speler;

    private ImageView spelerKaarten;
    private ImageView dealerKaarten;
    private GridPane spelerKaartenPane;
    private BorderPane gamePane;
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
        fold = new Button("Fold");
        hit = new Button("Hit");
        deal = new Button("Deal");

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

        HBox buttonBox = new HBox(10, deal, hit, fold);
        buttonBox.setAlignment(Pos.CENTER);
        VBox scoreBox = new VBox(10,  dealerScoreLabel,playerScoreLabel);
        scoreBox.setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        gamePane.setCenter(new VBox(10,  dealerKaartenPane,spelerKaartenPane));
        gamePane.setBottom(buttonBox);
        gamePane.setTop(scoreBox);

    }

    public void show() {
        this.getChildren().add(gamePane);
    }

    public void updatePlayerScore(int score) {
        Platform.runLater(() -> {
            playerScoreLabel.setText("Player Score: " + score);
        });
    }

    public void updateDealerScore(int score) {
        Platform.runLater(() -> {
            dealerScoreLabel.setText("Dealer Score: " + score);
        });
    }

    public void setLabel(String naam){
        naamSpeler = new Label(naam);
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

    public void updateDealerCards(Dealer dealer) {
        Platform.runLater(() -> {
            dealerKaartenPane.getChildren().clear();
            int index = 0;
            List<Kaart> dealerHand = dealer.getHand().getKaarten();
            for (int i = 0; i < dealerHand.size(); i++) {
                Kaart kaart = dealerHand.get(i);
                String kaartNaam = kaart.getKleur();
                String kaartWaarde = String.valueOf(kaart.getWaarde());
                Image image = new Image(String.format("resources/pakKaarten/%s_%s.png",kaartWaarde.toLowerCase(),kaartNaam.toLowerCase()),true);
                ImageView imageView = new ImageView(image);
                dealerKaartenPane.add(imageView, index, 0);
                index++;
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
