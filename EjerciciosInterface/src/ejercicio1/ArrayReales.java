package ejercicio1;

public class ArrayReales implements Estadisticas{

	private double numeros[];
	private int tam; //tamaño máximo
	private int num; //número de datos actualmente
	
	public ArrayReales(int tam) {
		numeros=new double[tam];
		this.tam = tam;
	}
	
	public boolean add(double n) {
		if (num==tam) {
			return false;
		}
		numeros[num]=n;
		num++;
		return true;
	}
	
	@Override
	public double minimo() {
		double min=Double.MAX_VALUE;
		for (int i = 0; i < num; i++) {
			if (min>numeros[i]) {
				min=numeros[i];
			}
		}
		return min;
	}

	@Override
	public double maximo() {
		double max=Double.MIN_VALUE;
		for (int i = 0; i < num; i++) {
			if (max<numeros[i]) {
				max=numeros[i];
			}
		}
		return max;
	}

	@Override
	public double sumatorio() {
		double sum=0;
		for (int i = 0; i < num; i++) {
			sum+=numeros[i];
		}
		return sum;
	}
	
	
	
}
