/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yow
 */
public class GeneradorReportes {
    TipoDeReporte tipoReporte;
    
    public GeneradorReportes(TipoDeReporte tipoReporte){
        this.tipoReporte = tipoReporte;
    }
    
    public void busquedaSimple(String nit){
        tipoReporte.generarReporteCorto(nit);
    }
    
    public void busquedaDetallada(String nit){
        tipoReporte.generarReporteDetallado(nit);
    }
    
    public DefaultTableModel formatoTabla(){
        return tipoReporte.getTableModel();
    }
}
