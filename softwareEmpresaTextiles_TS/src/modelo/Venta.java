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
public class Venta {
    private int idVenta;
    private int clienteIdCliente;
    private Date fecha;
    private float totalSinIva;
    private float total;
    private float descuento;
    private int usuarioSistema;

    public Venta(int idVenta, int clienteIdCliente, Date fecha, float totalSinIva, float total, float descuento, int usuarioSistema) {
        this.idVenta = idVenta;
        this.clienteIdCliente = clienteIdCliente;
        this.fecha = fecha;
        this.totalSinIva = totalSinIva;
        this.total = total;
        this.descuento = descuento;
        this.usuarioSistema = usuarioSistema;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(float totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public int getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(int usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
    
}
