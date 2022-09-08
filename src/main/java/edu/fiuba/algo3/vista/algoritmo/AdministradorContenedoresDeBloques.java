package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.controlador.ControladorContenedorPrincipalDeBloques;
import edu.fiuba.algo3.controlador.ControladorContenedorInternoDeBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import edu.fiuba.algo3.vista.VistaScrollPane;

import java.util.HashMap;

public class AdministradorContenedoresDeBloques{
    private static AdministradorContenedoresDeBloques instancia;
    private final HashMap<String, LayoutContenedorDeBloques>  layoutsContenedoresDeBloques = new HashMap<>();
    private final SelectorContenedorDeBloquesParaAgregar selectorContenedorDeBloquesParaAgregar;
    private final ContadorBloquesCompuestos contadorBloquesCompuestos = new ContadorBloquesCompuestos();
    private final String descripcionAlgoritmo = "Algoritmo";

    public AdministradorContenedoresDeBloques(AlgoBlocks algoBlocks, VistaScrollPane layoutAlgoritmo, SelectorContenedorDeBloquesParaAgregar unSelector){
        layoutsContenedoresDeBloques.put(descripcionAlgoritmo, new LayoutContenedorPrincipalDeBloques(descripcionAlgoritmo, new ControladorContenedorPrincipalDeBloques(algoBlocks)));
        selectorContenedorDeBloquesParaAgregar = unSelector;
        layoutAlgoritmo.setContent(layoutsContenedoresDeBloques.get(descripcionAlgoritmo));
        instancia = this;
    }

    public void reiniciar(){
        LayoutContenedorPrincipalDeBloques layoutAlgoblocks = (LayoutContenedorPrincipalDeBloques)layoutsContenedoresDeBloques.get(descripcionAlgoritmo);
        layoutsContenedoresDeBloques.clear();
        layoutAlgoblocks.reiniciar();
        layoutsContenedoresDeBloques.put(descripcionAlgoritmo, layoutAlgoblocks);

        contadorBloquesCompuestos.reiniciar();
    }

    private LayoutContenedorDeBloques layoutContenedorBloqueActual(){
        return layoutsContenedoresDeBloques.get(selectorContenedorDeBloquesParaAgregar.getActual());
    }

    public void agregar(BloqueContenedor bloque, String rutaImagen, String nombreBloque) {
        contadorBloquesCompuestos.agregar(nombreBloque);
        String descripcion = ("Bloque" + nombreBloque + " - " + contadorBloquesCompuestos.getCantidad(nombreBloque));

        LayoutContenedorInternoDeBloques layoutContenedorNuevo =
                new LayoutContenedorInternoDeBloques(descripcion,new ControladorContenedorInternoDeBloques(bloque), rutaImagen);
        layoutsContenedoresDeBloques.put(descripcion, layoutContenedorNuevo);
        layoutContenedorBloqueActual().agregarBloqueContenedor(bloque, descripcion, layoutContenedorNuevo);
       selectorContenedorDeBloquesParaAgregar.agregar(descripcion);
    }

    public void agregar(Bloque bloque, String rutaImagen) {
        layoutContenedorBloqueActual().agregarBloque(bloque, rutaImagen);
    }

    public static AdministradorContenedoresDeBloques getInstancia(){
        return instancia;
    }
}
