package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.dibujo.Dibujo;

public class LapizAbajo implements CondicionLapiz{

    public void dibujarLinea(Posicion origen, Posicion destino, Dibujo dibujo) {
        dibujo.dibujarLinea(origen, destino, true);
    }
}
