package ejInterfaceRunnable;

public class Tarea1 implements Runnable {
	
	int numTarea;
	
	public Tarea1(int numTarea) {
		super();
		this.numTarea = numTarea;
	}

	public void run() {
	      // Esta es la tarea que se ejecutar� en un hilo separado
	      for (int i = 0; i < 100; i++) {
	          System.out.println("Ejecutando tarea "+numTarea+" ... " + i);
	          try {
	              Thread.sleep(100); // Espera de 1 segundo
	          } catch (InterruptedException e) {
	              e.printStackTrace();
	          }
	      }
	  }
}
