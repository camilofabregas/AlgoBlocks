package edu.fiuba.algo3.vista.dibujo;

import edu.fiuba.algo3.modelo.Posicion;
import javafx.animation.*;
import javafx.beans.value.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.io.File;

import static javafx.scene.paint.Color.LIGHTSLATEGREY;

public class AnimacionCaminoDibujado extends AnimacionCamino {
    private final Canvas canvas;
    private final static MediaPlayer sonidoLapiz = new MediaPlayer(new Media(new File("src/main/recursos/sonidos/sonidoLapiz.mp3").toURI().toString()));

    public AnimacionCaminoDibujado(double w, double h, String dirInicial, boolean visibilidadInicial){
        super(dirInicial, visibilidadInicial);
        sonidoLapiz.setCycleCount(MediaPlayer.INDEFINITE);
        sonidoLapiz.setVolume(0.5);
        this.canvas = new Canvas(w,h);
    }

    protected void transicionCondicionLapiz(Tramo tramo){
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(1)));
    }

    @Override
    protected void transicionDesplazamiento(Tramo tramo) {
        if (tramo.esVisible()){
            transicionDesplazamientoVisible(tramo);
        }
        else{
            transicionDesplazamientoNoVisible(tramo);
        }
    }

    protected void transicionDesplazamientoVisible(Tramo tramo){
        secuencia.getChildren().get(secuencia.getChildren().size() - 1).setOnFinished(event -> sonidoLapiz.play());
        Animation animacionTramos = crearAnimacionTramos(tramo.getCamino(), Duration.seconds(tramo.getTam()));
        animacionTramos.setOnFinished(event -> sonidoLapiz.stop());
        secuencia.getChildren().add(animacionTramos);
    }

    protected void transicionDesplazamientoNoVisible(Tramo tramo){
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(tramo.getTam())));
    }

    private Animation crearAnimacionTramos(Path camino, Duration duration) {
        GraphicsContext contenido = canvas.getGraphicsContext2D();
        Circle lapiz = new Circle(0, 0, 2);

        PathTransition transicionCamino = new PathTransition( duration, camino, lapiz);
        transicionCamino.currentTimeProperty().addListener( new ChangeListener<>() {
            Posicion origen = null;

            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {

                if( oldValue == Duration.ZERO)
                    return;
                //sumo para que el trazo se dibuje en la punta del lapiz
                int x = (int)lapiz.getTranslateX();
                int y = (int)lapiz.getTranslateY() + 23;

                if( origen == null) {
                    origen = new Posicion(x, y);
                    return;
                }
                contenido.setStroke(LIGHTSLATEGREY);
                contenido.setLineWidth(2);
                contenido.strokeLine(origen.getX(), origen.getY(), x, y);

                origen = new Posicion(x, y);
            }
        });

        return transicionCamino;
    }

    public void agregarAlLayout(Pane unLayout){unLayout.getChildren().add(canvas);}

    public static void pararAnimacion(){
        sonidoLapiz.stop();
    }
}
