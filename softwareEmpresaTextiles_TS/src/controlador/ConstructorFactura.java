/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author Douglas
 */
public interface ConstructorFactura {
    public void agregarProductos(ArrayList<Producto> array);
    public void setVenta(Venta venta);
    public void generarFactura();
}
