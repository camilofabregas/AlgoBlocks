package edu.fiuba.algo3.vista.dibujo;

import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Tramo {
    private final Path camino = new Path();
    private int tam = 0;
    private  Boolean esVisible;
    private  String direccion;

    public Tramo(Boolean visibilidad, String direccion){
        this.esVisible = visibilidad;
        this.direccion = direccion;
    }

    public Path getCamino() {
        return camino;
    }

    public int getTam() {
        return tam;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean esVisible(){
        return esVisible;
    }

    public void agregarDesplazamiento(Posicion origen, Posicion destino){
        if(camino.getElements().isEmpty()){
            camino.getElements().add(new MoveTo(origen.getX(), origen.getY()));
        }
        camino.getElements().add(new LineTo(destino.getX(), destino.getY()));
        tam++;
    }

    public void actualizarDireccion(String unaDireccion){
        direccion = unaDireccion;
    }

    public void actualizarVisibilidad(boolean unaVisibilidad){
        esVisible = unaVisibilidad;
    }
}
