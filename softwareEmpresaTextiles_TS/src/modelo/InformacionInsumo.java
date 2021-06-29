package clases;
/**
 *
 * @author jossu
 */
public class InformacionInsumo {
    private String idInsumo, nombreInsumo, descripcionInsumo, existenciasInsumo, precioCompraInsumo;

    public InformacionInsumo(String idInsumo, String nombreInsumo, String descripcionInsumo, String existenciasInsumo, String precioCompraInsumo) {
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.descripcionInsumo = descripcionInsumo;
        this.existenciasInsumo = existenciasInsumo;
        this.precioCompraInsumo = precioCompraInsumo;
    }

    public String getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(String idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }

    public String getExistenciasInsumo() {
        return existenciasInsumo;
    }

    public void setExistenciasInsumo(String existenciasInsumo) {
        this.existenciasInsumo = existenciasInsumo;
    }

    public String getPrecioCompraInsumo() {
        return precioCompraInsumo;
    }

    public void setPrecioCompraInsumo(String precioCompraInsumo) {
        this.precioCompraInsumo = precioCompraInsumo;
    }
    
}
