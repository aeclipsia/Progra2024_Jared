package ej4;

public class Triangulo extends Poligono{

	int lado2, lado3;
	
	public Triangulo(int lados, int base, int altura, int lado2, int lado3) {
		super(lados, base, altura);
		this.lado2 = lado2;
		this.lado3 = lado3;
		// TODO Auto-generated constructor stub
	}
	
	public void area() {
		double area=base*altura/2;
		System.out.println("Área del triangulo: "+area);
	}
	
	public void perimetro() {
		int perimetro=base+lado2+lado3;
		System.out.println("Perimetro del cuadrado: "+perimetro);
	}
}