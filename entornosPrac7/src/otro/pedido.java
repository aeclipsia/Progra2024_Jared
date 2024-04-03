/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otro;

public class pedido {
    public int codigo, cantidad;
    public double precioPorCantidad,importeTotal; //p = precioPorCantidad t = importeTotal
    
    public pedido(int cod,int ca,double pr){ //c = cod
        codigo=cod;
        cantidad=ca;
        precioPorCantidad=pr;
        importeTotal=precioPorCantidad*cantidad;
    }
    
    public double rebajar(double por){
        importeTotal=importeTotal-(importeTotal*por)/100;
        return importeTotal;
    }
    
}
