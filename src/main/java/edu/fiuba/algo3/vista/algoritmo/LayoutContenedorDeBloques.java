package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.controlador.ControladorContenedorDeBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class LayoutContenedorDeBloques extends VBox{
    protected VBox secuenciaDeBloques = new VBox(10);
    protected final ControladorContenedorDeBloques controlador;

    public LayoutContenedorDeBloques(String unaDescripcion, ControladorContenedorDeBloques unControlador){
        super();
        controlador = unControlador;
        this.getChildren().add(secuenciaDeBloques);
        this.agregarMarcadorFinal(unaDescripcion);
    }

    public void agregarBloque(Bloque unBloque, String rutaImagen){
        new MostradorBloqueSimple(rutaImagen, secuenciaDeBloques);
        controlador.agregarBloque(unBloque);
    }

    public void agregarBloqueContenedor(BloqueContenedor bloque, String descripcion, LayoutContenedorInternoDeBloques layoutContenedor) {
        this.agregarBloque(bloque, descripcion);
        secuenciaDeBloques.getChildren().add(layoutContenedor);
    }

    private void agregarMarcadorFinal(String descripcion) {

        Label etiqueta = new Label(descripcion);
        etiqueta.setStyle(
                "-fx-padding: 10;" +
                        "-fx-pref-height: 30;" +
                        "-fx-pref-width: 190;" +
                        "-fx-background-radius: 5;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #333333;" +
                        "-fx-background-color: silver;"+
                        "-fx-alignment: center");

        this.getChildren().add(etiqueta);
    }
}
