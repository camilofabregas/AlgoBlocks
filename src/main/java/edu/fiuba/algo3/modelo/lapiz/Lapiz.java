package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.dibujo.Dibujo;

public class Lapiz {
    private CondicionLapiz condicion = new LapizAbajo();

    public void bajar(Dibujo dibujo, Posicion posicion) {
        condicion = new LapizAbajo();
        this.dibujarLinea(posicion, posicion, dibujo);
    }

    public void subir(Dibujo dibujo, Posicion posicion) {
        condicion = new LapizArriba();
        this.dibujarLinea(posicion, posicion, dibujo);
    }

    public void dibujarLinea(Posicion origen, Posicion destino, Dibujo dibujo){
        condicion.dibujarLinea(origen, destino, dibujo);
    }
}
