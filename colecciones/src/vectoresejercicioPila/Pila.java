package vectoresejercicioPila;

import java.util.*;

public class Pila extends Vector<Object>{

	public void addElemento(Object e) {
		this.add(e);
	}
	
	public void borrarElemento() {
		if (this.isEmpty()==false) {
			this.remove(this.size()-1);
		}
	}
	
	public Object ultimoElemento() {
		if (this.isEmpty()==false) {
			return this.get(this.size()-1);
		}
		return "Vector vacío";
	}
	
	public boolean vectorIsEmpty() {
		if (this.isEmpty()==false) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
