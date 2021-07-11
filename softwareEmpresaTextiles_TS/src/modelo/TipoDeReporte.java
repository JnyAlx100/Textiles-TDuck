/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author Yow
 */
public interface TipoDeReporte {
    public void generarReporteCorto(String nit);
    public void generarReporteDetallado(String nit);
    public void setTableModel(ResultSet rs);
    public DefaultTableModel getTableModel();
}
