package forms;

import clases.InsumoSQL;
import clases.ProductoSQL;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author jossu
 */
public class AgregarProductoInsumoNuevo extends javax.swing.JFrame {
    private ProductoSQL productoFuncionSQL = new ProductoSQL();
    private InsumoSQL insumoFuncionSQL = new InsumoSQL();
    private String id, nombre, descripcion;
    private int existencias;
    private int productoInsumo = 0;
    private float precioC, precioV;
    
    public AgregarProductoInsumoNuevo() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Agregar nuevo producto");
        this.setResizable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        id_field = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        desc_field = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        pc_field = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        nombre_field = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        existencias_field = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        pv_field = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btt_inicio = new javax.swing.JButton();
        btt_inicio1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        productoCheck = new javax.swing.JCheckBox();
        insumoCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID Producto:");

        id_field.setBackground(new java.awt.Color(255, 255, 255));
        id_field.setForeground(new java.awt.Color(204, 204, 204));
        id_field.setText("Ingrese ID del producto");
        id_field.setBorder(null);
        id_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                id_fieldFocusGained(evt);
            }
        });
        id_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_fieldActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(41, 168, 73));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Descripción:");

        desc_field.setBackground(new java.awt.Color(255, 255, 255));
        desc_field.setForeground(new java.awt.Color(204, 204, 204));
        desc_field.setText("Ingrese descripcion del producto");
        desc_field.setBorder(null);
        desc_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                desc_fieldFocusGained(evt);
            }
        });
        desc_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_fieldActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(41, 168, 73));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio compra:");

        pc_field.setBackground(new java.awt.Color(255, 255, 255));
        pc_field.setForeground(new java.awt.Color(204, 204, 204));
        pc_field.setText("Ingrese precio de compra ");
        pc_field.setBorder(null);
        pc_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pc_fieldFocusGained(evt);
            }
        });
        pc_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pc_fieldActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(41, 168, 73));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nombre");

        nombre_field.setBackground(new java.awt.Color(255, 255, 255));
        nombre_field.setForeground(new java.awt.Color(204, 204, 204));
        nombre_field.setText("Ingrese nombre del producto");
        nombre_field.setBorder(null);
        nombre_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombre_fieldFocusGained(evt);
            }
        });
        nombre_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_fieldActionPerformed(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(41, 168, 73));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Existencias:");

        existencias_field.setBackground(new java.awt.Color(255, 255, 255));
        existencias_field.setForeground(new java.awt.Color(204, 204, 204));
        existencias_field.setText("Ingrese existencias actuales");
        existencias_field.setBorder(null);
        existencias_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                existencias_fieldFocusGained(evt);
            }
        });
        existencias_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existencias_fieldActionPerformed(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(41, 168, 73));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Precio venta:");

        pv_field.setBackground(new java.awt.Color(255, 255, 255));
        pv_field.setForeground(new java.awt.Color(204, 204, 204));
        pv_field.setText("Ingrese precio de venta");
        pv_field.setBorder(null);
        pv_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pv_fieldFocusGained(evt);
            }
        });
        pv_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pv_fieldActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(41, 168, 73));

        btt_inicio.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio.setText("Agregar producto/Insumo");
        btt_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicioActionPerformed(evt);
            }
        });

        btt_inicio1.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio1.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio1.setText("Cancelar");
        btt_inicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicio1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Agregar nuevo producto/Insumo");

        jSeparator1.setForeground(new java.awt.Color(41, 168, 73));

        productoCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productoCheck.setText("Producto");
        productoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoCheckActionPerformed(evt);
            }
        });

        insumoCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        insumoCheck.setText("Insumo");
        insumoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insumoCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(desc_field, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pc_field, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btt_inicio)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator2)
                                    .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(productoCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pv_field, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(existencias_field, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(insumoCheck)
                            .addComponent(btt_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(175, 175, 175))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productoCheck)
                    .addComponent(insumoCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(existencias_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(pv_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(desc_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(pc_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btt_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_id_fieldFocusGained
        id_field.setText("");
        id_field.setForeground(Color.BLACK);
    }//GEN-LAST:event_id_fieldFocusGained

    private void id_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_fieldActionPerformed

    private void desc_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc_fieldFocusGained
        // TODO add your handling code here:
        desc_field.setText("");
        desc_field.setForeground(Color.BLACK);
    }//GEN-LAST:event_desc_fieldFocusGained

    private void desc_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desc_fieldActionPerformed

    private void pc_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pc_fieldFocusGained
        // TODO add your handling code here:
        pc_field.setText("");
        pc_field.setForeground(Color.BLACK);
    }//GEN-LAST:event_pc_fieldFocusGained

    private void pc_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pc_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pc_fieldActionPerformed

    private void nombre_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombre_fieldFocusGained
        // TODO add your handling code here:
        nombre_field.setText("");
        nombre_field.setForeground(Color.BLACK);
    }//GEN-LAST:event_nombre_fieldFocusGained

    private void nombre_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_fieldActionPerformed

    private void existencias_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_existencias_fieldFocusGained
        // TODO add your handling code here:
        existencias_field.setText("");
        existencias_field.setForeground(Color.BLACK);
    }//GEN-LAST:event_existencias_fieldFocusGained

    private void existencias_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existencias_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_existencias_fieldActionPerformed

    private void pv_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pv_fieldFocusGained
        // TODO add your handling code here:
        pv_field.setText("");
        pv_field.setForeground(Color.BLACK);
    }//GEN-LAST:event_pv_fieldFocusGained

    private void pv_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pv_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pv_fieldActionPerformed

    private void btt_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicioActionPerformed
        if(productoInsumo == 1){
            id = id_field.getText();
            nombre = nombre_field.getText();
            descripcion = desc_field.getText();
            existencias = Integer.valueOf(existencias_field.getText());
            precioV = Float.valueOf(pv_field.getText());
            if (productoFuncionSQL.verificar_producto(id, nombre, descripcion, existencias_field.getText(), pv_field.getText()) == true) {
                try {
                    if (productoFuncionSQL.nuevo_producto(id, nombre, descripcion, existencias, precioV) == true) {
                        vaciarFields();
                        pc_field.setEnabled(true);
                        productoCheck.setSelected(false);
                        insumoCheck.setEnabled(true);
                    } else {
                        vaciarFields();
                        pc_field.setEnabled(true);
                        productoCheck.setSelected(false);
                        insumoCheck.setEnabled(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarProductoInsumoNuevo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Comprobar ingreso de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(productoInsumo == 2){
            id = id_field.getText();
            nombre = nombre_field.getText();
            descripcion = desc_field.getText();
            existencias = Integer.valueOf(existencias_field.getText());
            precioC = Float.valueOf(pc_field.getText());
            if (insumoFuncionSQL.verificar_insumo(id, nombre, descripcion, existencias_field.getText(), pc_field.getText()) == true) {
                try {
                    if (insumoFuncionSQL.nuevo_insumo(id, nombre, descripcion, existencias, precioC) == true) {
                        vaciarFields();
                        pv_field.setEnabled(true);
                        insumoCheck.setSelected(false);
                        productoCheck.setEnabled(true);
                    } else {
                        vaciarFields();
                        pv_field.setEnabled(true);
                        insumoCheck.setSelected(false);
                        productoCheck.setEnabled(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarProductoInsumoNuevo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Comprobar ingreso de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        }else{
            System.out.println("No se selecciono nada" + productoInsumo);
        }
    }//GEN-LAST:event_btt_inicioActionPerformed

    private void btt_inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicio1ActionPerformed
        vaciarFields();
        MenuInventario ventana = new MenuInventario();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_inicio1ActionPerformed

    private void productoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoCheckActionPerformed
        // TODO add your handling code here:
        if (productoCheck.isSelected()) {
            productoInsumo = 1;
            insumoCheck.setEnabled(false);
            pc_field.setEnabled(false);
        }else if(!productoCheck.isSelected()){
            productoInsumo = 0;
            insumoCheck.setEnabled(true);
            pc_field.setEnabled(true);
        }
    }//GEN-LAST:event_productoCheckActionPerformed

    private void insumoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insumoCheckActionPerformed
        // TODO add your handling code here:
        if(insumoCheck.isSelected()){
            productoInsumo = 2;
            productoCheck.setEnabled(false);
            pv_field.setEnabled(false);
        }else if(!insumoCheck.isSelected()){
            productoInsumo = 0;
            productoCheck.setEnabled(true);
            pv_field.setEnabled(true);
        }
    }//GEN-LAST:event_insumoCheckActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProductoInsumoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoInsumoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoInsumoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoInsumoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProductoInsumoNuevo().setVisible(true);
            }
        });
    }
    
    public void vaciarFields(){
        Color texto = new Color(204, 204, 204);
        pv_field.setForeground(texto);
        existencias_field.setForeground(texto);
        nombre_field.setForeground(texto);
        pc_field.setForeground(texto);
        desc_field.setForeground(texto);
        id_field.setForeground(texto);
        
        id_field.setText("Ingrese ID del producto");
        desc_field.setText("Ingrese nombre del producto");
        pc_field.setText("Ingrese descripcion del producto");
        nombre_field.setText("Ingrese existencias del producto");
        existencias_field.setText("Ingrese precio adquisicion");
        pv_field.setText("Ingrese precio de venta");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btt_inicio;
    private javax.swing.JButton btt_inicio1;
    private javax.swing.JTextField desc_field;
    private javax.swing.JTextField existencias_field;
    private javax.swing.JTextField id_field;
    private javax.swing.JCheckBox insumoCheck;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField nombre_field;
    private javax.swing.JTextField pc_field;
    private javax.swing.JCheckBox productoCheck;
    private javax.swing.JTextField pv_field;
    // End of variables declaration//GEN-END:variables
}
