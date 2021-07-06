/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Douglas
 */
public class FabricaFactura {
    private static ConstructorFactura constructorFactura;
    
    public static ConstructorFactura fabricarFactura(int index){
        System.out.println("El index a utilizar es " + index);
        if (index == 0){ 
            constructorFactura = new ConstructorFacturaDigital();
        }
        else if (index == 1){
            constructorFactura = new ConstructorFacturaJasper();
        }
        return constructorFactura;
    }
    
}
