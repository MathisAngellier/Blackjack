package view.speleraanmaakpagina;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class SpeleraanmaakpaginaView extends BorderPane {
    private Label speler;
    private int spelernummer = 1;
    private Label naam;
    private TextField naamfield;
    private Label geld;
    private TextField geldfield;
    private Button bevestigen;

    public SpeleraanmaakpaginaView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        speler = new Label("speler " + spelernummer);
        naam = new Label("naam: ");
        naamfield = new TextField();
        geld = new Label("hoeveel geld heeft speler "+spelernummer +" in euro:");
        geldfield = new TextField();
        bevestigen = new Button("bevestigen");
    }
    private void layoutNodes() {
        GridPane gp = new GridPane();
        setBackground(new Background(new BackgroundImage(new Image("recourses/startpaginaAfbeeldingKlein.png"),null,null,null,null)));
        gp.add(speler,0,0);
        gp.add(naam,0,1);
        gp.add(naamfield,1,1);
        gp.add(geld,0,2);
        gp.add(geldfield,1,2);
        gp.add(bevestigen,0,3);
        setTop(gp);
    }

}

