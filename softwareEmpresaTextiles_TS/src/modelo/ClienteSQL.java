/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas
 */
public class ClienteSQL {

    public void new_user(String nit, String nombre, String direccion, String correo, int telefono) throws SQLException {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO cliente (nit, nombre, direccion, correo, telefono) VALUES"
                    + "(" + "'" + nit + "'" + "," + "'" + nombre + "'" + "," + "'" + direccion + "'" + "," + "'" + correo + "'" + "," + telefono + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje de que se llenó correctamente y resetear valores
                JOptionPane.showMessageDialog(null, "Cliente ingresado con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear cliente, verificar datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
    }
    
    public static Cliente getCliente(String nit) {
        Cliente c = null;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            System.out.println("El nit entregado fue: " + nit);
            System.out.println("SELECT * FROM cliente WHERE nit = '" + nit + "';");
            String sql = "SELECT * FROM cliente WHERE nit = '" + nit + "';";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                c = new Cliente();
                c.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
                c.setNit(rs.getString("nit"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(Integer.parseInt(rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER CLIENTE, REVISE EL NIT INGRESADO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
