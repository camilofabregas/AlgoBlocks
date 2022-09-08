package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.vista.VistaEscenario;
import edu.fiuba.algo3.vista.bloques.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaGuardarBloque {

    public VistaGuardarBloque(AlgoBlocks unAlgoblocks, LayoutBloques unLayoutBloques){
        Stage escenarioGuardar = new Stage();

        TextField ingresoNombre = new TextField();
        Label nombreAlgoritmo = new Label("Nombre del bloque:");
        nombreAlgoritmo.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 14px");
        new VistaEscenario(escenarioGuardar, new VBox(new HBox(10, nombreAlgoritmo, ingresoNombre),
                new LayoutBotonesGuardarCancelar(unAlgoblocks, unLayoutBloques, ingresoNombre.getText(), escenarioGuardar)), "Guardar como");
        escenarioGuardar.show();
    }
}
