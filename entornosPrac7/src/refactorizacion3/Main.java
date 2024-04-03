/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorizacion3;
import java.util.*;

/**
 *
 * @author BEGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        
        double saldo;
        String nombre;
        
        System.out.println("Anota nombre");
        nombre=sc.nextLine();
        
        do{
            System.out.println("Anota saldo:");
            saldo=sc.nextDouble();
            if (saldo<1000)
                System.out.println("Saldo menor del permitido");
        }while(saldo<1000);
        
        Tarjeta c1=new Tarjeta(nombre,saldo);
        sc.nextLine(); //no ha limpiado buffer
        
        System.out.println("Anota nombre");
        nombre=sc.nextLine();
        do{
            System.out.println("Anota saldo:");
            saldo=sc.nextDouble();
            if (saldo<1000)
                System.out.println("Saldo menor del permitido");
        }while(saldo<1000);
        
        Tarjeta c2=new Tarjeta(nombre,saldo);
        
        System.out.println("Anota el importe a ingresar:");
        double importe=sc.nextDouble();
        c1.saldo=c1.saldo+importe;
        
        System.out.println("Anota importe a sacar");
        importe=sc.nextDouble();
        c1.sacar(importe);
        
        System.out.println("Información de la tarjeta 1:"+ c1.numeroTarjeta+","+ c1.nombreTitular+ ","+ c1.saldo);
        c2.numeroTarjeta=Tarjeta.codigoInicial++; //inline
        sc.nextLine(); //no ha limpiado buffer
        
        System.out.println("Nuevo nombre de la tarjeta:");
        String nuevoNombre=sc.nextLine();
        c2.nombreTitular=nuevoNombre;
        System.out.println("Información de la tarjeta 2:"+ c2.numeroTarjeta+","+ c2.nombreTitular+ ","+ c2.saldo);
    }
}
