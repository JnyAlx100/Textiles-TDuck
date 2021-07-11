package controlador;

import java.sql.SQLException;
import modelo.InsumoSQL;

/**
 *
 * @author jossu
 */
public class ControladorInsumo {
    private InsumoSQL ingresarInsumo = new InsumoSQL();
    private int existenciasProducto;
    private float precioCompraInsumo;
    
    public boolean verificarInformacion(String id, String nombreProducto, String descripcionP, String existenciasP,  String precioCompraP) throws SQLException{
        if (id.equals(id.toString()) && nombreProducto.equals(nombreProducto.toString()) && descripcionP.equals(descripcionP.toString()) && existenciasP.equals(existenciasP.toString()) && precioCompraP.equals(precioCompraP.toString())) {
            if(id.equals("") && nombreProducto.equals("") && descripcionP.equals("") && existenciasP.equals("") &&  precioCompraP.equals("")){
                return false;
            }else{
                if (existenciasP.matches("-?\\d+") && (precioCompraP.matches("^\\d*\\.\\d+|\\d+\\.\\d*$") || precioCompraP.matches("-?\\d+"))) {
                    existenciasProducto = Integer.parseInt(existenciasP);
                    precioCompraInsumo = Float.parseFloat(precioCompraP);
                    if (ingresoDatos(id, nombreProducto, descripcionP, existenciasProducto, precioCompraInsumo)) {
                        return true;
                    }
                }
                return false;
            }
        }else{
            return false;
        }
    }
    
    private boolean ingresoDatos(String idGenerado, String nombre, String descripcion, int existencias, float precioCompra) throws SQLException{
        if (ingresarInsumo.nuevo_insumo(idGenerado, nombre, descripcion, existencias, precioCompra)) {
            return true;
        }else{
            return false;
        }
    }
    
}
