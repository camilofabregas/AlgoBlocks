package edu.fiuba.algo3.controlador.handlers;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonCancelarHandler extends BotonConSonidoHandler {
    Stage escenario;

    public BotonCancelarHandler(Stage unEscenario){
        escenario = unEscenario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        escenario.close();
    }
}
