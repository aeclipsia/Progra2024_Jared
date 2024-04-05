package ejInterfaceRunnable;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static ArrayList<Tarea1> tareas=new ArrayList<Tarea1>();
	static ArrayList<Thread> hilos=new ArrayList<Thread>();
	static int op;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Creamos una instancia de la clase que implementa Runnable
		System.out.println("Cuantas tareas?");
       op=sc.nextInt();
       
       for (int i = 0; i < op; i++) {
		tareas.add(new Tarea1(i));
	}

        // Creamos un hilo y le pasamos la instancia de la tarea
       for (int i = 0; i < op; i++) {
		hilos.add(new Thread(tareas.get(i)));
	}   

        // Iniciamos el hilo
       for (int i = 0; i < op; i++) {
		hilos.get(i).start();
	} 
        
        // El programa continúa ejecutándose mientras el hilo está en marcha
        // Hacemos una pausa en el hilo principal para esperar la finalización del hilo secundario
        try {
            // Espera hasta que el hilo termine
        	for (int i = 0; i < op; i++) {
        		hilos.get(i).join();
        	} 
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        }

       
        // Una vez que el hilo termina, continuamos con el flujo del programa
        System.out.println("Tarea completada.");
    }
	

}
