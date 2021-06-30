/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Serratia Marcesens
 */
public class ProductoSQL {

    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            String sql = "select * from producto";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int idProducto = Integer.parseInt(rs.getString("idProducto"));
                String idGenerado = rs.getString("idGenerado");
                String nombres = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int existencias = Integer.parseInt(rs.getString("existencias"));
                float precioVenta = Float.parseFloat(rs.getString("precioVenta"));
                productos.add(new Producto(idProducto, idGenerado, nombres, descripcion, existencias, precioVenta));
            }
        } catch (SQLException e) {
            System.out.println("NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA");
        }
        return productos;
    }

    public int actualizarExistencias(Producto p) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String sql = "UPDATE producto SET existencias=?, where idProducto=" + p.getIdProducto();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, p.getExistencias());
            n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("EXISTENCIAS ACTUALIZADAS CORRECTAMENTE");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println("LOS DATOS DE AGREGAR EXISTENCIAS NO HAN SIDO GUARDADOS CORRECTAMENTE");
        }
        return n;
    }
    
    public Producto getProducto(int id) {
        ArrayList<Producto> inventario = getProductos();
        for(Producto producto: inventario) {
            if (id == producto.getIdProducto()) {
                return producto;
            }
        }
        return null;
    }
}
