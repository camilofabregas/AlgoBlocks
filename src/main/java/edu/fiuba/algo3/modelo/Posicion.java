package edu.fiuba.algo3.modelo;

public class Posicion {

    private final int x;
    private final int y;

    public Posicion(){
        x = 0;
        y = 0;
    }

    public Posicion (int posX, int posY){
        x = posX;
        y = posY;
    }

    public Posicion obtenerSiguiente(Direccion unaDireccion) {
        return unaDireccion.desplazar(this);
    }

    public Posicion desplazar(int dirHorz, int dirVert){ return new Posicion(x + dirHorz, y + dirVert); }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean esIgualA(Posicion unaPosicion) {
        return ((unaPosicion.x == x) && (unaPosicion.y == y));
    }

    public int desplazaminetoEnX(Posicion unaPosicion){
        return (this.x - unaPosicion.x);
    }

    public int desplazamientoEnY(Posicion unaPosicion){
        return (this.y - unaPosicion.y);
    }
}
