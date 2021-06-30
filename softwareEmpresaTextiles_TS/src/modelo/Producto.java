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
public class Producto {
    private int idProducto;
    private String idGenerado;
    private String nombre;
    private String descripcion;
    private int existencias;
    private float precioVenta;

    public Producto(int idProducto, String idGenerado, String nombre, String descripcion, int existencias, float precioVenta) {
        this.idProducto = idProducto;
        this.idGenerado = idGenerado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.precioVenta = precioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdGenerado() {
        return idGenerado;
    }

    public void setIdGenerado(String idGenerado) {
        this.idGenerado = idGenerado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
}
