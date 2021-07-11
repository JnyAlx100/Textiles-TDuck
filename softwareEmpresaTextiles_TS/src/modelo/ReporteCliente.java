/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yow
 */
public class ReporteCliente implements TipoDeReporte {
    DefaultTableModel modelo;
    @Override
    public void generarReporteCorto(String nit) {
        try {
            ConexionDB conexion = ConexionDB.InstanciaSingleton();
            Connection cn = conexion.conectarMySQL();
            String sql = "SELECT v.idVenta, c.nit, v.fecha, v.total FROM venta v "
                    + "INNER JOIN cliente c ON v.Cliente_idCliente=c.idCliente "
                    + "WHERE c.nit = '" + nit + "'"
                    + " ORDER BY v.idVenta;";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            setTableModel(rs);
            conexion.Desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER CLIENTE", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void generarReporteDetallado(String nit) {
        try {
            ConexionDB conexion = ConexionDB.InstanciaSingleton();
            Connection cn = conexion.conectarMySQL();
            String sql = "SELECT v.idVenta, c.nit, v.fecha, dv.Producto_idProducto AS IDProducto, p.nombre, dv.cantidad FROM venta v "
                    + "INNER JOIN detalleventa dv ON dv.Venta_idVenta=v.idVenta "
                    + "INNER JOIN producto p ON dv.Producto_idProducto=p.idProducto "
                    + "INNER JOIN cliente c ON v.Cliente_idCliente=c.idCliente "
                    + "WHERE c.nit = '" + nit + "'"
                    + " ORDER BY v.idVenta;";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            setTableModel(rs);
            conexion.Desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER CLIENTE", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void setTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData;
            metaData = (ResultSetMetaData) rs.getMetaData();
            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                System.out.println("El nombre columna es: " + metaData.getColumnName(column));
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    System.out.println("El objeto es: " + rs.getObject(columnIndex));
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            System.out.println("cambiada " + modelo);
            modelo = new DefaultTableModel(data, columnNames);
            System.out.println("cambiada2 " + modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public DefaultTableModel getTableModel() {
        return modelo;
    }
    
}
