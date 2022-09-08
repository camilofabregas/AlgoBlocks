package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;

public class ControladorContenedorInternoDeBloques implements ControladorContenedorDeBloques{
    private final BloqueContenedor contenedor;

    public ControladorContenedorInternoDeBloques(BloqueContenedor unContenedor){
        contenedor = unContenedor;
    }

    public void agregarBloque(Bloque unBloque){
        contenedor.agregarBloque(unBloque);
    }
}
