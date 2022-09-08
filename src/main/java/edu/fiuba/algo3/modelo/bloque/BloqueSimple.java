package edu.fiuba.algo3.modelo.bloque;

public abstract class BloqueSimple implements Bloque{

    @Override
    public Bloque clone() {
        try {
            return  (BloqueSimple) super.clone();
        } catch (CloneNotSupportedException e) { //nunca deberia llegarse aca
            throw new InternalError(e);
        }
    }
}
