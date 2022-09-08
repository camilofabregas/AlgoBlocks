package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import edu.fiuba.algo3.modelo.lapiz.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LapizTest {

    @Test
    public void test01LapizNuevoDibujaLineaVisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.dibujarLinea(new Posicion(), new Posicion(1,0), dibujo);

        assertTrue(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test02BajoLapizYDibujaUnaLineaVisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar(dibujo, new Posicion());
        lapiz.dibujarLinea(new Posicion(), new Posicion(0,1), dibujo);

        assertTrue(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test03SuboLapizYDibujaLineaInvisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.subir(dibujo, new Posicion());
        lapiz.dibujarLinea(new Posicion(), new Posicion(0,1), dibujo);

        assertFalse(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test04BajoYSuboLapizYDibujaLineaNoVisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar(dibujo, new Posicion());
        lapiz.subir(dibujo, new Posicion());
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertFalse(dibujo.lineaEsVisible(2));
    }

    @Test
    public void test05LapizArribaDibujaLineaCorrecta() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar(dibujo, new Posicion());
        lapiz.subir(dibujo, new Posicion());
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(0, 1), false)));
    }

    @Test
    public void test06LapizAbajoDibujaLineaCorrecta() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar(dibujo, new Posicion());
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(0, 1), true)));
    }

    @Test
    public void test07BajarLapizAgregaLineaVisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar(dibujo, new Posicion());

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(), true)));
    }

    @Test
    public void test08SubirLapizAgregaLineaInvisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.subir(dibujo, new Posicion());

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(), false)));
    }
}