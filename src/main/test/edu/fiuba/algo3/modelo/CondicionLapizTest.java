package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.lapiz.CondicionLapiz;
import edu.fiuba.algo3.modelo.lapiz.LapizAbajo;
import edu.fiuba.algo3.modelo.lapiz.LapizArriba;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CondicionLapizTest {

    @Test
    public void test01LapizArribaDibujaLineaNoVisible(){
        CondicionLapiz condicion = new LapizArriba();
        Dibujo dibujo = new Dibujo();

        condicion.dibujarLinea(new Posicion(0, 0), new Posicion(0, 1), dibujo);

        assertFalse(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test02LapizAbajoDibujaLineaVisible(){
        CondicionLapiz condicion = new LapizAbajo();
        Dibujo dibujo = new Dibujo();

        condicion.dibujarLinea(new Posicion(0, 0), new Posicion(0, 1), dibujo);

        assertTrue(dibujo.lineaEsVisible(0));
    }
}
