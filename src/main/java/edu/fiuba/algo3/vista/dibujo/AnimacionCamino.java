package edu.fiuba.algo3.vista.dibujo;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.util.Duration;

public abstract class AnimacionCamino {
    protected String dirActual;
    protected SequentialTransition secuencia;
    protected boolean visibilidadActual;

    protected AnimacionCamino(String dirInicial, boolean visibilidadInicial){
        dirActual = dirInicial;
        visibilidadActual = visibilidadInicial;
        secuencia = new SequentialTransition(new PauseTransition(Duration.seconds(1)));
    }

    public void cargarMovimiento(Tramo tramo){
        if(dirActual.equals(tramo.getDireccion()) && (visibilidadActual != tramo.esVisible())){
            transicionCondicionLapiz(tramo);
            visibilidadActual = tramo.esVisible();
        }else{
            transicionDesplazamiento(tramo);
            dirActual = tramo.getDireccion();
        }
    }

    public SequentialTransition getSecuencia(){
        return secuencia;
    }

    protected abstract void transicionCondicionLapiz(Tramo tramo);

    protected abstract void transicionDesplazamiento(Tramo tramo);
}
