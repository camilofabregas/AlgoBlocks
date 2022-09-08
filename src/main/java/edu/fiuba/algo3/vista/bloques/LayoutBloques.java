package edu.fiuba.algo3.vista.bloques;

import edu.fiuba.algo3.vista.VistaScrollPane;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.LayoutTitulo;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static private VBox contenido;
    private final BloquesDisponibles bloquesDisponibles;

    public LayoutBloques(int altura) {

        contenido = new VBox(10);
        this.getChildren().addAll(new LayoutTitulo("Bloques"), new VistaScrollPane(altura - 40, 150, contenido));
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");

        this.bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotones(contenido);
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks){
        bloquesDisponibles.agregarBloquePersonalizado(nombre, algoBlocks, contenido);
    }
}
