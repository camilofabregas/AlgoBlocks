package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueRepeticion extends BloqueContenedor{
    private final int cantidad;

    private BloqueRepeticion(int cant){
        cantidad = cant;
    }

    public static BloqueRepeticion repetirDosVeces(){
        return new BloqueRepeticion(2);
    }

    public static BloqueRepeticion repetirTresVeces(){
        return new BloqueRepeticion(3);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        for (int i = 0; i < cantidad; i++){
            super.ejecutar(unPersonaje);
        }
    }

    public BloqueRepeticion invertir(){
        BloqueRepeticion nBloque = new BloqueRepeticion(cantidad);
        for (int i = bloques.size() - 1; i >= 0 ; i--) {
            nBloque.agregarBloque(bloques.get(i).invertir());
        }
        return nBloque;
    }
}
