package modelo;

/**
 *
 * @author jossu
 */
public class InformacionProducto {
    private String idProducto, nombreProducto, descripcionProducto, existenciasProducto, PrecioVentaProducto;

    public InformacionProducto(String idProducto, String nombreProducto, String descripcionProducto, String existenciasProducto, String PrecioVentaProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.existenciasProducto = existenciasProducto;
        this.PrecioVentaProducto = PrecioVentaProducto;
    }


    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setExistenciasProducto(String existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }

    public void setPrecioVentaProducto(String PrecioVentaProducto) {
        this.PrecioVentaProducto = PrecioVentaProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public String getExistenciasProducto() {
        return existenciasProducto;
    }

    public String getPrecioVentaProducto() {
        return PrecioVentaProducto;
    }
    
    
    
}
