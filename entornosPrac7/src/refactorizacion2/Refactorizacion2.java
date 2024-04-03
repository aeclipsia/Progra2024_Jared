/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorizacion2;
import java.util.*;

import otro.pedido; //imoprtar pedido

//quitar import java.io.* ya que nunca se ha utilizado

/**
 *
 * @author Bego
 */
public class Refactorizacion2 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        pedido p1=new pedido(2,4,5.3);
        pedido p2=new pedido(3,5,7.2);
        
        if (p1.importeTotal<p2.importeTotal)
            System.out.println("El pedido más caro es el de codigo:"+p2.codigo); //cambiar los carácters con tildes que no funcionan
        else
            if (p1.importeTotal>p2.importeTotal)
                System.out.println("El pedido más caro es el de codigo:"+p1.codigo);
        
       System.out.println("\nAnota el nuevo precio del primer pedido:");
       p1.precioPorCantidad=sc.nextDouble();
       p1.importeTotal=p1.precioPorCantidad*p1.cantidad;
       System.out.println("\nEl nuevo precio es:"+p1.importeTotal);
       
       System.out.println("\nEl precio del primer pedido con una rebaja del 20% es de:"+p1.rebajar(20));
       
       System.out.println("\nInformación del primer pedido,cod:" + p1.codigo + ",precio unidad:"+ p1.precioPorCantidad + ",cantidad:"+ p1.cantidad);
       System.out.println("\nInformación del segundo pedido,cod:" + p2.codigo + ",precio unidad:"+ p2.precioPorCantidad + ",cantidad:"+ p2.cantidad);
    }
}

    

