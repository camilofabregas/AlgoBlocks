package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.bloque.*;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.*;

public class AlgoritmoTest {

    @Test
    public void test01AlgoritmoNuevoNoTieneBloques() {
        Algoritmo algoritmo = new Algoritmo();

        assertEquals(0, algoritmo.getCantidadDeBloques());
    }

    @Test
    public void test02AlgoritmoAgregar2BloquesTiene2Bloques() {
        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());

        assertEquals(2, algoritmo.getCantidadDeBloques());
    }

    @Test
    public void test03TrasEjecutarAlgoritmoCon2BloquesAlgoritmoTiene2Bloques() {
        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.ejecutar(new Personaje(new Dibujo()));

        assertEquals(2, algoritmo.getCantidadDeBloques());
    }

    @Test
    public void test04TrasEjecutarAlgoritmoPosicionPersonajeSeActualiza() {
        Algoritmo algoritmo = new Algoritmo();
        Personaje personaje = new Personaje(new Dibujo());

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueIzquierda());
        algoritmo.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO,-PASO)));
    }

    @Test
    public void test05TrasEjecutarAlgoritmoDibujoTieneCantidadCorrectaDeLineas() {
        Algoritmo algoritmo = new Algoritmo();
        Dibujo dibujo = new Dibujo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueIzquierda());
        algoritmo.ejecutar(new Personaje(dibujo));

        assertEquals(2, dibujo.getCantidadLineas());
    }

    @Test
    public void test06TrasEjecutarAlgoritmoDibujoTieneLineaCorrecta() {
        Algoritmo algoritmo = new Algoritmo();
        Dibujo dibujo = new Dibujo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.ejecutar(new Personaje(dibujo));

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(0, PASO), true)));
    }

    @Test
    public void test07TrasEjecutarAlgoritmoConBloqueRepeticionDibujoTieneCantidadCorrectaDeLineas() {
        Algoritmo algoritmo = new Algoritmo();
        BloqueRepeticion bloqueRepeticion = BloqueRepeticion.repetirTresVeces();
        Dibujo dibujo = new Dibujo();

        bloqueRepeticion.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.agregarBloque(bloqueRepeticion);
        algoritmo.ejecutar(new Personaje(dibujo));

        assertEquals(3, dibujo.getCantidadLineas());
    }

    @Test
    public void test08TrasEjecutarAlgoritmoConBloqueRepeticionDibujoTieneLineasCorrectas() {
        Algoritmo algoritmo = new Algoritmo();
        BloqueRepeticion bloqueRepeticion = BloqueRepeticion.repetirDosVeces();
        Dibujo dibujo = new Dibujo();

        bloqueRepeticion.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.agregarBloque(bloqueRepeticion);
        algoritmo.ejecutar(new Personaje(dibujo));

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(0, PASO), true)) &&
                dibujo.tieneLinea(new Linea(new Posicion(0,PASO), new Posicion(0, 2*PASO), true)));
    }

    @Test
    public void test09TrasEjecutarAlgoritmoConBloqueInversionDibujoTieneCantidadCorrectaDeLineas() {
        Algoritmo algoritmo = new Algoritmo();
        BloqueInversion bloqueInversion = new BloqueInversion();
        Dibujo dibujo = new Dibujo();

        bloqueInversion.agregarBloque(BloqueMovimiento.bloqueIzquierda());
        bloqueInversion.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(bloqueInversion);
        algoritmo.ejecutar(new Personaje(dibujo));

        assertEquals(2, dibujo.getCantidadLineas());
    }

    @Test
    public void test10TrasEjecutarAlgoritmoConBloqueInversionDibujoTieneLineasCorrectas() {
        Algoritmo algoritmo = new Algoritmo();
        BloqueInversion bloqueInversion = new BloqueInversion();
        Dibujo dibujo = new Dibujo();

        bloqueInversion.agregarBloque(BloqueMovimiento.bloqueIzquierda());
        bloqueInversion.agregarBloque(new BloqueBajarLapiz());
        algoritmo.agregarBloque(bloqueInversion);
        algoritmo.ejecutar(new Personaje(dibujo));

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(PASO, 0), true)) &&
                dibujo.tieneLinea(new Linea(new Posicion(PASO,0), new Posicion(PASO, 0), false)));
    }

    @Test
    public void test11NoSePuedeGuardarUnAlgoritmoVacio() {

        assertThrows(GuardarAlgoritmoVacioException.class, () -> new Algoritmo().guardar());
    }

    @Test
    public void test12ReiniciarAlgoritmoAlgoritmoEstaVacio() {

        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.reiniciar();

        assertEquals(0, algoritmo.getCantidadDeBloques());
    }
}
