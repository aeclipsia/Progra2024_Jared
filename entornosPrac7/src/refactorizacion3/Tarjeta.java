/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorizacion3;

/**
 *
 * @author BEGO
 */
public class Tarjeta {
 public int numeroTarjeta;
 public String nombreTitular;
 public double saldo;
 public static int codigoInicial=5000;
 
 public Tarjeta(String n, double s){
     nombreTitular=n;
     saldo=s;
     numeroTarjeta=codigoInicial;
     codigoInicial++;
 }
 
 public double sacar(double d){
     if (d>saldo){
         saldo=0;
         return saldo;
     }
     saldo=saldo-d;
     return d;
 }
 

     
 
 
 
}
