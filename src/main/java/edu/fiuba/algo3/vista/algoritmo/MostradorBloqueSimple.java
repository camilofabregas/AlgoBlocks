package edu.fiuba.algo3.vista.algoritmo;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MostradorBloqueSimple {
    public MostradorBloqueSimple(String rutaImagen, VBox layout){
        ImageView imagen = new ImageView("file:" + rutaImagen);

        layout.getChildren().add(imagen);
    }
}
