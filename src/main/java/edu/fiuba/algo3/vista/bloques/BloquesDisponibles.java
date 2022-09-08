package edu.fiuba.algo3.vista.bloques;

import edu.fiuba.algo3.vista.bloques.bloquesDisponibles.*;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BloquesDisponibles {

    private final List<BloqueDisponible> bloques = new ArrayList<>();
    static final String RUTA_IMAGENES = "src/main/recursos/imagenes/botones/bloques/";


    public BloquesDisponibles() {
        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueArriba(),
                "Mueve al personaje hacia arriba.",
                RUTA_IMAGENES + "Arriba.png"));

        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueAbajo(),
                "Mueve al personaje hacia abajo.",
                RUTA_IMAGENES + "Abajo.png"));

        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueIzquierda(),
                "Mueve al personaje hacia la izquierda.",
                RUTA_IMAGENES + "Izquierda.png"));

        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueDerecha(),
                "Mueve al personaje hacia la derecha.",
                RUTA_IMAGENES + "Derecha.png"));

        bloques.add(new BloqueSimpleDisponible(new BloqueBajarLapiz(),
                "Baja el lapiz para que el personaje dibuje.",
                RUTA_IMAGENES + "LapizBajar.png"));

        bloques.add(new BloqueSimpleDisponible(new BloqueSubirLapiz(),
                "Sube el lapiz para que el personaje no dibuje.",
                RUTA_IMAGENES + "LapizSubir.png"));

        bloques.add(new BloqueContenedorDisponible(BloqueRepeticion.repetirDosVeces(),
                "Repite dos veces la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Repetir2.png",
                "Repetir 2"));

        bloques.add(new BloqueContenedorDisponible(BloqueRepeticion.repetirTresVeces(), "Repite tres veces la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Repetir3.png",
                "Repetir 3"));

        bloques.add(new BloqueContenedorDisponible(new BloqueInversion(), "Invierte la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Invertir.png",
                "Invertir"));
    }

    public void agregarBotones(VBox layoutBloques) {
        bloques.forEach(bloque -> bloque.agregarBoton(layoutBloques));
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks, VBox layoutBloques) {
        BloqueSimpleDisponible bloque = new BloqueSimpleDisponible(algoBlocks.guardarAlgoritmo(),
                nombre,
                RUTA_IMAGENES + "BloquePersonalizado.png");

        bloque.agregarBoton(layoutBloques);
    }
}

