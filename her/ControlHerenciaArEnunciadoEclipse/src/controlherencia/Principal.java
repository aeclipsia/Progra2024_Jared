 package controlherencia;
import java.util.*;

public class Principal {
    static final int MAXBECAS=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Beca becas[]=new Beca[MAXBECAS];
		int numBecas=0;
		
		int menu, edad,nota;
		String ult_estudio;
		
		
		// Se añaden tantas solicitudes como desee el usuario
		
		
		do{
			
			
				System.out.println("Dni del solicitante: ");
				String dni=sc.nextLine();
				
				int encontrado=buscarDni(dni, becas, numBecas);
				
				if(encontrado == -1){
					
					System.out.println("Tipo de beca:\n1-Oportunidad\n2-Excelencia\n3-Otro");
					menu=sc.nextInt();
					
					System.out.println("Renta per cápita del solicitante: ");
					double renta=sc.nextDouble();
					sc.nextLine();
					
					if(menu==1) {
						System.out.println("Último estudio: ");
						ult_estudio=sc.nextLine();
						System.out.println("Anota edad: ");
						edad=sc.nextInt();
						
						becas[numBecas]=new Beca_oportunidad(dni,renta,ult_estudio,edad);
						
						becas[numBecas].setCodigo("OP",numBecas);
					}
					else if(menu==2) {
						System.out.println("Anota la nota");
						nota=sc.nextInt();
						becas[numBecas]=new Beca_excelencia(dni,renta,nota);
						becas[numBecas].setCodigo("EX",numBecas);
					}
					else if(menu==3) {
						becas[numBecas]=new Beca_otro(dni,renta);
					}
					numBecas++;
						
				}
				else
					System.out.println("Este alumno ya ha hecho una solicitud");
				
				if (numBecas==MAXBECAS)
					break;
				System.out.println("Añadir otra solicitud:\n1. Si\n2. No");
				menu=sc.nextInt();
				sc.nextLine();
			
		}while(menu==1);
		
		//System.out.println("Damos puntuación a las becas*************");
		
		for(int cont=0; cont < numBecas; cont++){
			becas[cont].darPuntuacion();
		}
		
		System.out.println("Becas vigentes***********");
		int j,k;
		Beca aux;
		for(j = 1; j < numBecas; j++) {
			for(k = 0; k < numBecas-1; k++){
				
				if(becas[k].getPuntuacion() < becas[k+1].getPuntuacion()){
					aux=becas[k];
					becas[k]=becas[k+1];
					becas[k+1]= aux;				
				}
				
				else if(becas[k].getPuntuacion() == becas[k+1].getPuntuacion()){
					if (becas[k].getRenta() < becas[k+1].getRenta()) {
						aux=becas[k];
						becas[k]=becas[k+1];
						becas[k+1]= aux;		
					}		
				}
			}
		}
		
		//borrar excelencias con menos de un punto
		for (int l = 0; l < numBecas; l++) {		
			if (becas[l]instanceof Beca_excelencia && becas[l].getPuntuacion()<1) {
				
				for (int m = l; m < numBecas - 1; m++) {
					becas[m] = becas[m + 1];
				}
				numBecas--;
				l--;
			}
		}
		
		/* Mostramos las puntuaciones de todas las becas */
		for(int cont=0; cont < numBecas; cont++)
			System.out.println(becas[cont]);
						
	}

	
	public static int buscarDni(String dni, Beca becas[],int tam){
		
		for(int cont=0; cont < tam;cont++)
			if(becas[cont].getDnialumno().equals(dni))
				return cont;
		return -1;
	}
	
	
	
}
