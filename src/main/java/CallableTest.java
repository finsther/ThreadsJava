import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        // Crea un objeto que implemente la interfaz invocable
        MyCallable callable = new MyCallable();
        // Crea un objeto FutureTask con el objeto que implementa la interfaz invocable como parámetro
        FutureTask<String> task = new FutureTask<>(callable);
        // Crea un hilo para manejar la tarea invocable actual
        Thread thread = new Thread(task);
        // Abrir hilo
        System.out.println("La hora para iniciar la tarea:" + getNowTime());
        thread.start();
        // Obtiene el valor de retorno del método de llamada
        try {
            String result = task.get();
            System.out.println("Obtener el valor de retorno:" + result);
            System.out.println("Fin del tiempo de ejecución de get:" + getNowTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
