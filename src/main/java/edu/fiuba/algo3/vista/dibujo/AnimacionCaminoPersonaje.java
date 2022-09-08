package edu.fiuba.algo3.vista.dibujo;

import javafx.animation.*;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class AnimacionCaminoPersonaje extends AnimacionCamino {

    private final ImagenesPersonaje imagenesPersonaje = new ImagenesPersonaje();
    private final ImageView personaje = new ImageView();


    public AnimacionCaminoPersonaje(double posX, double posY, String dirInicial, boolean visibilidadInicial){
        super(dirInicial, visibilidadInicial);
        personaje.setX(posX);
        personaje.setY(posY);
        personaje.setImage(imagenesPersonaje.getImagenInicial(dirInicial, visibilidadInicial));
    }

    public void agregarAlLayout(Pane unLayout){unLayout.getChildren().add(personaje);}

    protected void transicionCondicionLapiz(Tramo tramo){
        secuencia.getChildren().add(transicionImagenCondicionLapiz(imagenesPersonaje.getImagen(tramo)));

        secuencia.getChildren().add(new PauseTransition(Duration.seconds(1)));
    }

    protected void transicionDesplazamiento(Tramo tramo){
        secuencia.getChildren().add(transicionImagenCondicionLapiz(imagenesPersonaje.getImagen(tramo)));
        secuencia.getChildren().add(new PathTransition(Duration.seconds(tramo.getTam()), tramo.getCamino(), personaje));
    }

    protected SequentialTransition transicionImagenCondicionLapiz(Image condicionLapiz){
        FadeTransition fadeOut = new FadeTransition(Duration.ONE, personaje);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> personaje.setImage(condicionLapiz));

        FadeTransition fadeIn = new FadeTransition(Duration.ONE, personaje);
        fadeIn.setToValue(1);

        return new SequentialTransition(fadeOut, fadeIn);
    }


}
