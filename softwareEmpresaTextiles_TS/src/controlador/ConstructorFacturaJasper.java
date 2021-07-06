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
public class ConstructorFacturaJasper implements ConstructorFactura {

    @Override
    public void agregarProductos(ArrayList<Producto> array) {
        System.out.println("FUNCIONANDO AGREGAR JASPER");
    }

    @Override
    public void setVenta(Venta venta) {
        System.out.println("FUNCIONANDO SETVENTA JASPER");
    }

    @Override
    public void generarFactura() {
        System.out.println("FUNCIONANDO GENERAR JASPER");
    }
    
}
