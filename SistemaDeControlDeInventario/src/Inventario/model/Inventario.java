package inventario.modelo;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public ArrayList<Producto> listar() {
        return productos;
    }
}