package edu.fiuba.algo3.vista;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class VistaScrollPane extends ScrollPane {

    public VistaScrollPane(int altura, int ancho, Pane unContenido){
        super(unContenido);
        this.setMinViewportWidth(ancho);
        this.setPrefViewportHeight(altura);
    }
}
