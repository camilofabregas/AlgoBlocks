package edu.fiuba.algo3.modelo;

public class Direccion {
    static int PASO = 30;
    private final int dx;
    private final int dy;

    private Direccion(int dirHorizontal, int dirVertical){
        dx = dirHorizontal;
        dy = dirVertical;
    }

    public static Direccion derecha(){
        return new Direccion(PASO,0);
    }

    public static Direccion izquierda(){
        return new Direccion(-PASO,0);
    }

    public static Direccion arriba(){
        return new Direccion(0,-PASO);
    }

    public static Direccion abajo(){
        return new Direccion(0,PASO);
    }

    public static String direccionDesplazamiento(int dx, int dy) throws DireccionDesplazamientoInvalidaException {
        if(dx > 0 && dy == 0){
            return "Derecha";
        }else if(dx < 0 && dy == 0){
            return "Izquierda";
        }else if(dx == 0 && dy > 0){
            return "Abajo";
        }else if(dx == 0 && dy < 0){
            return "Arriba";
        }else if(dx == 0){
            return null;
        }
       throw new DireccionDesplazamientoInvalidaException();
    }

    public Posicion desplazar(Posicion posicion) { return posicion.desplazar(dx, dy); }

    public Direccion invertir(){
        return new Direccion(-dx, -dy);
    }
}
