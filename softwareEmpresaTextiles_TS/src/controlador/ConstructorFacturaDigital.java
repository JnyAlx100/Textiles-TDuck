/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author Douglas
 */
public class ConstructorFacturaDigital implements ConstructorFactura, Printable {
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private Venta venta = new Venta();
    Double bHeight=0.0;
    
    @Override
    public void agregarProductos(ArrayList<Producto> array) {
        for (Producto p : array){
            listaProductos.add(p);
            System.out.println(p.getNombre());
        }
    }
    
    @Override
    public void setVenta(Venta venta) {
        this.venta.setIdVenta(venta.getIdVenta());
        this.venta.setTotal(venta.getTotal());
        System.out.println("id: " + venta.getIdVenta());
        System.out.println("total: " + venta.getTotal());
    }

    @Override
    public void generarFactura() {
        bHeight = Double.valueOf(listaProductos.size());
        //JOptionPane.showMessageDialog(rootPane, bHeight);
        
        PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(this,getPageFormat(pj));
        try {
             pj.print();
          
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }
    }
    
    public PageFormat getPageFormat(PrinterJob pj) {
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    
    double bodyHeight = bHeight;  
    double headerHeight = 5.0;                  
    double footerHeight = 5.0;        
    double width = cm_to_pp(8); 
    double height = cm_to_pp(headerHeight+bodyHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(0,10,width,height - cm_to_pp(1));     
    pf.setOrientation(PageFormat.PORTRAIT);  
    pf.setPaper(paper);    
    return pf;
    }
    
    protected static double cm_to_pp(double cm) {            
	return toPPI(cm * 0.393600787);            
    }
 
    protected static double toPPI(double inch) {            
        return inch * 72d;            
    }
    
    public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
        throws PrinterException 
        {    
    
            int r= listaProductos.size();
      //      ImageIcon icon=new ImageIcon("C:UsersccsDocumentsNetBeansProjectsvideo TestPOSInvoicesrcposinvoicemylogo.jpg"); 
            int result = NO_SUCH_PAGE;    
            if (pageIndex == 0) {                    
                Graphics2D g2d = (Graphics2D) graphics;                    
                double width = pageFormat.getImageableWidth();                               
                g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
                  //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
                try{
                    int y=20;
                    int yShift = 10;
                    int headerRectHeight=15;
                   // int headerRectHeighta=40;
                    g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
        //            g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);y+=yShift+30;
                    g2d.drawString("-------------------------------------",12,y);y+=yShift;
                    g2d.drawString("            TextilesTS         ",12,y);y+=yShift;
                    g2d.drawString("     Factura No: " +  String.valueOf(venta.getIdVenta()),12,y);y+=yShift;
                    g2d.drawString("     Chichicastenango, Quiché  ",12,y);y+=yShift;
                    g2d.drawString("        Fecha: " + java.time.LocalDate.now(),12,y);y+=yShift;
//                    g2d.drawString("   www.facebook.com/CodeGuid ",12,y);y+=yShift;
                    g2d.drawString("           +94700000000      ",12,y);y+=yShift;
                    g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;

                    g2d.drawString(" Nombre de producto         Precio   ",10,y);y+=yShift;
                    g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;

                    for(int s=0; s<r; s++)
                    {
                        float subTotal = listaProductos.get(s).getExistencias() * listaProductos.get(s).getPrecioVenta();
                        g2d.drawString(" "+listaProductos.get(s).getNombre()+"                            ",10,y);y+=yShift;
                        g2d.drawString("      "+listaProductos.get(s).getExistencias()+" * "+listaProductos.get(s).getPrecioVenta(),10,y); 

                        g2d.drawString(String.valueOf(subTotal),160,y);y+=yShift;
                    }

                    g2d.drawString("-------------------------------------",10,y);y+=yShift;
                    System.out.println("venta total: " + venta.getTotal());
                    g2d.drawString(" Monto total:               "+String.valueOf(this.venta.getTotal())+"   ",10,y);y+=yShift;
//                    g2d.drawString("-------------------------------------",10,y);y+=yShift;
//                    g2d.drawString(" Cash      :                 "+txtcash.getText()+"   ",10,y);y+=yShift;
//                    g2d.drawString("-------------------------------------",10,y);y+=yShift;
//                    g2d.drawString(" Balance   :                 "+txtbalance.getText()+"   ",10,y);y+=yShift;

                    g2d.drawString("*************************************",10,y);y+=yShift;
                    g2d.drawString("        GRACIAS, VUELVA PRONTO       ",10,y);y+=yShift;
                    g2d.drawString("*************************************",10,y);y+=yShift;
//                    g2d.drawString("       SOFTWARE BY:CODEGUID          ",10,y);y+=yShift;
//                    g2d.drawString("   CONTACT: contact@codeguid.com       ",10,y);y+=yShift;       
                }
                catch(Exception e){
                e.printStackTrace();
                }

                result = PAGE_EXISTS;    
            }    
            return result;    
        }   
}
