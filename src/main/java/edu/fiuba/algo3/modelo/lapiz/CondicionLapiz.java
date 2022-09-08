package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.Posicion;

public interface CondicionLapiz {
    void dibujarLinea(Posicion origen, Posicion destino, Dibujo dibujo);
}
