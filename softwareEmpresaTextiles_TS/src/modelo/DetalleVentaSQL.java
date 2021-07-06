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

    public static void insertarDetalleVenta(DetalleVenta dv) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            String query
                    = " INSERT INTO detalleventa (Venta_idVenta, Producto_idProducto, cantidad) VALUES"
                    + "(" + "'" + dv.getVentaIdVenta() + "'" + "," + "'" + dv.getProductoidProducto() + "'" + "," + "'" + dv.getCantidad() + "'" + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (n > 0) {
                System.out.println("DATOS GUARDADOS CORRECTAMENTE EN DETALLEVENTA");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println("LOS DATOS DE DETALLEVENTA NO HAN SIDO GUARDADOS CORRECTAMENTE");
        }
    }
}
