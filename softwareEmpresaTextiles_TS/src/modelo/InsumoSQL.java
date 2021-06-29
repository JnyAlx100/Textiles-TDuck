package clases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jossu
 */
public class InsumoSQL {
    
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
