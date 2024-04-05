package ejInterfaceRunnable;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Creamos una instancia de la clase que implementa Runnable
        Tarea1 tarea = new Tarea1();
        Tarea2 tarea2 = new Tarea2();
       

        // Creamos un hilo y le pasamos la instancia de la tarea
        Thread hilo = new Thread(tarea);
        Thread hilo2 = new Thread(tarea2);
      

        // Iniciamos el hilo
        hilo.start();
        hilo2.start();
      
        
        for (int i = 0; i < 100; i++) {
            System.out.println("Padre... " + i);
            try {
                Thread.sleep(80); // Espera de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // El programa continúa ejecutándose mientras el hilo está en marcha
        // Hacemos una pausa en el hilo principal para esperar la finalización del hilo secundario
        try {
            hilo.join(); // Espera hasta que el hilo termine
            hilo2.join();
          
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        }

       
        // Una vez que el hilo termina, continuamos con el flujo del programa
        System.out.println("Tarea completada.");
    }
	

}
