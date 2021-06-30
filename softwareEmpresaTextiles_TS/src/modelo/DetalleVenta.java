/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Serratia Marcesens
 */
public class DetalleVenta {
    private int ventaIdVenta;
    private int productoidProducto;
    private int cantidad;

    public DetalleVenta(int ventaIdVenta, int productoidProducto, int cantidad) {
        this.ventaIdVenta = ventaIdVenta;
        this.productoidProducto = productoidProducto;
        this.cantidad = cantidad;
    }

    public int getVentaIdVenta() {
        return ventaIdVenta;
    }

    public void setVentaIdVenta(int ventaIdVenta) {
        this.ventaIdVenta = ventaIdVenta;
    }

    public int getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(int productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
