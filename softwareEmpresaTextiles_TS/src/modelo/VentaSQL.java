/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Serratia Marcesens
 */
public class VentaSQL {
    public int insertarVenta(Venta venta) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String sql = "insert into venta (Cliente_idCliente,fecha,totalSinIVA,total,descuento,UsuarioSistema_idUsuarioSistema) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, venta.getClienteIdCliente());
            pst.setDate(2, Date.valueOf(LocalDate.now()));
            pst.setFloat(3, venta.getTotalSinIva());
            pst.setFloat(4, venta.getTotal());
            pst.setFloat(5, venta.getDescuento());
            pst.setInt(6, venta.getUsuarioSistema());
            n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("DATOS GUARDADOS CORRECTAMENTE");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println("LOS DATOS DE INSERTAR COMPRA NO HAN SIDO GUARDADOS CORRECTAMENTE");
        }
        return n;
    }
    
    public static int getIdVenta() {
        ArrayList<Venta> venta = new ArrayList<>();
        int id = 1;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection cn = con1.conectarMySQL();
            String sql = "select * from venta";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int idVenta = Integer.parseInt(rs.getString("idVenta"));
                int clienteIdCliente = Integer.parseInt(rs.getString("Cliente_idCliente"));
                Date fecha = Date.valueOf(rs.getString("fecha"));
                float totalSinIva = Float.parseFloat(rs.getString("monto_total"));
                float total = Float.parseFloat(rs.getString("total"));
                float descuento = Float.parseFloat(rs.getString("descuento"));
                int usuarioSistema = Integer.parseInt(rs.getString("UsuarioSistema_idUsuarioSistema"));
                venta.add(new Venta(idVenta, clienteIdCliente, fecha, totalSinIva, total, descuento, usuarioSistema));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!venta.isEmpty()) {
            id = venta.get(venta.size() - 1).getIdVenta() + 1;
        }
        return id;
    }
}
