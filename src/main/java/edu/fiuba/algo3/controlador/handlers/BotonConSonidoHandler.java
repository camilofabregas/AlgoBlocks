package edu.fiuba.algo3.controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonConSonidoHandler implements EventHandler<ActionEvent>  {
    private final AudioClip click = new AudioClip("file:src/main/recursos/sonidos/click.mp3");

    public void handle(ActionEvent actionEvent){
        click.setVolume(0.25);
        click.play();
    }
}
