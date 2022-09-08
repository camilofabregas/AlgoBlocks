package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueBajarLapiz extends BloqueSimple {

    public void ejecutar(Personaje unPersonaje) { unPersonaje.bajarLapiz(); }

    public Bloque invertir(){
        return new BloqueSubirLapiz();
    }
}
