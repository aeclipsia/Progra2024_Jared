package temporizador;
import java.util.Timer;

public class Temporizador {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTaskExample task = new TimerTaskExample();

        // Programa la tarea para que se ejecute cada segundo (1000 milisegundos)
        timer.schedule(task, 0, 1000);

        // Espera un tiempo para darle oportunidad al programa de ejecutar la tarea
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cancela la tarea después de 5 segundos
        timer.cancel();
    }
}
