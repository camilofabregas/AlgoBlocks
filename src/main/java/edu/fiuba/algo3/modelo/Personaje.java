package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.lapiz.Lapiz;

public class Personaje {

    private Posicion posicion = new Posicion();
    private Lapiz lapiz = new Lapiz();
    private final Dibujo dibujo;

    public Personaje(Dibujo dib){
        dibujo = dib;
    }

    public Boolean estaEnPosicion(Posicion unaPosicion) { return posicion.esIgualA(unaPosicion); }

    public void bajarLapiz() {
        lapiz.bajar(dibujo, posicion);
    }

    public void subirLapiz() {
        lapiz.subir(dibujo, posicion);
    }

    public void mover(Direccion unaDireccion) {
        Posicion posVieja = posicion;
        posicion = posicion.obtenerSiguiente(unaDireccion);
        lapiz.dibujarLinea(posVieja, posicion, dibujo);
    }

    public void reiniciar(){
        posicion = new Posicion();
        lapiz = new Lapiz();
    }
}
