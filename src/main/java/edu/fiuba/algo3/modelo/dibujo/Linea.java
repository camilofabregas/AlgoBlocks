package edu.fiuba.algo3.modelo.dibujo;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.DireccionDesplazamientoInvalidaException;
import edu.fiuba.algo3.modelo.Posicion;

public class Linea {

    private final Posicion origen;
    private final Posicion destino;
    private final Boolean visibilidad;

    public Linea (Posicion inicioLinea, Posicion finLinea, boolean esVisible){
        origen = inicioLinea;
        destino = finLinea;
        visibilidad = esVisible;
    }

    public Posicion getOrigen() {
        return origen;
    }

    public Posicion getDestino() {
        return destino;
    }

    public boolean esVisible(){
        return visibilidad;
    }

    public boolean esIgual(Linea linea){
        return ((origen.esIgualA(linea.origen) && destino.esIgualA(linea.destino) && visibilidad == linea.esVisible()));
    }

    public String getDireccion() throws DireccionDesplazamientoInvalidaException {
        return Direccion.direccionDesplazamiento(destino.desplazaminetoEnX(origen), destino.desplazamientoEnY(origen));
    }
}
