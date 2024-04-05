package temporizador;
import java.util.Timer;
import java.util.TimerTask;
/*
 * En este ejemplo, se crea un objeto Timer y se programa una tarea TimerTask para que se ejecute 
 * cada segundo (1000 milisegundos). Luego, se hace que el programa espere durante 5 segundos (5000 milisegundos) 
 * antes de cancelar la tarea del temporizador. La tarea simplemente imprime "Tarea ejecutada..." 
 * en la consola en cada ejecución. Puedes reemplazar ese código con la lógica que desees ejecutar en cada intervalo.
 */
public class Temporizador {
	
	    public static void main(String[] args) {
	        Timer timer = new Timer();

	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                // Coloca aquí el código que deseas ejecutar en cada intervalo
	                System.out.println("Tarea ejecutada...");
	            }
	        };

	        // Programa la tarea para que se ejecute cada segundo (1000 milisegundos)
	        timer.schedule(task, 0, 1000);

	        // Espera un tiempo para darle oportunidad al programa de ejecutar la tarea
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Cancela la tarea después de 5 segundos
	        timer.cancel();
	    }
	}