package edu.fiuba.algo3.controlador.handlers;

import edu.fiuba.algo3.vista.dibujo.LayoutDibujo;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonEjecutarEventHandler extends BotonConSonidoHandler {
    private final AlgoBlocks algoBlocks;
    private final LayoutDibujo layoutDibujo;
    private Button botonEjecutar;

    public BotonEjecutarEventHandler(AlgoBlocks unAlgoBlocks, LayoutDibujo unLayoutDibujo){
        algoBlocks = unAlgoBlocks;
        layoutDibujo = unLayoutDibujo;
    }

    public void agregarBoton(Button unBotonEjecutar) {
        botonEjecutar = unBotonEjecutar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        algoBlocks.ejecutarAlgoritmo();
        layoutDibujo.graficarMovimientos(algoBlocks.getDibujo());
        botonEjecutar.setDisable(true);
    }
}
