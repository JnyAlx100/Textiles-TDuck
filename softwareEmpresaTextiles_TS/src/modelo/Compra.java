/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Serratia Marcesens
 */
public class Compra {
    private int idCompra;
    private int idProveedor;
    private Date fecha;
    private float total;
    private int usuarioSistema;

    public Compra(int idCompra, int idProveedor, Date fecha, float total, int usuarioSistema) {
        this.idCompra = idCompra;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.total = total;
        this.usuarioSistema = usuarioSistema;
    }

    public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(int usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
    
}
