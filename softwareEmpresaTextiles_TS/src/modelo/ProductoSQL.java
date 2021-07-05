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

    public static void actualizarExistencias(int idProducto, int existencias) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            Statement st = con.createStatement();
            System.out.println("antes habian " + getProducto(idProducto).getExistencias() + " existencias y ahora habran "
            + existencias);
            String sql = "UPDATE producto SET existencias=? where idProducto=" + idProducto;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, existencias);
            n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("EXISTENCIAS ACTUALIZADAS CORRECTAMENTE");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println("LOS DATOS DE AGREGAR EXISTENCIAS NO HAN SIDO GUARDADOS CORRECTAMENTE");
        }
    }
    
    public static Producto getProducto(int id) {
        Producto p = null;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM producto WHERE idProducto = " + id;
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(id);
                p.setIdGenerado(rs.getString("idGenerado"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setExistencias(Integer.parseInt(rs.getString("existencias")));
                p.setPrecioVenta(Float.parseFloat(rs.getString("precioVenta")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER PRODUCTO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
    
    public boolean nuevo_producto(String idGenerado, String nombre, String descripcion, int existencias, float precioVenta) throws SQLException {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO producto (idGenerado, nombre, descripcion, existencias, precioVenta) VALUES"
                    + "(" + "'" + idGenerado + "'" + "," + "'" + nombre + "'" + "," + "'" + descripcion + "'" + "," + "'" + existencias + "'" + "," + precioVenta + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje de que se llenó correctamente y resetear valores
                JOptionPane.showMessageDialog(null, "Producto ingresado con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear producto, verificar datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean verificar_producto(String id, String nombreProducto, String descripcionP, String existenciasP,  String precioVentaP){
        if(id.equals("") && nombreProducto.equals("") && descripcionP.equals("") && existenciasP.equals("") &&  precioVentaP.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<InformacionProducto> verDatosProductosInventario() {
        ArrayList<InformacionProducto> datosObtenidos = new ArrayList<InformacionProducto>();
        try {
            Connection con = null;
            ConexionDB conect = ConexionDB.InstanciaSingleton();
            con = conect.conectarMySQL();
            String sql = "SELECT idGenerado, nombre, descripcion, existencias, precioVenta FROM producto";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InformacionProducto productoInformacion = new InformacionProducto(rs.getString("idGenerado"), rs.getString("nombre"),
                        rs.getString("descripcion"), rs.getString("existencias"), rs.getString("precioVenta"));
                datosObtenidos.add(productoInformacion);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return datosObtenidos;
    }

    public void editarProductoExistente(String id, String nombreProducto, String descripcionP, int existenciasP, float precioVentaP){
        try{
            Connection con = null;
            ConexionDB conect = ConexionDB.InstanciaSingleton();
            con = conect.conectarMySQL();
            Statement st = con.createStatement();
            String sql = "update producto set nombre = ?, descripcion = ?, existencias = ?, precioVenta = ? where idGenerado = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombreProducto);
            pst.setString(2, descripcionP);
            pst.setInt(3, existenciasP);
            pst.setDouble(4, precioVentaP);
            pst.setString(5, id);
            int n = pst.executeUpdate();
            if (n > 0){
                JOptionPane.showMessageDialog(null, "Producto editado con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error al modificar el producto,", "Error",
                JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
            
        }
    }
}
