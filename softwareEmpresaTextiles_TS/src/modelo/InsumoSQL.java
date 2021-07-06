package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static modelo.ProductoSQL.getProducto;
/**
 *
 * @author jossu
 */
public class InsumoSQL {
    
    public static void insertarInsumo(Insumo insumo) {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO insumo (idGenerado, nombre, descripcion, existencias, precioCompra) VALUES"
                    + "(" + "'" + insumo.getIdGenerado() + "'" + "," + "'" + insumo.getNombre() + "'" + "," + "'" 
                    + insumo.getDescripcion() + "'" + "," + "'" + insumo.getExistencias() + "'" + "," + "'" +
                    + insumo.getPrecioCompra() + "'" + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje de que se llenó correctamente y resetear valores
                JOptionPane.showMessageDialog(null, "Insumo registrado con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear insumo, verificar datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
    }
    
    public static Insumo getInsumo(int id) {
        Insumo p = null;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM insumo WHERE idInsumo = " + id;
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p = new Insumo();
                p.setIdInsumo(id);
                p.setIdGenerado(rs.getString("idGenerado"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setExistencias(Integer.parseInt(rs.getString("existencias")));
                p.setPrecioCompra(Float.parseFloat(rs.getString("precioCompra")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER INSUMO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
    
    public static void actualizarExistencias(int idInsumo, int existencias) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            Statement st = con.createStatement();
            String sql = "UPDATE insumo SET existencias=? where idInsumo=" + idInsumo;
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
    
    public static int getIdNuevoInsumo() {
        int id = 1;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "SELECT * FROM insumo ORDER BY idInsumo DESC LIMIT 1";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("idInsumo")) + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL ID DE NUEVO INSUMO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    
    public boolean nuevo_insumo(String idGenerado, String nombre, String descripcion, int existencias, float precioCompra) throws SQLException {
        try {
            ConexionDB sql = ConexionDB.InstanciaSingleton();
            Connection con = sql.conectarMySQL();
            String query
                    = " INSERT INTO insumo (idGenerado, nombre, descripcion, existencias, precioCompra) VALUES"
                    + "(" + "'" + idGenerado + "'" + "," + "'" + nombre + "'" + "," + "'" + descripcion + "'" + "," + "'" + existencias + "'" + "," + precioCompra + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (rs == 1) {
                //Mensaje de que se llenó correctamente y resetear valores
                JOptionPane.showMessageDialog(null, "Insumo ingresado con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear insumo, verificar datos", "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
        return false;
    }
    
    public void editarInsumoExistente(String id, String nombreInsumo, String descripcionInsumo, int existenciaInsumo, float precioCompra){
        try{
            Connection con = null;
            ConexionDB conect = ConexionDB.InstanciaSingleton();
            con = conect.conectarMySQL();
            Statement st = con.createStatement();
            String sql = "update insumo set nombre = ?, descripcion = ?, existencias = ?, precioCompra = ? where idGenerado = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombreInsumo);
            pst.setString(2, descripcionInsumo);
            pst.setInt(3, existenciaInsumo);
            pst.setDouble(4, precioCompra);
            pst.setString(5, id);
            int n = pst.executeUpdate();
            if (n > 0){
                JOptionPane.showMessageDialog(null, "Insumo editado con éxito", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error al modificar el insumo,", "Error",
                JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
            
        }
    }
    
    public ArrayList<InformacionInsumo> verDatosInsumosInventario() {
        ArrayList<InformacionInsumo> datosObtenidos = new ArrayList<InformacionInsumo>();
        try {
            Connection con = null;
            ConexionDB conect = ConexionDB.InstanciaSingleton();
            con = conect.conectarMySQL();
            String sql = "SELECT idGenerado, nombre, descripcion, existencias, precioCompra FROM insumo";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InformacionInsumo insumoInformacion = new InformacionInsumo(rs.getString("idGenerado"), rs.getString("nombre"),
                        rs.getString("descripcion"), rs.getString("existencias"), rs.getString("precioCompra"));
                datosObtenidos.add(insumoInformacion);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return datosObtenidos;
    }
    
    public boolean verificar_insumo(String id, String nombreProducto, String descripcionP, String existenciasP,  String precioCompraP){
        if(id.equals("") && nombreProducto.equals("") && descripcionP.equals("") && existenciasP.equals("") &&  precioCompraP.equals("")){
            return false;
        }else{
            return true;
        }
    }
}
