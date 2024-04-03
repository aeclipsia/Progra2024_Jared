package ej4;

public class Rectangulo extends Poligono{

	public Rectangulo(int lados, int base, int altura) {
		super(lados, base, altura);
		// TODO Auto-generated constructor stub
	}
	
	public void area() {
		double area=base*altura;
		System.out.println("Área del rectangulo: "+area);
	}

	public void perimetro() {
		int perimetro=(base*2)+(altura*2);
		System.out.println("Perimetro del rectangulo: "+perimetro);
	}
	
}
