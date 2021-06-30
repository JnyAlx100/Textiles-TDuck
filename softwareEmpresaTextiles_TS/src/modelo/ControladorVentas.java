/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.log.Log;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Serratia Marcesens
 */
public class ControladorVentas {

    public ArrayList<DetalleVenta> listaVentas;
    public DateTimeFormatter dtf;
    public LocalDateTime now;
    public int total;

    public ControladorVentas() {
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        now = LocalDateTime.now();
        total = 0;
        listaVentas = new ArrayList<>();
    }

    public DefaultTableModel agregarProducto(int idPaciente, int idProducto, int cantidad, DefaultTableModel jTableModel) {

        int cantidadPrevia = 0;
        boolean yaEstaIngresado = false;
        DetalleVenta aux = null;

        for (DetalleVenta dv : listaVentas) {
            if (dv.getProductoidProducto() == idProducto) {
                cantidadPrevia = dv.getCantidad();
                yaEstaIngresado = true;
                aux = dv;
            }
        }

        Producto producto = new ProductoSQL().getProducto(idProducto);

        if ((cantidad + cantidadPrevia) > producto.getExistencias()) {
            JOptionPane.showMessageDialog(null, "No hay suficientes existencias para este producto!");
            return null;
        }

        if (yaEstaIngresado) {
            aux.setCantidad(cantidad + cantidadPrevia);
        } else {
            aux = new DetalleVenta(VentaSQL.getIdVenta(), idProducto, cantidad + cantidadPrevia);
            listaVentas.add(aux);
        }
        return actualizarTabla(jTableModel);
    }

    public void reset() {
        total = 0;
        listaVentas = new ArrayList<>();
    }

    public String fecha() {
        return dtf.format(now);
    }

    public DefaultTableModel actualizarTabla(DefaultTableModel jTableModel) {
        jTableModel.setRowCount(0);
        for (DetalleVenta vi : listaVentas) {
            Producto producto = new ProductoSQL().getProducto(vi.getProductoidProducto());
            jTableModel.addRow(new Object[]{producto.getIdProducto(), producto.getNombre(), producto.getDescripcion(), producto.getExistencias(), producto.getPrecioVenta()});
        }
        return jTableModel;
    }

    public void realizarVenta(Venta venta) {
        String accion = "Ventas";
        String estado = "";
        String trx_id = "";
        int n1, n2, n3;
        ConexionDB con1 = ConexionDB.InstanciaSingleton();
        Connection con = con1.conectarMySQL();
        n1 = actualizarInventario();
        n2 = insertarVenta(venta);
        n3 = insertarDetalleVenta();
        int opc = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA COMPLETAR LA TRANSACCIÓN?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            if (n1 > 0 && n2 > 0 && n3 > 0) {
                try {
                    con.commit();
                    estado = "Comprometida";
                    JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                } catch (SQLException ex) {
                }
            } else {
                try {
                    con.rollback();
                    estado = "Fallida";
                } catch (SQLException ex) {
                }
            }
        } else {
            try {
                con.rollback();
                estado = "Anulada";
            } catch (SQLException ex) {
            }
            JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA TRANSACCIÓN");
        }
    }

    public int insertarDetalleVenta() {
        int n = 0;
        for (DetalleVenta vi : listaVentas) {
            n = new DetalleVentaSQL().insertarDetalleVenta(vi);
        }
        return n;
    }

    public int insertarVenta(Venta venta) {
        return new VentaSQL().insertarVenta(venta);
    }

    public int actualizarInventario() {
        Producto producto;
        int stockActual = 0;
        int n = 0;
        for (DetalleVenta vi : listaVentas) {
            producto = new ProductoSQL().getProducto(vi.getProductoidProducto());
            stockActual = producto.getExistencias() - vi.getCantidad();
            producto.setExistencias(stockActual);
            n = new ProductoSQL().actualizarExistencias(producto);
        }
        return n;
    }
}
