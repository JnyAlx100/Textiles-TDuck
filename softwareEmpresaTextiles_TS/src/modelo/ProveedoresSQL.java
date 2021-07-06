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
 * @author Yow
 */
public class ProveedoresSQL {

    public void new_user(String nit, String nombre, String direccion, String correo, int telefono) throws SQLException {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO Proveedor (nit, nombre, direccion, correo, telefono) VALUES"
                    + "(" + "'" + nit + "'" + "," + "'" + nombre + "'" + "," + "'" + direccion + "'" + "," + "'" + correo + "'" + "," + telefono + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje emergente donde indica que los campos se llenaron correctamente
                JOptionPane.showMessageDialog(null, "Proveedor Ingresado exitosamente", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de registro, rectifique los datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
    }
    
    public static Proveedores getProveedor(int id) {
        Proveedores p = null;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM proveedor WHERE idProveedor = " + id;
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p = new Proveedores();
                p.setIdProveedor(id);
                p.setNit(rs.getString("nit"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setCorreo(rs.getString("correo"));
                p.setTelefono(Integer.parseInt(rs.getString("telefono")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER PROVEEDOR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
}