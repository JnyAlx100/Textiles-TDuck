package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jossu
 */
public class ProductoSQL{

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
