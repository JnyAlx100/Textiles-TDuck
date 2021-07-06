/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Serratia Marcesens
 */
public class DetalleCompraSQL {

    public static void insertarDetalleCompra(DetalleCompra dc) {
        int n = 0;
        try {
            ConexionDB con1 = ConexionDB.InstanciaSingleton();
            Connection con = con1.conectarMySQL();
            String query
                    = " INSERT INTO detallecompra (Compra_idCompra, Insumo_idInsumo, cantidad) VALUES"
                    + "(" + "'" + dc.getIdCompra() + "'" + "," + "'" + dc.getIdInsumo() + "'" + "," + "'" + dc.getCantidad() + "'" 
                    + ")" + ";";
            System.out.println("query: " + query);
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(query);
            if (n > 0) {
                System.out.println("DATOS GUARDADOS CORRECTAMENTE EN DETALLECOMPRA");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println("LOS DATOS DE DETALLECOMPRA NO HAN SIDO GUARDADOS CORRECTAMENTE");
        }
    }
}
