package ej4;

public abstract class Poligono {

	protected int lados; //nº de lado del polígono
	protected int base;
	protected int altura;//base y altura de polígonos
	
	public Poligono(int lados, int base, int altura) {
		this.lados = lados;
		this.base = base;
		this.altura = altura;
	}
	
	abstract public void area();
	
	abstract public void perimetro();
	
}
