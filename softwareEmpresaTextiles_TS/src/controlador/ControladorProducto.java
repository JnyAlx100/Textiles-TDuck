package controlador;

import java.sql.SQLException;
import modelo.ProductoSQL;

/**
 *
 * @author jossu
 */
public class ControladorProducto {
    private ProductoSQL ingresarProducto = new ProductoSQL();
    private int existenciasProducto;
    private float precioProducto;
    
    public boolean verificarInformacion(String id, String nombreProducto, String descripcionP, String existenciasP,  String precioVentaP) throws SQLException{
        if (id.equals(id.toString()) && nombreProducto.equals(nombreProducto.toString()) && descripcionP.equals(descripcionP.toString()) && existenciasP.equals(existenciasP.toString()) && precioVentaP.equals(precioVentaP.toString())) {
            if(id.equals("") && nombreProducto.equals("") && descripcionP.equals("") && existenciasP.equals("") &&  precioVentaP.equals("")){
                return false;
            }else{
                if (existenciasP.matches("-?\\d+") && (precioVentaP.matches("^\\d*\\.\\d+|\\d+\\.\\d*$") || precioVentaP.matches("-?\\d+"))) {
                    existenciasProducto = Integer.parseInt(existenciasP);
                    precioProducto = Float.parseFloat(precioVentaP);
                    if (ingresoDatos(id, nombreProducto, descripcionP, existenciasProducto, precioProducto)) {
                        return true;
                    }
                }
                return false;
            }
        }else{
            return false;
        }
    }
    private boolean ingresoDatos(String idGenerado, String nombre, String descripcion, int existencias, float precioVenta) throws SQLException{
        if (ingresarProducto.nuevo_producto(idGenerado, nombre, descripcion, existencias, precioVenta)) {
            return true;
        }else{
            return false;
        }
    }
}
