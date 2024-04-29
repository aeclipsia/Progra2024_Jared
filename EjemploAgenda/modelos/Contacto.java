package modelos;

/**
 * Contacto: Clase con los datos de la tabla contactos.
 *
 */
public class Contacto {
private String nombre;
private String apellidos;
private String telefono;

public  Contacto(String n, String ape,String t){
	nombre=n;
	apellidos=ape;
	telefono=t;
}

public Contacto(String n, String ape){
	nombre=n;
	apellidos=ape;
}

public String getNombre(){
return nombre;
}

public String getTelefono(){
	return telefono;
}
public String getApellidos(){
	return apellidos;
}

@Override
public String toString() {
	return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
}


}