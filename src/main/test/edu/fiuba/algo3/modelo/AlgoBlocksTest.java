package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.*;

public class AlgoBlocksTest {

    @Test
    public void test01AlgoBlocksNuevoAlgoritmoVacio() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertEquals(0, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test02AlgoBlocksNuevoPersonajeEnOrigen() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion()));
    }

    @Test
    public void test03AlgoBlocksAgregarBloqueAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());

        assertEquals(1, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test04AlgoBlocksAgregarBloqueMovimientoAlgoritmoSinEjecutarPosicionPersonajeNoCambia() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion()));
    }

    @Test
    public void test05AlgoBlocksAgregarBloqueYEjecutarAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test06AlgoBlocksAgregarBloqueMovimientoYEjecutarAlgoritmoPosicionPersonajeSeActualiza() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(PASO, 0)));
    }
    @Test
    public void test07AlgoBlocksEjecutarMovimientoEnPersonajeNuevoDibujaLinea() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, algoBlocks.cantidadLineasDibujadas());
    }

    @Test
    public void test08AlgoBlocksEjecutarSecuenciaBajarLapizYMoverPersonajeDibujaLineas() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(2, algoBlocks.cantidadLineasDibujadas());
    }

    @Test
    public void test09AlgoBlocksEjecutarSecuenciaMoverPersonajeNuevoYSubirLapizDibujaLineaVisible() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueSubirLapiz());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getDibujo().lineaEsVisible(0));
    }

    @Test
    public void test10AlgoBlocksAgregar3BloquesAlgoritmoTiene3Bloques() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        assertEquals(3, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test11AlgoBlocksEjecutarSecuenciaDe3BloquesMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(2 * PASO, PASO)));
    }

    @Test
    public void test12AlgoBlocksEjecutarSecuenciaDe3BloquesConLapizAbajoMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(PASO, PASO)));
    }

    @Test
    public void test13AlgoBlocksEjecutarSecuenciaDe3BloquesConLapizAbajoDibuja3Lineas() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(3, algoBlocks.cantidadLineasDibujadas());
    }

    @Test
    public void test14AlgoBlocksEjecutarBloqueRepeticionYLuego2BloqueMovimientoMueveCorrectamenteAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        BloqueRepeticion bloqueRepeticion = BloqueRepeticion.repetirTresVeces();
        bloqueRepeticion.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloqueRepeticion.agregarBloque(BloqueMovimiento.bloqueAbajo());

        algoBlocks.agregarBloque(bloqueRepeticion);
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(4*PASO, 2*PASO)));
    }

    @Test
    public void test15AlgoBlocksEjecutarBloqueInversionMueveCorrectamenteAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        BloqueInversion bI = new BloqueInversion();
        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bI.agregarBloque(BloqueMovimiento.bloqueAbajo());

        algoBlocks.agregarBloque(bI);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(-PASO, -PASO)));
    }

    @Test
    public void test16AlgoBlocksEjecutarBloqueAgregaLineasCorrectasAlDibujo() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        BloqueInversion bI = new BloqueInversion();
        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bI.agregarBloque(new BloqueBajarLapiz());
        bI.agregarBloque(BloqueMovimiento.bloqueAbajo());

        algoBlocks.agregarBloque(bI);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getDibujo().tieneLinea(new Linea(new Posicion(0,0), new Posicion(-PASO, 0), true)) &&
                algoBlocks.getDibujo().tieneLinea(new Linea(new Posicion(-PASO,0), new Posicion(-PASO, -PASO), false)));
    }

    @Test
    public void test17AlgoBlocksGuardarAlgoritmoVacioLanzaExcepcion() {
        assertThrows(GuardarAlgoritmoVacioException.class, () -> new AlgoBlocks().guardarAlgoritmo());
    }

    @Test
    public void test18AlgoBlocksEjecutarAlgoritmoGuardadoPosicionCorrecta() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        BloquePersonalizado bP = algoBlocks.guardarAlgoritmo();
        algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloque(bP);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(PASO, PASO)));
    }

    @Test
    public void test19AlgoBlocksEjecutarAlgoritmoGuardadoDibujoTieneLineasCorrectas() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueSubirLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        BloquePersonalizado bP = algoBlocks.guardarAlgoritmo();
        algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloque(bP);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getDibujo().tieneLinea(new Linea(new Posicion(0,0), new Posicion(PASO, 0), true)) &&
                algoBlocks.getDibujo().tieneLinea(new Linea(new Posicion(PASO,0), new Posicion(PASO, PASO), false)));
    }

    @Test
    public void test20AlgoBlocksReiniciarPersonajeEnPosicionInicial() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();
        algoBlocks.reiniciar();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion()));
    }

    @Test
    public void test21AlgoBlocksReiniciarAlgoritmoEstaVacio() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();
        algoBlocks.reiniciar();

        assertEquals(0, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test22AlgoBlocksTrasEjecutarAlgoritmoNoEstaVacio() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(3, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test23AlgoBlocksEjecutarDosVecesUnAlgoritmoPosicionPersonajeEsAcumulativa() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(2*PASO, 0)));
    }

    @Test
    public void test24AlgoBlocksEjecutarDosVecesUnAlgoritmoDibujoTieneElDobleDeLineasQueEjecutarloUna() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(2, algoBlocks.cantidadLineasDibujadas());
    }
}
