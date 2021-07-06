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
public class DetalleCompra {
    private int idDetalleCompra;
    private int idCompra;
    private int idInsumo;
    private int cantidad;

    public DetalleCompra(int idDetalleCompra, int idCompra, int idInsumo, int cantidad) {
        this.idDetalleCompra = idDetalleCompra;
        this.idCompra = idCompra;
        this.idInsumo = idInsumo;
        this.cantidad = cantidad;
    }

    public DetalleCompra() {
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
