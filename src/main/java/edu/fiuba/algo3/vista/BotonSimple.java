package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;


public class BotonSimple extends Button{

    public BotonSimple(String rutaImagen, String descripcion, EventHandler<ActionEvent> handler){
        this.setTooltip(new Tooltip(descripcion));
        this.setOnAction(handler);
        this.setGraphic(new ImageView("file:" + rutaImagen));
    }
}
