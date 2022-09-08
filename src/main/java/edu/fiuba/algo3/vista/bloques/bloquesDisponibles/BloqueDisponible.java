package edu.fiuba.algo3.vista.bloques.bloquesDisponibles;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

public abstract class BloqueDisponible {
    protected final String descripcion;
    protected final Bloque bloque;
    protected final String rutaImagen;

    protected BloqueDisponible(Bloque unBloque, String unaDescripcion, String unaRutaImagen){
        bloque = unBloque;
        descripcion = unaDescripcion;
        rutaImagen = unaRutaImagen;
    }

    public abstract void agregarBoton(VBox layoutBloques);
}
