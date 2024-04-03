package ej3;

public class App {
	public static double potencia(int base, int exponente){
	       
        double resultado=1;
        boolean negativo=false;
        if (base==0 && exponente ==0)
            return -1;
        if (exponente<0){
            exponente=exponente*-1;
            negativo=true;
        }
        for (int x=0;x<exponente;x++)
            resultado=resultado*base;
        if (negativo)
            resultado=(double)1/resultado;
        return resultado;
    }
}
