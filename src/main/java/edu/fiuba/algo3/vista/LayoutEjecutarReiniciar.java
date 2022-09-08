package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.handlers.BotonEjecutarEventHandler;
import edu.fiuba.algo3.controlador.handlers.BotonReiniciarEventHandler;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.dibujo.LayoutDibujo;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class LayoutEjecutarReiniciar extends HBox {

    static final String RUTA_IMAGENES = "src/main/recursos/imagenes/botones/";

    public LayoutEjecutarReiniciar(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo){
        super(10);
        this.setAlignment(Pos.CENTER_RIGHT);

        BotonEjecutarEventHandler handlerEjecutar = new BotonEjecutarEventHandler(algoBlocks, layoutDibujo);
        Button botonEjecutar = new BotonSimple(
                 RUTA_IMAGENES + "Ejecutar.png",
                "Ejecutar el algoritmo.",
                handlerEjecutar
        );
        handlerEjecutar.agregarBoton(botonEjecutar);

        BotonReiniciarEventHandler handlerReiniciar = new BotonReiniciarEventHandler(algoBlocks, layoutDibujo, botonEjecutar);
        Button botonReiniciar = new BotonSimple(
                RUTA_IMAGENES + "Reiniciar.png",
                "Reiniciar el algoritmo.",
                handlerReiniciar
        );
        this.getChildren().addAll(botonEjecutar, botonReiniciar);
    }
}
