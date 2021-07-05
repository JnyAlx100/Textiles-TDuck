/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Serratia Marcesens
 */
public class VentaSQL {
    public static void insertarVenta(Venta venta) {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO venta (Cliente_idCliente, fecha, totalSinIVA, total, UsuarioSistema_idUsuarioSistema) VALUES"
                    + "(" + "'" + venta.getClienteIdCliente() + "'" + "," + "'" + venta.getFecha() + "'" + "," + "'" 
                    + venta.getTotalSinIva() + "'" + "," + "'" + venta.getTotal() + "'" + "," + venta.getUsuarioSistema() + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje de que se llenó correctamente y resetear valores
                JOptionPane.showMessageDialog(null, "Venta ingresada con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear venta, verificar datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
    }
    
    public static int getIdNuevaVenta() {
        int id = 1;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM venta ORDER BY idVenta DESC LIMIT 1";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("idVenta")) + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL ID DE NUEVA VENTA", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
}
