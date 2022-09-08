package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.*;

public class BloqueRepeticionTest {

    @Test
    public void test01BloqueRepeticionVacio(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(0,0))));
    }

    @Test
    public void test02BloqueRepeticion2Con1MovimientoPosicionCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(2*PASO,0))));
    }

    @Test
    public void test03BloqueRepeticion2Con2MovimientosPosicionCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueArriba());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(2*PASO,-2*PASO))));
    }
    @Test
    public void test04BloqueRepeticionCantidadLineasCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueRepeticion bloque = BloqueRepeticion.repetirTresVeces();

        personaje.bajarLapiz();
        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloque.ejecutar(personaje);

        assertEquals(7,dibujo.getCantidadLineas());
    }

    @Test
    public void test05BloqueRepeticionTieneLineasCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(new BloqueSubirLapiz());
        bloque.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea( new Linea(new Posicion(0, 0), new Posicion(PASO, 0), true)) &&
                dibujo.tieneLinea(new Linea(new Posicion(PASO, 0), new Posicion(2 * PASO, 0), false)));
    }

    @Test
    public void test06BloqueRepeticion3ConMovimiento2MovimientosPosicionCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueRepeticion bloque = BloqueRepeticion.repetirTresVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(3*PASO,3*PASO))));
    }

    @Test
    public void test07BloquesRepeticionAnidadosPosicionCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        BloqueRepeticion bloqueExterno = BloqueRepeticion.repetirDosVeces();
        BloqueRepeticion bloqueInterno = BloqueRepeticion.repetirTresVeces();

        bloqueInterno.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloqueInterno.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloqueExterno.agregarBloque(bloqueInterno);
        bloqueExterno.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(6*PASO,6 * PASO))));
    }

    @Test
    public void test08BloqueRepeticionConBloqueInversionPosicionCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueRepeticion bloque = BloqueRepeticion.repetirTresVeces();
        BloqueInversion bloqueInversion = new BloqueInversion();

        bloqueInversion.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloqueInversion.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloque.agregarBloque(bloqueInversion);
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(-PASO*3,-PASO*3))));
    }

    @Test
    public void test09BloqueRepeticionConBloquePersonalizadoPosicionCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();
        ArrayList<Bloque> lista = new ArrayList<>();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueAbajo());
        BloquePersonalizado bP = new BloquePersonalizado(lista);

        bloque.agregarBloque(bP);
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(PASO*2,PASO*2))));
    }

    @Test
    public void test10CopiaBloqueRepeticionNoSeActualizaConOriginal(){
        BloqueRepeticion bR = BloqueRepeticion.repetirDosVeces();
        Personaje personaje = new Personaje(new Dibujo());

        bR.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bR.agregarBloque(BloqueMovimiento.bloqueArriba());
        BloqueRepeticion copia = (BloqueRepeticion) bR.clone();
        bR.agregarBloque(BloqueMovimiento.bloqueArriba());
        copia.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2*PASO, -2*PASO)));
    }
}
