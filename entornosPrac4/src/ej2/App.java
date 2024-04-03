package ej2;

public class App {

    public static boolean esValidaNota(int nota){
        if (nota<0 || nota>10)
            return false;
        return true;
    }

    public static double calcularMedia(int nota1,int nota2, int nota3){
        double media=-1;
        if (esValidaNota(nota1) || esValidaNota(nota2) && esValidaNota(nota3))
            media=nota1+nota2+nota3/3;
        return media;
    }
	
}
