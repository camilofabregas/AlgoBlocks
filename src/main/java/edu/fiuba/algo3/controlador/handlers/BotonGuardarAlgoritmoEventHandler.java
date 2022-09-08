package edu.fiuba.algo3.controlador.handlers;

import edu.fiuba.algo3.vista.algoritmo.VistaGuardarBloque;
import edu.fiuba.algo3.vista.bloques.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;

public class BotonGuardarAlgoritmoEventHandler extends BotonConSonidoHandler {

    private final AlgoBlocks algoBlocks;
    private final LayoutBloques layoutBloques;

    public BotonGuardarAlgoritmoEventHandler(AlgoBlocks unAlgoBlocks, LayoutBloques unLayoutBloques) {
        algoBlocks = unAlgoBlocks;
        layoutBloques = unLayoutBloques;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        new VistaGuardarBloque(algoBlocks, layoutBloques);
    }
}
