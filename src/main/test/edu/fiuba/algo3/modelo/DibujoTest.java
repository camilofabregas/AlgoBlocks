package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void test01DibujoNuevoEstaVacio(){
        Dibujo dibujo = new Dibujo();

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test02DibujoGuardaVariasLineas() {
        Dibujo dibujo = new Dibujo();

        dibujo.dibujarLinea(new Posicion(), new Posicion(0, 1), true);
        dibujo.dibujarLinea(new Posicion(0, 1), new Posicion(1, 2), true);
        dibujo.dibujarLinea(new Posicion(2, 3), new Posicion(2, 5), false);

        assertEquals(3, dibujo.getCantidadLineas());
    }

    @Test
    public void test03DibujoGuardaDosLineasIguales() {
        Dibujo dibujo = new Dibujo();
        Posicion posicion1 = new Posicion();
        Posicion posicion2 = new Posicion(0,1);

        dibujo.dibujarLinea(posicion1, posicion2, true);
        dibujo.dibujarLinea(posicion2, posicion1, true);

        assertEquals(2, dibujo.getCantidadLineas());
    }
    @Test
    public void test04DibujarLineaConMismoOrigenYFinDibujoAgregaLinea(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(), new Posicion(), true);

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test05DibujoUnaLineaYElDibujoLaTiene(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(3,2), new Posicion(2,2), true);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(3,2), new Posicion(2,2), true)));
    }

    @Test
    public void test06DibujoUnaLineaYElDibujoNoTieneOtraDistinta(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(3,2), new Posicion(2,2), true);
        Linea linea = new Linea(new Posicion(3,2), new Posicion(0,2), true);

        assertFalse(dibujo.tieneLinea(linea));
    }

    @Test
    public void test07DibujoUnaLineaYElDibujoNoTieneUnaConMismosExtremosPeroVisibilidadDistinta(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(3,2), new Posicion(2,2), true);
        Linea linea = new Linea(new Posicion(3,2), new Posicion(0,2), false);

        assertFalse(dibujo.tieneLinea(linea));
    }

    @Test
    public void test08ReiniciarDibujoDibujoEstaVacio(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(3,2), new Posicion(2,2), true);
        dibujo.reiniciar();

        assertEquals(0, dibujo.getCantidadLineas());
    }
}