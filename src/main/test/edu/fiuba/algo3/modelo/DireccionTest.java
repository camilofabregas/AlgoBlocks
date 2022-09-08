package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01DesplazarDireccionDerechaPosicionCorrecta() {
        Direccion dir = Direccion.derecha();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(PASO,0)));
    }

    @Test
    public void test02DesplazarDireccionIzquierdaPosicionCorrecta() {
        Direccion dir = Direccion.izquierda();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(-PASO,0)));
    }

    @Test
    public void test03DesplazarDireccionArribaPosicionCorrecta() {
        Direccion dir = Direccion.arriba();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(0,-PASO)));
    }

    @Test
    public void test04DesplazarDireccionAbajoPosicionCorrecta() {
        Direccion dir = Direccion.abajo();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(0,PASO)));
    }

    @Test
    public void test05DesplazarDireccionAbajoYLuegoDerechaPosicionCorrecta() {
        Direccion dirAbajo = Direccion.abajo();
        Direccion dirDerecha = Direccion.derecha();
        Posicion pos = new Posicion();

        pos = dirAbajo.desplazar(pos);
        pos = dirDerecha.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(PASO,PASO)));
    }

    @Test
    public void test06DesplazamientoPositivoEnXDireccionDesplazamientoEsDerecha(){
        Assertions.assertEquals(Direccion.direccionDesplazamiento(1, 0), "Derecha");
    }

    @Test
    public void test07DesplazamientoNegativoEnXDireccionDesplazamientoEsIzquierda(){
        Assertions.assertEquals(Direccion.direccionDesplazamiento(-1, 0), "Izquierda");
    }

    @Test
    public void test08DesplazamientoPositivoEnYDireccionDesplazamientoEsAbajo(){
        Assertions.assertEquals(Direccion.direccionDesplazamiento(0, 1), "Abajo");
    }

    @Test
    public void test09DesplazamientoNegativoEnYDireccionEsArriba(){
        Assertions.assertEquals(Direccion.direccionDesplazamiento(0, -1), "Arriba");
    }

    @Test
    public void test10DesplazamientoNuloDireccionEsNull(){
        Assertions.assertNull(Direccion.direccionDesplazamiento(0, 0));
    }
}
