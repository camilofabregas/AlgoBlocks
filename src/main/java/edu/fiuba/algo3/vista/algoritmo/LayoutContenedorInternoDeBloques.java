package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.controlador.ControladorContenedorInternoDeBloques;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

public class LayoutContenedorInternoDeBloques extends LayoutContenedorDeBloques{

    public LayoutContenedorInternoDeBloques(String unaDescripcion, ControladorContenedorInternoDeBloques unControlador, String rutaImagen){
        super(unaDescripcion, unControlador);
        this.getChildren().add(0, new ImageView("file:" + rutaImagen));
        this.estilo();
    }

    private void estilo(){
        secuenciaDeBloques.setPadding(new Insets(0,0,0,20));
        this.setStyle("-fx-padding: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-radius: 5;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: gray;" +
                "-fx-background-color: rgb(252,205,235)");
    }
}
