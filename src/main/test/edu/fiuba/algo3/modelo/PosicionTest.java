package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    @Test
    public void test01CompararPosicionesIguales() {
        Posicion posicion = new Posicion(3,0);
        Posicion nuevaPosicion = new Posicion (3,0);

        assertTrue(posicion.esIgualA(nuevaPosicion));
    }

    @Test
    public void test02CompararPosicionesDistintas() {
        Posicion posicion = new Posicion(3,-1);
        Posicion nuevaPosicion = new Posicion (3,0);

        assertFalse(posicion.esIgualA(nuevaPosicion));
    }

    @Test
    public void test03PosicionNuevaEstaEnOrigen() {
        Posicion posicion = new Posicion();

        assertTrue(posicion.esIgualA(new Posicion(0,0)));
    }

    @Test
    public void test04ObtenerSiguientePosicionConMovimientoADerecha() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.derecha());

        assertTrue(nuevaPos.esIgualA(new Posicion(PASO,0)));
    }

    @Test
    public void test05ObtenerSiguientePosicionConMovimientoAIzquierda() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.izquierda());

        assertTrue(nuevaPos.esIgualA(new Posicion(-PASO,0)));
    }

    @Test
    public void test06ObtenerSiguientePosicionConMovimientoArriba() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.arriba());

        assertTrue(nuevaPos.esIgualA(new Posicion(0,-PASO)));
    }

    @Test
    public void test07ObtenerSiguientePosicionConMovimientoAbajo() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.abajo());

        assertTrue(nuevaPos.esIgualA(new Posicion(0,PASO)));
    }

    @Test
    public void test08DesplazarPosicion() {
        Posicion posicion = new Posicion();
        posicion = posicion.desplazar(3, 0);

        assertTrue(posicion.esIgualA(new Posicion(3,0)));
    }

    @Test
    public void test09DesplazarPosicionMasDeUnaVez() {
        Posicion posicion = new Posicion();
        posicion = posicion.desplazar(3, -1);
        posicion = posicion.desplazar(-2, 4);

        assertTrue(posicion.esIgualA(new Posicion(1, 3)));
    }
}
