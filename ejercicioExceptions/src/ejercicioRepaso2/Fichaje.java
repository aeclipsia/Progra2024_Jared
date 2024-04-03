package ejercicioRepaso2;

import java.time.LocalTime;

public class Fichaje {
	private int nEmp;
	private LocalTime hora;
	private static LocalTime horaEntradaTodos, horaSalidaTodos;
	private int tipo; //0 entrada, 1 salida
	private int incidencia; //0 sin incidencia, 1 entra tarde
							// 2 sale pronto
							// 3 dos entradas
							// 4 dos salidas
	
	public static void setHoraEntradaTodos(LocalTime horaEntradaTodos) {
		Fichaje.horaEntradaTodos = horaEntradaTodos;
	}
	
	public static void setHoraSalidaTodos(LocalTime horaSalidaTodos) {
		Fichaje.horaSalidaTodos = horaSalidaTodos;
	}

	public Fichaje(int nEmp, int tipo, int incidencia) {
		super();
		this.nEmp = nEmp;
		this.tipo = tipo;
		this.incidencia = incidencia;
		this.hora=LocalTime.now();
		if (tipo==0 && hora.isAfter(horaEntradaTodos))
			this.incidencia=1;
		if (tipo==1 && hora.isBefore(horaSalidaTodos))
			this.incidencia=2;
	}

	public String printFichaje() {
		return "Empleado "+nEmp+": Tipo de fichaje: "+tipo+", Tipo de incidencia: "+incidencia;
	}
	
	
	
	
	
	

}
