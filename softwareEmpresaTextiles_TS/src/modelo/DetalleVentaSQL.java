/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Serratia Marcesens
 */
public class DetalleVentaSQL {

    public int insertarDetalleVenta(DetalleVenta dv) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String sql = "insert into detalleventa (Venta_idVenta,Producto_idProducto,cantidad) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, dv.getVentaIdVenta());
            pst.setInt(2, dv.getProductoidProducto());
            pst.setInt(3, dv.getCantidad());
            n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("DATOS GUARDADOS CORRECTAMENTE EN COMPRA_INVENTARIO");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println("LOS DATOS DE COMPRA INVENTARIO NO HAN SIDO GUARDADOS CORRECTAMENTE");
        }
        return n;
    }
}
