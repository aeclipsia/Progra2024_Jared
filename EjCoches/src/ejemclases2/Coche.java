/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemclases2;


public class Coche {

    private String matricula;
    private int velocidad;

    public Coche(String m) {
        matricula = m;
        velocidad = 0;
    }

    public void acelerar(int va) {
        velocidad += va; //velocidad=velocidad+va;
    }

    public void frenar(int vf) {
        velocidad -= vf;
    }

}
