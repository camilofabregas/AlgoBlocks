package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.*;

public class BloqueInversionTest {


    @Test
    public void test01BloqueInversionInvierteVacioNoHaceNada(){
        BloqueInversion b1 = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(0, 0)));
    }

    @Test
    public void test02BloqueInversionInvierteUnMovimiento(){
        BloqueInversion b1 = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());

        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO, 0)));
    }

    @Test
    public void test03BloqueInversionAgregaADibujoLineaCorrecta(){
        Dibujo dibujo = new Dibujo();
        BloqueInversion b1 = new BloqueInversion();
        Personaje personaje = new Personaje(dibujo);

        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(-PASO, 0), true)));
    }

    @Test
    public void test04BloquesInversionBajarLapizYMoverseDibujaLineaNoVisible(){
        Dibujo dibujo = new Dibujo();
        BloqueInversion b1 = new BloqueInversion();
        Personaje personaje = new Personaje(dibujo);

        b1.agregarBloque(new BloqueBajarLapiz());
        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertFalse(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test05BloquesInversionSubirLapizYMoverseDibujaLineaVisible(){
        Dibujo dibujo = new Dibujo();
        BloqueInversion b1 = new BloqueInversion();
        Personaje personaje = new Personaje(dibujo);

        b1.agregarBloque(new BloqueSubirLapiz());
        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertTrue(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test06BloquesInversionAnidadosNoInvierteBloquesInternos(){
        BloqueInversion b1 = new BloqueInversion();
        BloqueInversion b2 = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());

        b2.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.agregarBloque(b2);
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(PASO, 0)));
    }

    @Test
    public void test07BloquesInversionAnidadosInvierteBloquesSimplementeInvertidos(){
        BloqueInversion b1 = new BloqueInversion();
        BloqueInversion b2 = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());

        b2.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.agregarBloque(b2);
        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(0, 0)));
    }

    @Test
    public void test08BloquesInversionAnidadosInvierteBloquesTriplementeInvertidos(){
        BloqueInversion b1 = new BloqueInversion();
        BloqueInversion b2 = new BloqueInversion();
        BloqueInversion b3 = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());

        b3.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b2.agregarBloque(b3);
        b1.agregarBloque(b2);
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO, 0)));
    }

    @Test
    public void test09BloquesInversionConBloqueRepeticionPosicionCorrecta(){
        BloqueInversion bI = new BloqueInversion();
        BloqueRepeticion bR = BloqueRepeticion.repetirDosVeces();
        Personaje personaje = new Personaje(new Dibujo());

        bR.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bR.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bI.agregarBloque(bR);
        bI.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2*-PASO, 2*-PASO)));
    }

    @Test
    public void test10BloquesInversionConBloqueRepeticionTieneLineasCorrectas(){
        Dibujo dibujo = new Dibujo();
        BloqueInversion bI = new BloqueInversion();
        BloqueRepeticion bR = BloqueRepeticion.repetirDosVeces();
        Personaje personaje = new Personaje(dibujo);

        bR.agregarBloque(new BloqueBajarLapiz());
        bR.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bI.agregarBloque(bR);
        bI.ejecutar(personaje);
        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0, 0), new Posicion(-PASO, 0), true)) &&
                dibujo.tieneLinea(new Linea(new Posicion(-PASO, 0), new Posicion(-PASO*2, 0), false)));
    }

    @Test
    public void test11BloqueInversionConBloquePersonalizadoTienePosicionCorrecta(){
        BloqueInversion bI = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());
        ArrayList<Bloque> lista = new ArrayList<>();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bI.agregarBloque(bP);
        bI.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO, PASO)));
    }

    @Test
    public void test12BloqueInversionConBloquePersonalizadoDibujoTieneLineasCorrectas(){
        Dibujo dibujo = new Dibujo();
        BloqueInversion bI = new BloqueInversion();
        Personaje personaje = new Personaje(dibujo);
        ArrayList<Bloque> lista = new ArrayList<>();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(new BloqueBajarLapiz());
        lista.add(BloqueMovimiento.bloqueArriba());
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bI.agregarBloque(bP);
        bI.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0, 0), new Posicion(-PASO, 0), true)) &&
                dibujo.tieneLinea(new Linea(new Posicion(-PASO, 0), new Posicion(-PASO, PASO), false)));
    }

    @Test
    public void test13CopiaBloqueInversionNoSeActualizaConOriginal(){
        BloqueInversion bI = new BloqueInversion();
        Personaje personaje = new Personaje(new Dibujo());

        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bI.agregarBloque(BloqueMovimiento.bloqueArriba());
        BloqueInversion copia = (BloqueInversion) bI.clone();
        bI.agregarBloque(BloqueMovimiento.bloqueArriba());
        copia.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO, PASO)));
    }
}
