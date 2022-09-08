package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueInversion extends BloqueContenedor{

    @Override
    public void ejecutar(Personaje unPersonaje) {
        bloques.forEach(bloque -> bloque.invertir().ejecutar(unPersonaje));
    }

    public Bloque invertir() {
        BloqueInversion unBloque = new BloqueInversion();
        bloques.forEach(bloque -> unBloque.agregarBloque(bloque.invertir()));
        return unBloque;
    }
}
