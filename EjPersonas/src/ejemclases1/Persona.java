/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemclases1;


public class Persona {
    private String nif;
    private int edad,numHijos;
    private char sexo;
    private boolean casado;
    
    public Persona(char s, String n) {
    	nif="";
    	sexo=s;
    }
    
    public Persona(char s){
        nif="";
        edad=0;
        numHijos=0;
        casado=false;
        sexo=s;
    }
    public Persona(char s, String n, int e, int nh, boolean c){
      nif=n;
      edad=e;
      numHijos=nh;
      sexo=s;
      casado=c;
    }
    public void cumplirAnyos(){
        edad++;
    }
    
    public boolean casarse(){
        if (casado)
            return false;
        else{
            casado=true;
            return true;
        }
    }
            
    public void tenerHijos(int nh){
        numHijos=numHijos+nh;
    }

    @Override
    public String toString() {
        return "Persona{" + "nif=" + nif + ", edad=" + edad + ", numHijos=" + numHijos + ", sexo=" + sexo + ", casado=" + casado + '}';
    }

    public String getNif() {
        return nif;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }
    
    
}
