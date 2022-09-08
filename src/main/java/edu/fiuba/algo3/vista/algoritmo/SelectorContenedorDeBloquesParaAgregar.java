package edu.fiuba.algo3.vista.algoritmo;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class SelectorContenedorDeBloquesParaAgregar extends ChoiceBox<String> {

    public SelectorContenedorDeBloquesParaAgregar(String nombre){
        super();
        agregar(nombre);
        this.setValue(nombre);
        this.setTooltip(new Tooltip("Elige destino de bloques"));
        this.setMaxWidth(140);
        this.setStyle("-fx-border-color: slategray;" +"-fx-border-radius: 2;" + "-fx-background-radius: 2");
    }

    public void agregar(String nombre){
        this.getItems().add(nombre);
    }

    public String getActual() {
        return this.getValue();
    }

    public void reiniciar(){
        String principal = this.getItems().get(0);
        this.getItems().clear();
        this.agregar(principal);
        this.setValue(principal);
    }
}
