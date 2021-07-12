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
public class UsuarioSistemaSQL {
    
    public static UsuarioSistema getUsuario(String idGenerado) {
        UsuarioSistema us = null;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM usuariosistema WHERE idGenerado = " + "'" + idGenerado + "'";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                us = new UsuarioSistema();
                us.setIdUsuarioSistema(Integer.parseInt(rs.getString("idUsuarioSistema")));
                us.setIdGenerado(rs.getString("idGenerado"));
                us.setNombre(rs.getString("nombre"));
                us.setTelefono(rs.getString("telefono"));
                us.setCorreo(rs.getString("correo"));
                us.setIsAdmin(Integer.parseInt(rs.getString("isAdmin")));
                us.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER USUARIO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return us;
    }
    
}
