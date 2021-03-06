/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Yow
 */
public class ComprasFormulario extends javax.swing.JFrame {

    ControladorCompras cc;
    DefaultTableModel jTableModel;
    public UsuarioSistema us;

    public ComprasFormulario() {
        initComponents();
        cc = new ControladorCompras(1);
        buttonGroup1.add(jRadioButtonNuevoProducto);
        buttonGroup1.add(jRadioButtonProductoExistente);
        jTableModel = (DefaultTableModel) jTable4.getModel();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/programa.png")).getImage());
        limpiar();
    }
    
    public ComprasFormulario(UsuarioSistema us) {
        initComponents();
        this.us = us;
        cc = new ControladorCompras(1);
        buttonGroup1.add(jRadioButtonNuevoProducto);
        buttonGroup1.add(jRadioButtonProductoExistente);
        jTableModel = (DefaultTableModel) jTable4.getModel();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/programa.png")).getImage());
        limpiar();
    }

    public void limpiar() {
        jTextFieldIE.setText("");
        jTextFieldIE.setEnabled(false);
        jRadioButtonNuevoProducto.setSelected(false);
        jRadioButtonProductoExistente.setSelected(false);
        jTextFieldCantidad.setText("");
        jTextFieldDescripcion.setText("");
        jTextFieldPrecio.setText("");
        jTextFieldNombre.setText("");
        jTextFieldCantidad.setEnabled(false);
        jTextFieldDescripcion.setEnabled(false);
        jTextFieldPrecio.setEnabled(false);
        jTextFieldNombre.setEnabled(false);
        jTextFieldIdGenerado.setText("");
        jTextFieldIdGenerado.setEnabled(false);
        jLabelFecha.setText("Fecha: " + cc.getCompra().getFecha().toString());
        jLabelIdCompra.setText("ID: " + cc.getCompra().getIdCompra());
        jLabelTotal.setText("Total: " + cc.getCompra().getTotal());
        jTableModel = cc.getTableModel(jTableModel);
    }

