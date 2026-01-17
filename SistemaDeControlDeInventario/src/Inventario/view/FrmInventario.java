package Inventario.view;

import java.awt.*;
import javax.swing.*;

/**
 * Vista Principal del Inventario
 * Responsable: Edwin
 * Proyecto: Sistema de Control de Inventario
 */
public class FrmInventario extends JFrame {

    // --- Componentes Gráficos ---
    public JPanel pnlPrincipal;
    private JLabel lblTitulo;
    
    // Campos de Texto (Públicos para que el Controller acceda fácil)
    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JTextField txtPrecio;
    public JTextField txtStock;
    
    // Botones
    public JButton btnAgregar;
    public JButton btnLimpiar;
    public JButton btnSalir;

    public FrmInventario() {
        setTitle("Control de Inventario - Team Jaima/Edwin/Josue/Sebas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null); // Centrar
        setResizable(false);
        
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(null);
        pnlPrincipal.setBackground(new Color(240, 248, 255)); // Azul muy pálido

        // Título
        lblTitulo = new JLabel("Gestión de Productos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(50, 20, 500, 40);
        pnlPrincipal.add(lblTitulo);

        // --- Etiquetas y Cajas de Texto ---
        
        // Código
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(50, 80, 100, 25);
        pnlPrincipal.add(lblCodigo);
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 80, 150, 25);
        pnlPrincipal.add(txtCodigo);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 120, 100, 25);
        pnlPrincipal.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 120, 300, 25);
        pnlPrincipal.add(txtNombre);

        // Precio
        JLabel lblPrecio = new JLabel("Precio ($):");
        lblPrecio.setBounds(50, 160, 100, 25);
        pnlPrincipal.add(lblPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 160, 100, 25);
        pnlPrincipal.add(txtPrecio);

        // Stock
        JLabel lblStock = new JLabel("Cantidad:");
        lblStock.setBounds(300, 160, 80, 25);
        pnlPrincipal.add(lblStock);
        
        txtStock = new JTextField();
        txtStock.setBounds(380, 160, 70, 25);
        pnlPrincipal.add(txtStock);

        // --- Botones ---
        
        btnAgregar = new JButton("Guardar Producto");
        btnAgregar.setBackground(new Color(40, 167, 69)); // Verde éxito
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBounds(150, 250, 300, 40);
        btnAgregar.setFocusPainted(false);
        pnlPrincipal.add(btnAgregar);
        
        btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.setBackground(new Color(255, 193, 7)); // Amarillo
        btnLimpiar.setBounds(150, 300, 140, 30);
        pnlPrincipal.add(btnLimpiar);

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(220, 53, 69)); // Rojo
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBounds(310, 300, 140, 30);
        pnlPrincipal.add(btnSalir);

        this.add(pnlPrincipal);
    }
    
    // Método main para probar visualmente
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new FrmInventario().setVisible(true));
    }
}