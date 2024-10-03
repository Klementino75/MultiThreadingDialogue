import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Создаем пул из 4 потоков фиксированного размера.
        System.out.println("Создаю потоки...");
        final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
