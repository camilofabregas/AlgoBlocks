package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.Posicion;

public class LapizArriba implements CondicionLapiz{

    public void dibujarLinea(Posicion origen, Posicion destino, Dibujo dibujo) {dibujo.dibujarLinea(origen, destino, false);}
}
