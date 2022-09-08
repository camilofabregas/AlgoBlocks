package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.controlador.handlers.BotonCancelarHandler;
import edu.fiuba.algo3.controlador.handlers.BotonIngresarHandler;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.bloques.LayoutBloques;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LayoutBotonesGuardarCancelar extends HBox {

    public LayoutBotonesGuardarCancelar(AlgoBlocks algoBlocks, LayoutBloques layoutBloques, String nombreBloque, Stage escenarioGuardar){
        Button botonIngresar = new Button("Guardar");
        botonIngresar.setOnAction(new BotonIngresarHandler(escenarioGuardar, nombreBloque, algoBlocks, layoutBloques));
        Button botonCancelar = new Button("Cancelar");
        botonCancelar.setOnAction(new BotonCancelarHandler(escenarioGuardar));
        this.setWidth(250);
        this.setAlignment(Pos.TOP_RIGHT);
        this.setSpacing(30);
        this.getChildren().addAll(botonIngresar, botonCancelar);
    }
}
