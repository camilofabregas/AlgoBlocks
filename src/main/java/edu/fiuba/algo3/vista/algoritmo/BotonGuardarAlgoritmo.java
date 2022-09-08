package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.controlador.handlers.BotonGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.vista.bloques.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.BotonSimple;


public class BotonGuardarAlgoritmo  extends BotonSimple implements Observer{

    public BotonGuardarAlgoritmo(AlgoBlocks algoBlocks, LayoutBloques layoutBloques){
        super("src/main/recursos/imagenes/botones/boton-guardar.png", "Guarda el algoritmo ingresado.",
                new BotonGuardarAlgoritmoEventHandler(algoBlocks, layoutBloques));
        algoBlocks.addObserver(this);
        this.setPrefHeight(63);
        this.setVisible(false);
    }

    @Override
    public void change(Object obj) {
        AlgoBlocks algoBlocks = (AlgoBlocks) obj;

        this.setVisible(algoBlocks.cantidadDeBloquesEnAlgoritmo() != 0);
    }
}
