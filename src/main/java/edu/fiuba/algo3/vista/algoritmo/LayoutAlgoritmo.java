package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.VistaScrollPane;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.LayoutTitulo;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo extends VBox implements Observer{
    private final SelectorContenedorDeBloquesParaAgregar selectorContenedorDeBloquesParaAgregar =
            new SelectorContenedorDeBloquesParaAgregar("Algoritmo");
    private final AdministradorContenedoresDeBloques administradorContenedoresDeBloques;

    public LayoutAlgoritmo(AlgoBlocks algoBlocks, int altura) {
        VistaScrollPane vistaScrollPane = new VistaScrollPane(altura - 40, 250, null);
        HBox layoutTituloYSeleccionador = new HBox(10, new LayoutTitulo("Algoritmo"), selectorContenedorDeBloquesParaAgregar);
        layoutTituloYSeleccionador.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(layoutTituloYSeleccionador, vistaScrollPane);
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");
        algoBlocks.addObserver(this);

        administradorContenedoresDeBloques = new AdministradorContenedoresDeBloques(algoBlocks, vistaScrollPane, selectorContenedorDeBloquesParaAgregar);
    }

    private void reiniciar(){
        selectorContenedorDeBloquesParaAgregar.reiniciar();
        administradorContenedoresDeBloques.reiniciar();
    }

    @Override
    public void change(Object obj) {
        AlgoBlocks algoBlocks = (AlgoBlocks) obj;

        if (algoBlocks.cantidadDeBloquesEnAlgoritmo() == 0) {
            this.reiniciar();
        }
    }
}
