package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;

public class ControladorContenedorPrincipalDeBloques implements ControladorContenedorDeBloques{
    private final AlgoBlocks contenedor;

    public ControladorContenedorPrincipalDeBloques(AlgoBlocks unContenedor){
        contenedor = unContenedor;
    }

    public void agregarBloque(Bloque unBloque){
        contenedor.agregarBloque(unBloque);
    }
}
