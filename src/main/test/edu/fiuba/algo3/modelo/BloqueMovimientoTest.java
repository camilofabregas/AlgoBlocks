package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;


import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BloqueMovimientoTest {

    @Test
    public void test01EjecutarMovimientoALaDerecha(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueDerecha();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(PASO, 0)));
    }

    @Test
    public void test02EjecutarMovimientoALaDerechaDibujoTieneLineaCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueDerecha();

        movimiento.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(PASO, 0), true)));
    }

    @Test
    public void test03EjecutarMovimientoALaIzquierda(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueIzquierda();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO, 0)));
    }

    @Test
    public void test04EjecutarMovimientoALaIzquierdaDibujoTieneLineaCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueIzquierda();

        movimiento.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(-PASO, 0), true)));
    }

    @Test
    public void test05EjecutarMovimientoAbajo(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueAbajo();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(0, PASO)));
    }

    @Test
    public void test06EjecutarMovimientoAbajoDibujoTieneLineaCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueAbajo();

        movimiento.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(0, PASO), true)));
    }

    @Test
    public void test07EjecutarMovimientoArriba(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueArriba();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(0, -PASO)));
    }

    @Test
    public void test08EjecutarMovimientoALaDerechaDibujoTieneLineaCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueMovimiento movimiento = BloqueMovimiento.bloqueArriba();

        movimiento.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(0, -PASO), true)));
    }
}
