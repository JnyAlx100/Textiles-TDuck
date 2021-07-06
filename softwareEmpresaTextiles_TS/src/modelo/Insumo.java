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
public class Insumo {
    private int idInsumo;
    private String idGenerado;
    private String nombre;
    private String descripcion;
    private int existencias;
    private float precioCompra;

    public Insumo(int idInsumo, String idGenerado, String nombre, String descripcion, int existencias, float precioCompra) {
        this.idInsumo = idInsumo;
        this.idGenerado = idGenerado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.precioCompra = precioCompra;
    }

    public Insumo() {
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
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

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }
    
}
