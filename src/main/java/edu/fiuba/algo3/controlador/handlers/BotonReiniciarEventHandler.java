package edu.fiuba.algo3.controlador.handlers;

import edu.fiuba.algo3.vista.dibujo.LayoutDibujo;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonReiniciarEventHandler extends BotonConSonidoHandler {
    private final AlgoBlocks algoBlocks;
    private final LayoutDibujo layoutDibujo;
    private final Button botonEjecutar;

    public BotonReiniciarEventHandler(AlgoBlocks unAlgoBlocks, LayoutDibujo unLayoutDibujo, Button unBotonEjecutar){
        algoBlocks = unAlgoBlocks;
        layoutDibujo = unLayoutDibujo;
        botonEjecutar = unBotonEjecutar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        algoBlocks.reiniciar();
        layoutDibujo.reiniciar();
        botonEjecutar.setDisable(false);
    }
}
