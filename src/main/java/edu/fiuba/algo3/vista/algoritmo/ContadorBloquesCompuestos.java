package edu.fiuba.algo3.vista.algoritmo;

import java.util.HashMap;

public class ContadorBloquesCompuestos {
    private static final HashMap<String, Integer> contador = new HashMap<>();

    public void reiniciar(){
        contador.forEach((s, integer) -> contador.replace(s, 0));
    }

    public void agregar(String nombreBloque) {
        contador.put(nombreBloque, contador.getOrDefault(nombreBloque, 0) + 1);
    }

    public int getCantidad(String nombreBloque) {
        return contador.get(nombreBloque);
    }
}
