package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

public interface Bloque extends Cloneable{

    void ejecutar(Personaje unPersonaje);

    Bloque invertir();

    Bloque clone();
}
