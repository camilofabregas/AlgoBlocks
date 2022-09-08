package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {

    @Test
    public void test01DosLineasConMismoOrigenDestinoYVisibilidadSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(), new Posicion(0,1), true);
        assertTrue(linea.esIgual(linea2));
    }

    @Test
    public void test02DosLineasConOrigenYDestinoInvertidosYMismaVisibilidadNoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(0,1), new Posicion(), true);
        assertFalse(linea.esIgual(linea2));
    }

    @Test
    public void test03DosLineasConOrigenDestinoYVisibilidadInvertidosNoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(0,1), new Posicion(), false);
        assertFalse(linea.esIgual(linea2));
    }

    @Test
    public void test04DosLineasConMismoOrigenYDestinoYVisibilidadInvertidaNoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(), new Posicion(0,1), false);
        assertFalse(linea.esIgual(linea2));
    }

    @Test
    public void test05UnaLineaConEjeXMayorEnDestinoTieneDireccionDerecha(){
        assertEquals(new Linea(new Posicion(), new Posicion(1, 0), true).getDireccion(), "Derecha");
    }

    @Test
    public void test06UnaLineaConEjeXMenorEnDestinoTieneDireccionIzquierda(){
        assertEquals(new Linea(new Posicion(), new Posicion(-1, 0), true).getDireccion(), "Izquierda");
    }

    @Test
    public void test08UnaLineaConEjeYMenorEnDestinoTieneDireccionArriba(){
        assertEquals(new Linea(new Posicion(), new Posicion(0, -1), true).getDireccion(), "Arriba");
    }

    @Test
    public void test09UnaLineaConEjeYMayorEnDestinoTieneDireccionAbajo(){
        assertEquals(new Linea(new Posicion(), new Posicion(0, 1), true).getDireccion(), "Abajo");
    }

    @Test
    public void test10UnaLineaConDestinoYOrigenIgualesTieneDireccionNull(){
        assertNull(new Linea(new Posicion(), new Posicion(), true).getDireccion());
    }

    @Test
    public void test11UnaLineaConDesplazamientoEnEjeXEYLanzaExcepcion(){
        assertThrows(DireccionDesplazamientoInvalidaException.class, () -> new Linea(new Posicion(), new Posicion(1, 1), true).getDireccion());
    }
}