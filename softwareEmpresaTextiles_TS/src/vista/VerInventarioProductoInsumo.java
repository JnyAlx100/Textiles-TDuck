package vista;

import modelo.InformacionInsumo;
import modelo.InformacionProducto;
import modelo.InsumoSQL;
import modelo.ProductoSQL;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author jossu
 */
public class VerInventarioProductoInsumo extends javax.swing.JFrame {
    private DefaultTableModel dm;
    private ProductoSQL productoFuncionSQL = new ProductoSQL();
    private InsumoSQL insumoFuncionSQL = new InsumoSQL();
    
    public VerInventarioProductoInsumo() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Inventario Principal Productos");
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/programa.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscar_field = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btt_inicio1 = new javax.swing.JButton();
        productoCheck = new javax.swing.JCheckBox();
        insumoCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buscar_field.setBackground(new java.awt.Color(255, 255, 255));
        buscar_field.setForeground(new java.awt.Color(204, 204, 204));
        buscar_field.setText("Buscar producto por nombre");
        buscar_field.setBorder(null);
        buscar_field.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                buscar_fieldCaretUpdate(evt);
            }
        });
        buscar_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscar_fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscar_fieldFocusLost(evt);
            }
        });
        buscar_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar_fieldKeyReleased(evt);
            }
        });

        jSeparator9.setForeground(new java.awt.Color(41, 168, 73));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre ", "Descripcion", "Existencias", "Precio Compra", "Precio Venta"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inventario Principal");

        jSeparator1.setForeground(new java.awt.Color(41, 168, 73));

        btt_inicio1.setBackground(new java.awt.Color(41, 168, 73));
        btt_inicio1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btt_inicio1.setForeground(new java.awt.Color(255, 255, 255));
        btt_inicio1.setText("Regresar");
        btt_inicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_inicio1ActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                            .addComponent(jSeparator9)
                            .addComponent(jSeparator1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(btt_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(buscar_field, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(productoCheck)
                        .addGap(18, 18, 18)
                        .addComponent(insumoCheck)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar_field, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productoCheck)
                    .addComponent(insumoCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btt_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscar_fieldFocusGained
        // TODO add your handling code here:
        buscar_field.setText("");
        buscar_field.setForeground(Color.black);
    }//GEN-LAST:event_buscar_fieldFocusGained

    private void buscar_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscar_fieldFocusLost
        // TODO add your handling code here:
        Color texto = new Color(204, 204, 204);
        buscar_field.setText("Buscar producto por nombre");
        buscar_field.setForeground(texto);
    }//GEN-LAST:event_buscar_fieldFocusLost

    private void buscar_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar_fieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_fieldKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void btt_inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_inicio1ActionPerformed
        MenuInventario ventana = new MenuInventario();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_inicio1ActionPerformed

    private void productoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoCheckActionPerformed
        if(productoCheck.isSelected()){
            insumoCheck.setEnabled(false);
            ConsultaInventarioThread rellenarTabla = new ConsultaInventarioThread(1);
            rellenarTabla.start();
        }else if(!insumoCheck.isSelected()){
            insumoCheck.setEnabled(true);
            vaciarTabla();
        }
    }//GEN-LAST:event_productoCheckActionPerformed

    private void insumoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insumoCheckActionPerformed
        if(insumoCheck.isSelected()){
            productoCheck.setEnabled(false);
            ConsultaInventarioThread rellenarTabla = new ConsultaInventarioThread(2);
            rellenarTabla.start();
        }else if(!insumoCheck.isSelected()){
            productoCheck.setEnabled(true);
            vaciarTabla();
        }
    }//GEN-LAST:event_insumoCheckActionPerformed

    private void buscar_fieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_buscar_fieldCaretUpdate
        String nombreProducotIsumoBuscar = buscar_field.getText();
        if(nombreProducotIsumoBuscar.isEmpty()){
            jTable1.clearSelection();
        }else{
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (jTable1.getValueAt(i, 1).equals(nombreProducotIsumoBuscar)) {
                    jTable1.requestFocus();
                    jTable1.changeSelection(i, 1, false, false);
                }
            }
        }
    }//GEN-LAST:event_buscar_fieldCaretUpdate

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerInventarioProductoInsumo().setVisible(true);
            }
        });
    }
    
    private void filtro(String consulta, JTable jtableBuscar, int row){
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta,row));
    }
    
    private void agregarProductosATabla(){
        String dts[] = new String[5];
        ArrayList<InformacionProducto> datosObtenidos = new ArrayList<InformacionProducto>();
        datosObtenidos = productoFuncionSQL.verDatosProductosInventario();
        DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
        for (InformacionProducto datosObtenido : datosObtenidos) {
            dts[0] = datosObtenido.getIdProducto();
            dts[1] = datosObtenido.getNombreProducto();
            dts[2] = datosObtenido.getDescripcionProducto();
            dts[3] = datosObtenido.getExistenciasProducto();
            dts[4] = datosObtenido.getPrecioVentaProducto();
            miModelo.addRow(dts);
        }
        jTable1.setModel(miModelo);
    }
    
    private void agregarInsumosTabla(){
        String dts[] = new String[5];
        ArrayList<InformacionInsumo> datosObtenidos = new ArrayList<InformacionInsumo>();
        datosObtenidos = insumoFuncionSQL.verDatosInsumosInventario();
        DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
        for (InformacionInsumo datosObtenido : datosObtenidos) {
            dts[0] = datosObtenido.getIdInsumo();
            dts[1] = datosObtenido.getNombreInsumo();
            dts[2] = datosObtenido.getDescripcionInsumo();
            dts[3] = datosObtenido.getExistenciasInsumo();
            dts[4] = datosObtenido.getPrecioCompraInsumo();
            miModelo.addRow(dts);
        }
        jTable1.setModel(miModelo);
    }
    
    public void vaciarTablaInsumo(){
        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"ID Producto","Nombre","Descripcion","Existencias","Precio Compra"};
        Modelo = new DefaultTableModel(null,titulos);
        jTable1.setModel(Modelo);
    }
    
    
    public void vaciarTabla(){
        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"ID Producto","Nombre","Descripcion","Existencias","Precio Compras", "Precio Ventas"};
        Modelo = new DefaultTableModel(null,titulos);
        jTable1.setModel(Modelo);
    }
    
    public class ConsultaInventarioThread extends Thread {
        private int tipoDeTabla = 0;
        
        public ConsultaInventarioThread(int num) {
            this.tipoDeTabla = num;
        }
        
        @Override
        public void run() {
            if (tipoDeTabla == 1) {
                vaciarTabla();
                agregarProductosATabla();
            }else if(tipoDeTabla == 2){
                vaciarTablaInsumo();
                agregarInsumosTabla();
            }
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btt_inicio1;
    private javax.swing.JTextField buscar_field;
    private javax.swing.JCheckBox insumoCheck;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JCheckBox productoCheck;
    // End of variables declaration//GEN-END:variables
}
