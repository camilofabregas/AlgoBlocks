package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueSubirLapiz extends BloqueSimple {

    public void ejecutar(Personaje unPersonaje) { unPersonaje.subirLapiz(); }

    public Bloque invertir(){
        return new BloqueBajarLapiz();
    }

}
