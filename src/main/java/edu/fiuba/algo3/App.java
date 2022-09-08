package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaEscenario;
import edu.fiuba.algo3.vista.algoritmo.BotonGuardarAlgoritmo;
import edu.fiuba.algo3.vista.algoritmo.LayoutAlgoritmo;
import edu.fiuba.algo3.vista.bloques.LayoutBloques;
import edu.fiuba.algo3.vista.dibujo.LayoutDibujo;
import edu.fiuba.algo3.vista.LayoutEjecutarReiniciar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.AlgoBlocks;

import static java.lang.Integer.max;

/**
 * JavaFX App
 */
public class App extends Application {

    static int SCREEN_WIDTH = max ((int) Screen.getPrimary().getVisualBounds().getWidth()*3/4, 1150);
    static int SCREEN_HEIGHT = max((int) Screen.getPrimary().getVisualBounds().getHeight()*3/4, 600);

    @Override
    public void start(Stage stage) {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        LayoutDibujo layoutDibujo = new LayoutDibujo(SCREEN_WIDTH-450,SCREEN_HEIGHT-150);


        // PANEL PRINCIPAL: CONTIENE A panelSuperior, layoutBloques, layoutAlgoritmo y layoutDibujo
        BorderPane panelPrincipal = this.crearPanelPrincipal(algoBlocks, layoutDibujo);

        // ESCENARIO
        new VistaEscenario(stage, panelPrincipal, "AlgoBlocks v2.0");
        stage.show();
    }

    private BorderPane crearPanelSuperior(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        BorderPane panelSuperior = new BorderPane();

        panelSuperior.setPadding(new Insets(0, 25, 0, 0));
        panelSuperior.setStyle("-fx-background-color: rgb(0, 176, 189)");
        panelSuperior.setLeft(new ImageView("file:src/main/recursos/imagenes/Banner.png"));
        panelSuperior.setRight(new LayoutEjecutarReiniciar(algoBlocks, layoutDibujo));

        return panelSuperior;
    }

    private BorderPane crearPanelPrincipal(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        BorderPane panelPrincipal = new BorderPane();
        LayoutBloques layoutBloques = new LayoutBloques(SCREEN_HEIGHT - 150);
        BotonGuardarAlgoritmo botonGuardarAlgoritmo = new BotonGuardarAlgoritmo(algoBlocks, layoutBloques);
        LayoutAlgoritmo layoutAlgoritmo = new LayoutAlgoritmo(algoBlocks, SCREEN_HEIGHT - 150);
        VBox layoutAlgoritmoGuardar = new VBox(layoutAlgoritmo, botonGuardarAlgoritmo);
        layoutAlgoritmoGuardar.setStyle("-fx-background-color: lightgray");

        panelPrincipal.setRight(layoutDibujo);
        panelPrincipal.setLeft(layoutBloques);
        panelPrincipal.setCenter(layoutAlgoritmoGuardar);
        panelPrincipal.setTop(this.crearPanelSuperior(algoBlocks, layoutDibujo));

        return panelPrincipal;
    }

    public static void main(String[] args) {
        launch();
    }

}