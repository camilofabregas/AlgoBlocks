package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloquePersonalizado;
import edu.fiuba.algo3.modelo.dibujo.Dibujo;

import java.util.ArrayList;

public class AlgoBlocks implements Observable{
    private final Dibujo dibujo = new Dibujo();
    private final Personaje personaje = new Personaje(dibujo);
    private final Algoritmo algoritmo = new Algoritmo();
    private final ArrayList<Observer> observers = new ArrayList<>();


    public Dibujo getDibujo() {
        return dibujo;
    }

    public void ejecutarAlgoritmo() {
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
        notifyObservers();
    }

    public BloquePersonalizado guardarAlgoritmo() {
        return algoritmo.guardar();
    }

    public Boolean personajeEstaEnPosicion(Posicion unaPosicion) {
        return personaje.estaEnPosicion(unaPosicion);
    }

    public int cantidadLineasDibujadas() {
        return dibujo.getCantidadLineas();
    }

    public int cantidadDeBloquesEnAlgoritmo() {
        return algoritmo.getCantidadDeBloques();
    }

    public void reiniciar() {
        dibujo.reiniciar();
        algoritmo.reiniciar();
        personaje.reiniciar();
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.change(this));
    }

}