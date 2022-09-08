package edu.fiuba.algo3.vista.dibujo;

import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LayoutSlider extends BorderPane {
    private final Slider slider = new Slider(0.25, 4, 1);

    public LayoutSlider(){
        this.setPadding(new Insets(10,10,10,10));
        this.setStyle("-fx-background-color: lightgray");

        BorderPane imgsSlider = new BorderPane();
        String RUTA_IMAGENES = "src/main/recursos/imagenes/";
        imgsSlider.setLeft(new ImageView(new Image("file:" + RUTA_IMAGENES + "lento.png")));
        imgsSlider.setRight(new ImageView(new Image("file:" + RUTA_IMAGENES + "rapido.png")));
        this.setRight(new VBox(imgsSlider, slider));
    }

    public Slider getSlider(){return slider;}
}
