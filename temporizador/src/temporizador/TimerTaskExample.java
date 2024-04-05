package temporizador;
import java.util.TimerTask;

public class TimerTaskExample extends TimerTask {
    @Override
    public void run() {
        // Coloca aquí el código que deseas ejecutar en cada intervalo
        System.out.println("Tarea ejecutada...");
    }
}
