package ejInterfaceRunnable;

public class Tarea2 implements Runnable {
	  public void run() {
	        // Esta es la tarea que se ejecutar� en un hilo separado
	        for (int i = 0; i < 100; i++) {
	            System.out.println("Ejecutando tarea2... " + i);
	            try {
	                Thread.sleep(120); // Espera de 1 segundo
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
