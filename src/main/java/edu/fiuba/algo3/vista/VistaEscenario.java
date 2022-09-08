package edu.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VistaEscenario {

    public VistaEscenario(Stage unEscenario, Pane unLayout, String unTitulo){
        unEscenario.setTitle(unTitulo);
        unEscenario.getIcons().add(new Image("file:src/main/recursos/imagenes/Logo.png"));
        unEscenario.setScene(new Scene(unLayout));
        unEscenario.setResizable(false);
    }
}
