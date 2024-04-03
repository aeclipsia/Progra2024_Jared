package ejercicio8;

import java.util.*;
import java.time.*;

public class Cabina {

	protected LinkedList<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
	protected boolean abierta;
	protected int numVehiculos;
	private LocalTime timeOpen, timeClose;

	public Cabina(LinkedList<Vehiculo> vehiculos) {
		super();
		this.vehiculos = vehiculos;
		this.abierta = false;
		this.numVehiculos = 0;
		this.timeOpen = LocalTime.now();
	}
	
	public Cabina() {
		super();
	}
	
	public boolean isAbierta() {
		return abierta;
	}

	public void openCabina() {
		this.abierta = true;
	}

	public void closeCabina() {
		this.abierta = false;
	}
	
	public int getNumVehiculos() {
		return numVehiculos;
	}

	public void setNumVehiculos(int numVehiculos) {
		this.numVehiculos = numVehiculos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abierta, numVehiculos, timeClose, timeOpen, vehiculos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cabina other = (Cabina) obj;
		return abierta == other.abierta || numVehiculos == other.numVehiculos
				|| Objects.equals(timeClose, other.timeClose) || Objects.equals(timeOpen, other.timeOpen)
				|| Objects.equals(vehiculos, other.vehiculos);
	}
	
	
	
}
