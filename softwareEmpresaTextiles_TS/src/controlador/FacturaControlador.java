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
public class FacturaControlador {
    ConstructorFactura constructor;
    
    public FacturaControlador(int index) {
        System.out.println("El index pasado a es : " + index);
        constructor = FabricaFactura.fabricarFactura(index);
    }
    
    public void añadirCanastaAFactura(ArrayList<Producto> array){
        constructor.agregarProductos(array);
    }
    
    public void agregarVentaCorrespondiente(Venta venta){
        constructor.setVenta(venta);
    }
    
    public void generar(){
        constructor.generarFactura();
    }
}
