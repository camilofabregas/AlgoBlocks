package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.controlador.ControladorContenedorPrincipalDeBloques;

public class LayoutContenedorPrincipalDeBloques extends LayoutContenedorDeBloques{

    public LayoutContenedorPrincipalDeBloques(String unaDescripcion, ControladorContenedorPrincipalDeBloques unControlador){
        super(unaDescripcion, unControlador);
    }

    public void reiniciar(){
        secuenciaDeBloques.getChildren().clear();
    }
}
