package Inventario.controller;

import Inventario.model.Producto;
import Inventario.view.FrmInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * -------------------------------------------------------------------------
 * INTEGRANTE: Jaime Hidalgo(controller)
 * PROYECTO: Sistema de Control de Inventario
 * DESCRIPCIÓN: Gestiona la lógica, valida datos y actualiza la tabla.
 * -------------------------------------------------------------------------
 */
public class InventarioController implements ActionListener {

    private FrmInventario vista;
    // Base de datos temporal en memoria (Lista)
    private ArrayList<Producto> listaProductos;

    public InventarioController(FrmInventario vista) {
        this.vista = vista;
        this.listaProductos = new ArrayList<>(); // Inicializamos la lista

        // Escuchar botones
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregarProducto();
        }
        if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
        if (e.getSource() == vista.btnSalir) {
            int resp = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private void agregarProducto() {
        // 1. Validar que no haya campos vacíos
        if (vista.txtCodigo.getText().isEmpty() || vista.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Error: El Código y Nombre son obligatorios.");
            return;
        }

        try {
            // 2. Capturar datos
            String codigo = vista.txtCodigo.getText();
            String nombre = vista.txtNombre.getText();
            double precio = Double.parseDouble(vista.txtPrecio.getText());
            int stock = Integer.parseInt(vista.txtStock.getText());

            // 3. Crear el objeto 
            Producto nuevoProducto = new Producto(codigo, nombre, precio, stock);
            
            // 4. Guardar en la lista (Simulando BD)
            listaProductos.add(nuevoProducto);

            // 5. Actualizar la tabla 
            agregarFilaTabla(nuevoProducto);

            JOptionPane.showMessageDialog(vista, "¡Producto guardado correctamente!");
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Precio y Stock deben ser numéricos.");
        }
    }

    private void agregarFilaTabla(Producto p) {
        Object[] fila = new Object[5];
        fila[0] = p.getCodigo();
        fila[1] = p.getNombre();
        fila[2] = String.format("$ %.2f", p.getPrecio());
        fila[3] = p.getStock();
        fila[4] = String.format("$ %.2f", p.getValorTotal()); // Calculado
        
        vista.modeloTabla.addRow(fila);
    }

    private void limpiarCampos() {
        vista.txtCodigo.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
        vista.txtCodigo.requestFocus();
    }
}