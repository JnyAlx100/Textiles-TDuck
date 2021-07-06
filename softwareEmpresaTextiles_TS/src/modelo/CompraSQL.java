/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Serratia Marcesens
 */
public class CompraSQL {

    public static void insertarCompra(Compra compra) {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO compra (Proveedor_idProveedor, fecha, total, UsuarioSistema_idUsuarioSistema) VALUES"
                    + "(" + "'" + compra.getIdProveedor() + "'" + "," + "'" + compra.getFecha() + "'" + "," + "'"
                    + compra.getTotal() + "'" + "," + "'" + compra.getUsuarioSistema() + "'" + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje de que se llenó correctamente y resetear valores
                JOptionPane.showMessageDialog(null, "Compra ingresada con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear compra, verificar datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
    }

    public static int getIdNuevaCompras() {
        int id = 1;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM compra ORDER BY idCompra DESC LIMIT 1";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("idCompra")) + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL ID DE NUEVA COMPRA", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
}