    public Insumo getInsumo() {
        boolean esNuevo = jRadioButtonNuevoProducto.isSelected();

        if (esNuevo) {
            return new Insumo(0, jTextFieldIdGenerado.getText(), jTextFieldNombre.getText(),
                     jTextFieldDescripcion.getText(), Integer.parseInt(jTextFieldCantidad.getText()),
                     Float.parseFloat(jTextFieldPrecio.getText()));
        } else {
            Insumo p = InsumoSQL.getInsumo(Integer.parseInt(jTextFieldIE.getText()));
            p.setExistencias(Integer.parseInt(jTextFieldCantidad.getText()));
            return p;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonProductoExistente = new javax.swing.JRadioButton();
        jRadioButtonNuevoProducto = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabelIdCompra = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabelProveedor = new javax.swing.JLabel();
        btt_inicio = new javax.swing.JButton();
        btt_inicio2 = new javax.swing.JButton();
        jTextFieldIE = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldIdGenerado = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jTextFieldIdProveedor = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        btt_inicio1 = new javax.swing.JButton();
        jLabelVerificarInsumo = new javax.swing.JLabel();
        jLabelVerificarProveedor = new javax.swing.JLabel();
        jLabelProveedor1 = new javax.swing.JLabel();
        jLabelProveedor2 = new javax.swing.JLabel();
        jTextFieldNombreInsumo = new javax.swing.JTextField();
        jLabelProveedor3 = new javax.swing.JLabel();
        jTextFieldNombreProveedor = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Compras");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 28, 217, 52));

        jSeparator5.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator5.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 86, 256, 18));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nuevo insumo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 161, -1));

        jRadioButtonProductoExistente.setBackground(new java.awt.Color(102, 102, 102));
        jRadioButtonProductoExistente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonProductoExistenteMouseClicked(evt);
            }
        });
        jRadioButtonProductoExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProductoExistenteActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonProductoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jRadioButtonNuevoProducto.setBackground(new java.awt.Color(102, 102, 102));
        jRadioButtonNuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonNuevoProductoMouseClicked(evt);
            }
        });
        jRadioButtonNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNuevoProductoActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Insumo existente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 161, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Cantidad");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Precio");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Descripci??n");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jTextFieldPrecio.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldPrecio.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldPrecio.setBorder(null);
        jTextFieldPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPrecioFocusGained(evt);
            }
        });
        jTextFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 186, 30));

        jTextFieldDescripcion.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldDescripcion.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldDescripcion.setBorder(null);
        jTextFieldDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDescripcionFocusGained(evt);
            }
        });
        jTextFieldDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 470, 30));

        jTextFieldCantidad.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldCantidad.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldCantidad.setBorder(null);
        jTextFieldCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCantidadFocusGained(evt);
            }
        });
        jTextFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 270, 186, 30));

        jSeparator3.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator3.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, 190, 9));

        jSeparator4.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator4.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 190, 9));

        jSeparator6.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator6.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 470, 9));

        jLabelIdCompra.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelIdCompra.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdCompra.setText("ID Compra:");
        jPanel1.add(jLabelIdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 710, -1, -1));

        jLabelFecha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setText("Fecha:");
        jPanel1.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 710, -1, -1));

        jLabelTotal.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("Total:");
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 710, -1, -1));

        jTable4.setAutoCreateRowSorter(true);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Generado", "Nombre", "Descripcion", "Cantidad", "Precio", "Subtotal"
            }
        ));
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setIntercellSpacing(new java.awt.Dimension(0, 5));
        jTable4.setRowHeight(25);
        jTable4.setSelectionBackground(new java.awt.Color(60, 187, 9));
        jScrollPane1.setViewportView(jTable4);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 1180, 300));

        jLabelProveedor.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelProveedor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProveedor.setText("Nombre insumo");
        jPanel1.add(jLabelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        btt_inicio.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio.setText("Agregar al carrito");
        btt_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicioActionPerformed(evt);
            }
        });
        jPanel1.add(btt_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 159, 40));

        btt_inicio2.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio2.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio2.setText("Realizar Compra");
        btt_inicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicio2ActionPerformed(evt);
            }
        });
        jPanel1.add(btt_inicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, 159, 40));

        jTextFieldIE.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldIE.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldIE.setBorder(null);
        jTextFieldIE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIEFocusGained(evt);
            }
        });
        jTextFieldIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIEActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 200, 30));

        jTextFieldNombre.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldNombre.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldNombre.setBorder(null);
        jTextFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFocusGained(evt);
            }
        });
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 186, 30));

        jSeparator7.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator7.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 190, 9));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Nombre");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ID Generado");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jTextFieldIdGenerado.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldIdGenerado.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldIdGenerado.setBorder(null);
        jTextFieldIdGenerado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIdGeneradoFocusGained(evt);
            }
        });
        jTextFieldIdGenerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdGeneradoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldIdGenerado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 30));

        jSeparator8.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator8.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 160, 9));

        jTextFieldIdProveedor.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldIdProveedor.setBorder(null);
        jTextFieldIdProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIdProveedorFocusGained(evt);
            }
        });
        jTextFieldIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 200, 30));

        jSeparator9.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator9.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 180, 9));

        btt_inicio1.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio1.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio1.setText("Regresar");
        btt_inicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicio1ActionPerformed(evt);
            }
        });
        jPanel1.add(btt_inicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 740, -1, -1));

        jLabelVerificarInsumo.setBackground(new java.awt.Color(79, 82, 84));
        jLabelVerificarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lens.png"))); // NOI18N
        jLabelVerificarInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVerificarInsumoMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelVerificarInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        jLabelVerificarProveedor.setBackground(new java.awt.Color(79, 82, 84));
        jLabelVerificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lens.png"))); // NOI18N
        jLabelVerificarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVerificarProveedorMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelVerificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        jLabelProveedor1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelProveedor1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProveedor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProveedor1.setText("ID Proveedor");
        jPanel1.add(jLabelProveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabelProveedor2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelProveedor2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProveedor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProveedor2.setText("ID Proveedor");
        jPanel1.add(jLabelProveedor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jTextFieldNombreInsumo.setEditable(false);
        jTextFieldNombreInsumo.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldNombreInsumo.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldNombreInsumo.setBorder(null);
        jTextFieldNombreInsumo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreInsumoFocusGained(evt);
            }
        });
        jTextFieldNombreInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreInsumoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNombreInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 180, 30));

        jLabelProveedor3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelProveedor3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProveedor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProveedor3.setText("Nombre proveedor");
        jPanel1.add(jLabelProveedor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jTextFieldNombreProveedor.setEditable(false);
        jTextFieldNombreProveedor.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldNombreProveedor.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldNombreProveedor.setBorder(null);
        jTextFieldNombreProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreProveedorFocusGained(evt);
            }
        });
        jTextFieldNombreProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 180, 30));

        jSeparator10.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator10.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 203, 9));

        jSeparator11.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator11.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 203, 9));

        jSeparator12.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator12.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 180, 9));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1285, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIEActionPerformed

    private void jTextFieldIEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIEFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIEFocusGained

    private void btt_inicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicio2ActionPerformed
        cc.realizarCompra(Integer.parseInt(jTextFieldIdProveedor.getText()));
        limpiar();
    }//GEN-LAST:event_btt_inicio2ActionPerformed

    private void btt_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicioActionPerformed
        cc.agregarEnCanasta(getInsumo(), jRadioButtonNuevoProducto.isEnabled());
        limpiar();
    }//GEN-LAST:event_btt_inicioActionPerformed

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jTextFieldCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCantidadFocusGained
        // TODO add your handling code here:
        jTextFieldCantidad.setText("");
        jTextFieldCantidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldCantidadFocusGained

    private void jTextFieldDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescripcionActionPerformed

    private void jTextFieldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDescripcionFocusGained
        // TODO add your handling code here:
        jTextFieldDescripcion.setText("");
        jTextFieldDescripcion.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldDescripcionFocusGained

    private void jTextFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioActionPerformed

    private void jTextFieldPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecioFocusGained
        // TODO add your handling code here:
        jTextFieldPrecio.setText("");
        jTextFieldPrecio.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldPrecioFocusGained

    private void jRadioButtonNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNuevoProductoActionPerformed
        jTextFieldIE.setEnabled(false);
        jTextFieldPrecio.setEnabled(true);
        jTextFieldDescripcion.setEnabled(true);
        jTextFieldNombre.setEnabled(true);
        jTextFieldCantidad.setEnabled(true);
        jTextFieldIdGenerado.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonNuevoProductoActionPerformed

    private void jRadioButtonNuevoProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonNuevoProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNuevoProductoMouseClicked

    private void jRadioButtonProductoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProductoExistenteActionPerformed
        jTextFieldIE.setEnabled(true);
        jTextFieldPrecio.setEnabled(false);
        jTextFieldDescripcion.setEnabled(false);
        jTextFieldNombre.setEnabled(false);
        jTextFieldCantidad.setEnabled(true);
        jTextFieldIdGenerado.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonProductoExistenteActionPerformed

    private void jRadioButtonProductoExistenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonProductoExistenteMouseClicked

    }//GEN-LAST:event_jRadioButtonProductoExistenteMouseClicked

    private void jTextFieldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreFocusGained

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldIdGeneradoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdGeneradoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdGeneradoFocusGained

    private void jTextFieldIdGeneradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdGeneradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdGeneradoActionPerformed

    private void jTextFieldIdProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdProveedorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdProveedorFocusGained

    private void jTextFieldIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdProveedorActionPerformed

    private void btt_inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicio1ActionPerformed
        menuPrincipal ventana = new menuPrincipal(us);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_inicio1ActionPerformed

    private void jLabelVerificarInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVerificarInsumoMouseClicked
        // TODO add your handling code here:
        Insumo insumoBusqueda = InsumoSQL.getInsumo(Integer.parseInt(jTextFieldIE.getText()));
        if (insumoBusqueda != null){
            jTextFieldNombreInsumo.setText(insumoBusqueda.getNombre());
        }else{
            JOptionPane.showMessageDialog(this, "Este id de insumo no existe!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabelVerificarInsumoMouseClicked

    private void jLabelVerificarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVerificarProveedorMouseClicked
        Proveedores proveedorBusqueda = ProveedoresSQL.getProveedor(Integer.parseInt(jTextFieldIdProveedor.getText()));
        if (proveedorBusqueda != null){
            jTextFieldNombreProveedor.setText(proveedorBusqueda.getNombre());
        }else{
            JOptionPane.showMessageDialog(this, "Este id de proveedor no existe!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabelVerificarProveedorMouseClicked

    private void jTextFieldNombreInsumoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreInsumoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreInsumoFocusGained

    private void jTextFieldNombreInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreInsumoActionPerformed

    private void jTextFieldNombreProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreProveedorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreProveedorFocusGained

    private void jTextFieldNombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComprasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprasFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btt_inicio;
    private javax.swing.JButton btt_inicio1;
    private javax.swing.JButton btt_inicio2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelIdCompra;
    private javax.swing.JLabel jLabelProveedor;
    private javax.swing.JLabel jLabelProveedor1;
    private javax.swing.JLabel jLabelProveedor2;
    private javax.swing.JLabel jLabelProveedor3;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelVerificarInsumo;
    private javax.swing.JLabel jLabelVerificarProveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonNuevoProducto;
    private javax.swing.JRadioButton jRadioButtonProductoExistente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldIE;
    private javax.swing.JTextField jTextFieldIdGenerado;
    private javax.swing.JTextField jTextFieldIdProveedor;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreInsumo;
    private javax.swing.JTextField jTextFieldNombreProveedor;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
