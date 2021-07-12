/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Yow
 */
public class VentasFormulario extends javax.swing.JFrame {

    ControladorVentas cv;
    DefaultTableModel jTableModel;
    public UsuarioSistema us;
    
    public VentasFormulario() {
        initComponents();
        cv = new ControladorVentas(0, 0, 1);
        jTableModel = (DefaultTableModel) jTable4.getModel();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/programa.png")).getImage());
        limpiar();
        this.setLocationRelativeTo(null);
//        new VentaSQL().insertarVenta(new Venta(1, 1, java.sql.Date.valueOf(LocalDate.now()), 0, 0, 0, 1));
        
    }
    
    public VentasFormulario(UsuarioSistema us) {
        initComponents();
        cv = new ControladorVentas(0, 0, 1);
        jTableModel = (DefaultTableModel) jTable4.getModel();
        this.setLocationRelativeTo(null);
        this.us = us;
        this.setIconImage(new ImageIcon(getClass().getResource("/img/programa.png")).getImage());
        limpiar();
//        new VentaSQL().insertarVenta(new Venta(1, 1, java.sql.Date.valueOf(LocalDate.now()), 0, 0, 0, 1));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btt_inicio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldClienteNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldProducto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btt_inicio2 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelIdVenta = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldProductoNombre = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldProductoPrecio = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        btt_inicio1 = new javax.swing.JButton();
        jLabelCajero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setAutoCreateRowSorter(true);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Descripcion ", "Cantidad", "Precio Venta", "SubTotal"
            }
        ));
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setIntercellSpacing(new java.awt.Dimension(0, 5));
        jTable4.setRowHeight(25);
        jTable4.setSelectionBackground(new java.awt.Color(60, 187, 9));
        jScrollPane1.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(2).setMinWidth(300);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 1090, 230));

        btt_inicio.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio.setText("Agregar a la canasta");
        btt_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicioActionPerformed(evt);
            }
        });
        jPanel1.add(btt_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 159, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nombre cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jTextFieldClienteNombre.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldClienteNombre.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldClienteNombre.setBorder(null);
        jTextFieldClienteNombre.setFocusable(false);
        jTextFieldClienteNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldClienteNombreFocusGained(evt);
            }
        });
        jTextFieldClienteNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClienteNombreActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 150, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ventas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 19, 169, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ID Producto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jTextFieldProducto.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldProducto.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldProducto.setBorder(null);
        jTextFieldProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProductoFocusGained(evt);
            }
        });
        jTextFieldProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 186, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cantidad");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

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
        jPanel1.add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 186, 30));

        jSeparator2.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator2.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 170, 9));

        jSeparator3.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator3.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 203, 14));

        jSeparator4.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator4.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 203, 13));

        btt_inicio2.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio2.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio2.setText("Realizar Venta");
        btt_inicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicio2ActionPerformed(evt);
            }
        });
        jPanel1.add(btt_inicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 159, 40));

        jSeparator5.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator5.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 79, 203, 13));

        jLabelIdVenta.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelIdVenta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdVenta.setText("ID Venta:");
        jPanel1.add(jLabelIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, -1, -1));

        jLabelFecha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setText("Fecha:");
        jPanel1.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 620, -1, -1));

        jLabelTotal.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("Total:");
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, -1, -1));

        jLabel1.setBackground(new java.awt.Color(79, 82, 84));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lens.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jLabel2.setBackground(new java.awt.Color(79, 82, 84));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lens.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("NIT Cliente");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 131, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator6.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 203, 9));

        jTextFieldCliente.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldCliente.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldCliente.setBorder(null);
        jTextFieldCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldClienteFocusGained(evt);
            }
        });
        jTextFieldCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 186, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nombre producto");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jTextFieldProductoNombre.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldProductoNombre.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldProductoNombre.setBorder(null);
        jTextFieldProductoNombre.setFocusable(false);
        jTextFieldProductoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProductoNombreFocusGained(evt);
            }
        });
        jTextFieldProductoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductoNombreActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldProductoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 150, 30));

        jSeparator7.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator7.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 170, 9));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Precio producto");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, -1, -1));

        jTextFieldProductoPrecio.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldProductoPrecio.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldProductoPrecio.setBorder(null);
        jTextFieldProductoPrecio.setFocusable(false);
        jTextFieldProductoPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProductoPrecioFocusGained(evt);
            }
        });
        jTextFieldProductoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductoPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldProductoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, 160, 30));

        jSeparator8.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator8.setForeground(new java.awt.Color(41, 168, 73));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 180, 9));

        btt_inicio1.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio1.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio1.setText("Regresar");
        btt_inicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicio1ActionPerformed(evt);
            }
        });
        jPanel1.add(btt_inicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 620, -1, -1));

        jLabelCajero.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabelCajero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCajero.setText("Cajero:");
        jPanel1.add(jLabelCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jTextFieldCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCantidadFocusGained
        // TODO add your handling code here:
        jTextFieldCantidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldCantidadFocusGained

    private void jTextFieldProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoActionPerformed

    private void jTextFieldProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductoFocusGained
        // TODO add your handling code here:
        jTextFieldProducto.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldProductoFocusGained

    private void jTextFieldClienteNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClienteNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClienteNombreActionPerformed

    private void jTextFieldClienteNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldClienteNombreFocusGained
        // TODO add your handling code here:
        jTextFieldClienteNombre.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldClienteNombreFocusGained

    private void btt_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicioActionPerformed
        //se verifica que haya texto en los jTextField
        if (jTextFieldCantidad.getText().isEmpty() || jTextFieldProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar los campos de 'Producto' y 'Cantidad'", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        cv.agregarEnCanasta(Integer.parseInt(jTextFieldProducto.getText()), Integer.parseInt(jTextFieldCantidad.getText()));
        limpiar();
    }//GEN-LAST:event_btt_inicioActionPerformed

    private void btt_inicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicio2ActionPerformed
        //se verifica que se haya ingresado un cliente
        int id;
        if (jTextFieldCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un cliente", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //se verifica que el cliente exista
        if (ClienteSQL.getCliente(jTextFieldCliente.getText()) == null) {
            JOptionPane.showMessageDialog(this, "Este id de cliente no existe!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else{
            id = ClienteSQL.getCliente(jTextFieldCliente.getText()).getIdCliente();
        }
        
        cv.realizarVenta(id);
        limpiar();
        jTextFieldCliente.setText("");
        jTextFieldClienteNombre.setText("");
    }//GEN-LAST:event_btt_inicio2ActionPerformed

    private void jTextFieldClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldClienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClienteFocusGained

    private void jTextFieldClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClienteActionPerformed

    private void jTextFieldProductoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductoNombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoNombreFocusGained

    private void jTextFieldProductoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoNombreActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Cliente clienteBusqueda = ClienteSQL.getCliente(jTextFieldCliente.getText());
        if (clienteBusqueda != null){
            jTextFieldClienteNombre.setText(clienteBusqueda.getNombre());
        }else{
            JOptionPane.showMessageDialog(this, "Este id de cliente no existe!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Producto productoBusqueda = ProductoSQL.getProducto(Integer.parseInt(jTextFieldProducto.getText()));
        if (productoBusqueda != null){
            jTextFieldProductoNombre.setText(productoBusqueda.getNombre());
            jTextFieldProductoPrecio.setText(String.valueOf(productoBusqueda.getPrecioVenta()));
        }else{
            JOptionPane.showMessageDialog(this, "Este id de este producto no existe!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextFieldProductoPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductoPrecioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoPrecioFocusGained

    private void jTextFieldProductoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoPrecioActionPerformed

    private void btt_inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicio1ActionPerformed
        menuPrincipal ventana = new menuPrincipal(us);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_inicio1ActionPerformed
    
    public void limpiar() {
        jLabelCajero.setText("Cajero: " + us.getNombre());
        jTextFieldCantidad.setText("");
        jTextFieldProducto.setText("");
        jTextFieldProductoNombre.setText("");
        jTextFieldProductoPrecio.setText("");
        jLabelFecha.setText("Fecha: " + cv.getVenta().getFecha().toString());
        jLabelIdVenta.setText("No." + String.valueOf(cv.getVenta().getIdVenta()));
        jLabelTotal.setText("Total: Q" + String.valueOf(cv.getVenta().getTotal()));
        jTableModel = cv.getTableModel(jTableModel);
    }
    
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
            java.util.logging.Logger.getLogger(VentasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btt_inicio;
    private javax.swing.JButton btt_inicio1;
    private javax.swing.JButton btt_inicio2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCajero;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelIdVenta;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldClienteNombre;
    private javax.swing.JTextField jTextFieldProducto;
    private javax.swing.JTextField jTextFieldProductoNombre;
    private javax.swing.JTextField jTextFieldProductoPrecio;
    // End of variables declaration//GEN-END:variables
}
