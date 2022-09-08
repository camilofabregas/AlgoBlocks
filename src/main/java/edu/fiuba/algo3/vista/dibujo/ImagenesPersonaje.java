package edu.fiuba.algo3.vista.dibujo;

import javafx.scene.image.Image;

import java.util.HashMap;

public class ImagenesPersonaje {

    static final String RUTA_IMAGENES = "src/main/recursos/imagenes/personaje/";

    private final HashMap<String, Image> imgDirLapizArriba = imagenesDireccionPersonaje(
            "lArr");
    private final HashMap<String, Image> imgDirLapizAbajo = imagenesDireccionPersonaje(
            "Lab");


    private HashMap<String, Image> imagenesDireccionPersonaje(String condicionLapiz){
        HashMap<String, Image> hash = new HashMap<>();

        hash.put("Arriba", new Image("file:" + RUTA_IMAGENES + "Arr" + condicionLapiz + ".png"));
        hash.put("Abajo", new Image("file:" + RUTA_IMAGENES + "Ab" + condicionLapiz + ".png"));
        hash.put("Derecha", new Image("file:" + RUTA_IMAGENES + "Der" + condicionLapiz + ".png"));
        hash.put("Izquierda", new Image("file:" + RUTA_IMAGENES + "Izq" + condicionLapiz + ".png"));

        return hash;
    }

    public Image getImagen(Tramo tramo) {
        return getImagenCorrespondiente(tramo.getDireccion(), tramo.esVisible());
    }

    public Image getImagenInicial(String direccion, boolean visibilidad) {
        return getImagenCorrespondiente(direccion, visibilidad);
    }

    private Image getImagenCorrespondiente(String direccion, boolean visibilidad){
        if (visibilidad){
            return imgDirLapizAbajo.get(direccion);
        }
        else{
            return imgDirLapizArriba.get(direccion);
        }
    }
}
