/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
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
}