package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.BloquePersonalizado;

public class Algoritmo extends ContenedorDeBloques {

    public int getCantidadDeBloques() { return bloques.size(); }

    public BloquePersonalizado guardar() throws GuardarAlgoritmoVacioException{
        if(bloques.isEmpty()){
            throw new GuardarAlgoritmoVacioException();
        }
        return new BloquePersonalizado(bloques);
    }

    public void reiniciar(){
        bloques.clear();
    }
}
