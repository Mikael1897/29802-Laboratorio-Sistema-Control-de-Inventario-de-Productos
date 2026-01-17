package Inventario.controller;

import Inventario.model.Producto;
import Inventario.view.FrmInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * -------------------------------------------------------------------------
 * INTEGRANTE: Jaime (Team Inventario)
 * CLASE: InventarioController (Controlador)
 * Esta clase ejecuta el PROCESO DE CONTROL.
 * Su función es escuchar las ACCIONES de la vista (botones) y 
 * coordinar la creación de objetos del modelo (Producto).
 * -------------------------------------------------------------------------
 */
public class InventarioController implements ActionListener {

    private FrmInventario vista; 
    private Producto modelo;     

    // Constructor: Vincula las partes
    public InventarioController(FrmInventario vista) {
        this.vista = vista;
        
        // ACCIÓN: Suscribirse a los eventos de los botones 
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    // Método para arrancar la ventana
    public void iniciar() {
        vista.setTitle("Sistema Inventario - MVC (Jaime/Josue/Edwin)");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    // ACCIÓN: Manejo de clics
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnAgregar) {
            crearProducto();
        }
        
        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
        
        if (e.getSource() == vista.btnSalir) {
            System.exit(0);
        }
    }

    // PROCESO: Lógica para tomar datos y crear el objeto
    private void crearProducto() {
        try {
            // Obtenemos datos de la vista
            String cod = vista.txtCodigo.getText();
            String nom = vista.txtNombre.getText();
            double pre = Double.parseDouble(vista.txtPrecio.getText());
            int stk = Integer.parseInt(vista.txtStock.getText());

            modelo = new Producto(cod, nom, pre, stk);
            
            JOptionPane.showMessageDialog(vista, "¡Guardado con éxito!\n" + modelo.toString());
            limpiar();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Precio y Stock deben ser números.");
        }
    }

    private void limpiar() {
        vista.txtCodigo.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
    }
}