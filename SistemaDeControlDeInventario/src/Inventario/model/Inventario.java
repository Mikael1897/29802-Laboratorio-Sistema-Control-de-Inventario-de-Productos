package Inventario.model;

import java.util.ArrayList;

/**
 * -------------------------------------------------------------------------
 * INTEGRANTE: Sebastian (Team Inventario)
 * CLASE: Inventario (Lógica de Negocio / Gestión de Colección)
 * Esta clase encapsula el PROCESO DE GESTIÓN DE DATOS.
 * Sebastian es responsable de las acciones de agregar, listar y calcular
 * totales sobre la colección de productos.
 * -------------------------------------------------------------------------
 */
public class Inventario {
    
    // La lista se maneja aquí, no en el controlador
    private ArrayList<Producto> listaProductos;

    // Constructor: Inicializa la base de datos vacía
    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    // ACCIÓN: Agregar un producto a la lista
    public void agregarProducto(Producto p) {
        listaProductos.add(p);
    }

    // ACCIÓN: Obtener la lista completa 
    public ArrayList<Producto> obtenerTodos() {
        return listaProductos;
    }

    // PROCESO: Calcular el dinero total en bodega 
    public double calcularValorTotalBodega() {
        double total = 0;
        for (Producto p : listaProductos) {
            total += p.getValorTotal();
        }
        return total;
    }
    
    // Método para ver si está vacío
    public boolean estaVacio() {
        return listaProductos.isEmpty();
    }
}