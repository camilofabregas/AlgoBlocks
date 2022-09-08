package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.dibujo.Dibujo;
import edu.fiuba.algo3.modelo.dibujo.Linea;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01PersonajeNuevoTienePosicionEnElOrigen() {
        Personaje personaje = new Personaje(new Dibujo());

        assertTrue(personaje.estaEnPosicion(new Posicion(0,0)));
    }

    @Test
    public void test02MoverADerechaMueveElPersonajeUnaPosicionADerecha() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.derecha());
        assertTrue(personaje.estaEnPosicion(new Posicion(PASO,0)));
    }

    @Test
    public void test03MoverAIzquierdaMueveElPersonajeUnaPosicionAIzquierda() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO,0)));
    }

    @Test
    public void test04MoverArribaMueveElPersonajeUnaPosicionArriba() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.arriba());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,-PASO)));
    }

    @Test
    public void test05MoverAbajoMueveElPersonajeUnaPosicionAbajo() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.abajo());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,PASO)));
    }

    @Test
    public void test06MoverDosPosicionesEnDireccionesDistintasActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.abajo());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO,PASO)));
    }

    @Test
    public void test07MoverDosPosicionesEnMismaDireccionActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.derecha());
        assertTrue(personaje.estaEnPosicion(new Posicion(2 * PASO,0)));
    }

    @Test
    public void test08MoverDosPosicionesEnDireccionesOpuestasDevuelveALaPosicionOrigen() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,0)));
    }

    @Test
    public void test09MoverADerechaAUnPersonajeNuevoAgregaLineaVisibleAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.mover(Direccion.derecha());

        assertTrue(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test10MoverADerechaConLapizAbajoAgregaLineaVisibleAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());

        assertTrue(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test11MoverAUnPersonajeConLapizAbajoPorElMismoCaminoMasDeUnaVezVuelveAAgregarLinea() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());

        assertEquals(3, dibujo.getCantidadLineas());
    }

    @Test
    public void test12MoverUnaPosicionConLapizArribaYLuegoMoverOtraPosicionConLapizAbajoAgregaAgregaAmbasLineas() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.mover(Direccion.derecha());
        personaje.bajarLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(3, dibujo.getCantidadLineas());
    }

    @Test
    public void test13MoverConLapizAbajoElDibujoTieneEsaLinea() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        Linea linea = new Linea(new Posicion(0,0), new Posicion(PASO,0) , true);

        assertTrue(dibujo.tieneLinea(linea));
    }

    @Test
    public void test14MoverConLapizArribaElDibujoTieneEsaLinea() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.mover(Direccion.derecha());

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(PASO,0) , true)));
    }

    @Test
    public void test15BajarLapizDibujoTieneEsaLinea(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(), true)));
    }

    @Test
    public void test16SubirLapizDibujoTieneEsaLinea(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.subirLapiz();
        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(), false)));
    }

    @Test
    public void test17ReiniciarPersonajePosicionInicial() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.mover(Direccion.derecha());
        personaje.reiniciar();

        assertTrue(personaje.estaEnPosicion(new Posicion()));
    }

    @Test
    public void test18ReiniciarPersonajeYMoverDibujaLineaVisible() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.reiniciar();
        personaje.mover(Direccion.derecha());

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(PASO, 0), true)));
    }
}
