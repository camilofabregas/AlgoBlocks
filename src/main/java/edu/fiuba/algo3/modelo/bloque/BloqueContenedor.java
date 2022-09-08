package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.ContenedorDeBloques;

import java.util.ArrayList;
import java.util.List;

public abstract class BloqueContenedor extends ContenedorDeBloques implements Bloque {

    public BloqueContenedor clone(){
        BloqueContenedor copia;
        try {
            copia = (BloqueContenedor) super.clone();
        } catch (CloneNotSupportedException e) {  //nunca deberia llegarse aca
            throw new InternalError(e);
        }
        List<Bloque> aux = new ArrayList<>();
        for (Bloque bloque:bloques) {
            aux.add(bloque.clone());
        }
        copia.bloques = aux;
        return copia;
    }
}
