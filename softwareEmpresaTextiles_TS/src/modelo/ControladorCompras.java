/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Serratia Marcesens
 */
public class ControladorCompras {

    private DateTimeFormatter dtf;
    private LocalDateTime now;

    Compra compra;
    private ArrayList<Insumo> canasta;

    public ControladorCompras(int idUsuario) {
        compra = new Compra(CompraSQL.getIdNuevaCompras(), 0, java.sql.Date.valueOf(LocalDate.now()), 0, idUsuario);
        canasta = new ArrayList<>();
    }

    public void agregarEnCanasta(Insumo insumo, boolean esNuevo) {
        compra.setTotal(compra.getTotal() + insumo.getExistencias() * insumo.getPrecioCompra());
        for (int x = 0; x < canasta.size(); x++) {
            Insumo elemento = canasta.get(x);
            if (elemento.getIdInsumo() == insumo.getIdInsumo()) {
                elemento.setExistencias(elemento.getExistencias() + insumo.getExistencias());
                return;
            }
        }
        if (!esNuevo) {
            insumo = InsumoSQL.getInsumo(insumo.getIdInsumo());
        }
        canasta.add(insumo);
    }

    public void realizarCompra(int idProveedor) {
        //se verifica que hayan productos en la canasta
        if (canasta.size() < 1) {
            JOptionPane.showMessageDialog(null, "Debe ingresar al menos un producto en el carrito!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //se actualiza la fecha
        compra.setFecha(java.sql.Date.valueOf(LocalDate.now()));

        //se verifica que el proveedor este registrado
        if (ProveedoresSQL.getProveedor(idProveedor) == null) {
            JOptionPane.showMessageDialog(null, "Este proveedor no se encuentra registrado!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //se actualiza el proveedor
        compra.setIdProveedor(idProveedor);
        
        //se inserta la compra
        CompraSQL.insertarCompra(compra);

        //se insertan todos los elemenots de la tabla "detallecompra"
        for (Insumo i : canasta) {
            //se actualizan las existencias de los productos en la base de datos y se agregan si son nuevos
            Insumo insumo = InsumoSQL.getInsumo(i.getIdInsumo());
            if (insumo == null) {
                InsumoSQL.insertarInsumo(i);
            } else {
                int existencias = insumo.getExistencias() + i.getExistencias();
                InsumoSQL.actualizarExistencias(i.getIdInsumo(), existencias);
            }
            //se insertan todos los elementos de la canasta a la tabla "detallecompra"
            DetalleCompraSQL.insertarDetalleCompra(new DetalleCompra(0, compra.getIdCompra(), InsumoSQL.getIdNuevoInsumo() - 1
                    , i.getExistencias()));
        }
        limpiar();
    }

    public DefaultTableModel getTableModel(DefaultTableModel jTableModel) {
        jTableModel.setRowCount(0);
        for (Insumo p : canasta) {
            jTableModel.addRow(new Object[]{p.getIdGenerado(), p.getNombre(), p.getDescripcion(), p.getExistencias(),
                "Q" + p.getPrecioCompra(), "Q" + p.getPrecioCompra() * p.getExistencias()});
        }
        return jTableModel;
    }

    public Compra getCompra() {
        return compra;
    }

    public void limpiar() {
        compra = new Compra(CompraSQL.getIdNuevaCompras(), compra.getIdProveedor(), java.sql.Date.valueOf(LocalDate.now()),
                0, compra.getUsuarioSistema());
        canasta = new ArrayList<>();
    }

}
