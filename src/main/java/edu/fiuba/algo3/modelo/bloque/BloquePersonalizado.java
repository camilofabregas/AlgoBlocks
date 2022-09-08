package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

import java.util.ArrayList;
import java.util.List;

public class BloquePersonalizado extends BloqueSimple {

    private final List<Bloque> bloques = new ArrayList<>();

    public BloquePersonalizado(List<Bloque> lBloques) {
        for (Bloque bloque : lBloques) {
            bloques.add(bloque.clone());
        }
    }

    public void ejecutar(Personaje unPersonaje) {
        bloques.forEach(bloque -> bloque.ejecutar(unPersonaje));
    }

    public Bloque invertir() {
        List<Bloque> aux = new ArrayList<>();
        bloques.forEach(bloque -> aux.add(bloque.invertir()));
        return new BloquePersonalizado(aux);
    }
}
