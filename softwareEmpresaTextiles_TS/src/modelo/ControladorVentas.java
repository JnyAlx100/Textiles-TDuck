/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.log.Log;
import controlador.ConstructorFacturaDigital;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    private DateTimeFormatter dtf;
    private LocalDateTime now;

    private Venta venta;
    private ArrayList<Producto> canasta;
    private ConstructorFacturaDigital factura = new ConstructorFacturaDigital();

    public ControladorVentas(int idCliente, float total, int idUsuario) {
        venta = new Venta(VentaSQL.getIdNuevaVenta(), idCliente, java.sql.Date.valueOf(LocalDate.now()), 0, 0, 0, idUsuario);
        canasta = new ArrayList<>();
    }

    public void agregarEnCanasta(int idProducto, int cantidad) {
        Producto p = ProductoSQL.getProducto(idProducto);

        //se verifica que el producto existe
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Este producto no existe en el inventario!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //se verifica que se disponga de las existencias necesarias
        if (cantidad > p.getExistencias()) {
            JOptionPane.showMessageDialog(null, "No se cuenta con la cantidad suficiente de producto!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        venta.setTotal(venta.getTotal() + p.getPrecioVenta() * cantidad);
        venta.setTotalSinIva(venta.getTotal() * 0.88f);

        for (int x = 0; x < canasta.size(); x++) {
            Producto elemento = canasta.get(x);
            if (elemento.getIdProducto() == idProducto) {
                //se verifica que se disponga de las existencias necesarias tomando en cuenta lo que ya se encontraba en el carrito
                if (cantidad + elemento.getExistencias() > p.getExistencias()) {
                    JOptionPane.showMessageDialog(null, "No se cuenta con la cantidad suficiente de producto!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                elemento.setExistencias(elemento.getExistencias() + cantidad);
                return;
            }
        }
        p.setExistencias(cantidad);
        canasta.add(p);
    }

    public void realizarVenta(int idCliente) {
        //se verifica que hayan productos en la canasta
        if (canasta.size() < 1) {
            JOptionPane.showMessageDialog(null, "Debe ingresar al menos un producto en el carrito!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //se ingresa la fecha del momento
        venta.setFecha(java.sql.Date.valueOf(LocalDate.now()));
        //se ingresa el id del cliente
        venta.setClienteIdCliente(idCliente);

        //se inserta la venta
        VentaSQL.insertarVenta(venta);

        for (Producto p : canasta) {
            //se insertan todos los elementos de la canasta a la tabla "detallecompra"
            DetalleVentaSQL.insertarDetalleVenta(new DetalleVenta(0, venta.getIdVenta(), p.getIdProducto(), p.getExistencias()));

            //se actualizan las existencias de los productos en la base de datos
            int existencias = ProductoSQL.getProducto(p.getIdProducto()).getExistencias() - p.getExistencias();
            ProductoSQL.actualizarExistencias(p.getIdProducto(), existencias);
        }
        
        factura.agregarProductos(canasta);
        factura.setVenta(venta);
        factura.generarFactura();
        
        limpiar();
    }

    public DefaultTableModel getTableModel(DefaultTableModel jTableModel) {
        jTableModel.setRowCount(0);
        for (Producto p : canasta) {
            jTableModel.addRow(new Object[]{p.getIdProducto(), p.getNombre(), p.getDescripcion(), p.getExistencias(), "Q" + p.getPrecioVenta()
                    , "Q" + p.getPrecioVenta() * p.getExistencias()});
        }
        return jTableModel;
    }

    public void limpiar() {
        venta = new Venta(VentaSQL.getIdNuevaVenta(), venta.getClienteIdCliente(), java.sql.Date.valueOf(LocalDate.now()),
                0, 0, 0, venta.getUsuarioSistema());
        canasta = new ArrayList<>();
    }

    public Venta getVenta() {
        return venta;
    }

    public ArrayList<Producto> getCanasta() {
        return canasta;
    }

}
