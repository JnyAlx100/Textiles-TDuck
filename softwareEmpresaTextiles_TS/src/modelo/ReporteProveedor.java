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
public class ReporteProveedor implements TipoDeReporte {
    DefaultTableModel modelo;
    @Override
    public void generarReporteCorto(String nit) {
        try {
            ConexionDB conexion = ConexionDB.InstanciaSingleton();
            Connection cn = conexion.conectarMySQL();
            String sql = "SELECT c.idCompra, p.nit, c.fecha, c.total FROM compra c "
                    + "INNER JOIN proveedor p ON c.Proveedor_idProveedor=p.idProveedor "
                    + "WHERE p.nit = '" + nit + "'"
                    + " ORDER BY c.idCompra;";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            setTableModel(rs);
            conexion.Desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER PROVEEDOR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void generarReporteDetallado(String nit) {
        try {
            ConexionDB conexion = ConexionDB.InstanciaSingleton();
            Connection cn = conexion.conectarMySQL();
            String sql = "SELECT c.idCompra, p.nit, c.fecha, dc.Insumo_idInsumo AS IdInsumo, i.nombre, dc.cantidad FROM compra c "
                    + "INNER JOIN detallecompra dc ON dc.Compra_idCompra=c.idCompra "
                    + "INNER JOIN insumo i ON dc.Insumo_idInsumo=i.idInsumo "
                    + "INNER JOIN proveedor p ON c.Proveedor_idProveedor=p.idProveedor "
                    + "WHERE p.nit = '" + nit + "'"
                    + " ORDER BY c.idCompra;";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            setTableModel(rs);
            conexion.Desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER PROVEEDOR", "Error", JOptionPane.ERROR_MESSAGE);
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
