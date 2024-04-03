package letras;

public class prLetras{
	static Letra tabla[]=new Letra[5];
	
	public static void main (String st[]){
		tabla[0]=new LetraA('@');
		tabla[1]=new LetraE('4');
		tabla[2]=new LetraA('#');
		tabla[3]=new LetraE('&');
		tabla[4]=new LetraE('8');
		
		for (int i=0; i<5; i++)
				tabla[i].dibuja();
		}
	}