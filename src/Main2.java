import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Создаем пул потоков фиксированного размера.
        System.out.println("Создаю потоки...");
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Создаем задачу с результатом типа String.
        Callable<Integer> myCallableID1 = new MyCallable("Поток 1");
        Callable<Integer> myCallableID2 = new MyCallable("Поток 2");
        Callable<Integer> myCallableID3 = new MyCallable("Поток 3");
        Callable<Integer> myCallableID4 = new MyCallable("Поток 4");

        // Отправляем задачу на выполнение в пул потоков.
        final Future<Integer> task1 = threadPool.submit(myCallableID1);
        final Future<Integer> task2 = threadPool.submit(myCallableID2);
        final Future<Integer> task3 = threadPool.submit(myCallableID3);
        final Future<Integer> task4 = threadPool.submit(myCallableID4);

        // Получаем результат.
        final int resultOfTask1 = task1.get();
        final int resultOfTask2 = task2.get();
        final int resultOfTask3 = task3.get();
        final int resultOfTask4 = task4.get();

        // Выводим результат.
        System.out.println("Поток 1, сообщений: " + resultOfTask1 + ".");
        System.out.println("Поток 2, сообщений: " + resultOfTask2 + ".");
        System.out.println("Поток 3, сообщений: " + resultOfTask3 + ".");
        System.out.println("Поток 4, сообщений: " + resultOfTask4 + ".");

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(myCallableID1);
        tasks.add(myCallableID2);
        tasks.add(myCallableID3);
        tasks.add(myCallableID4);

        System.out.println("\nРезультат метода invokeAny: " + threadPool.invokeAny(tasks));

        // Завершаем работу пула потоков.
        System.out.println("Завершаю все потоки.");
        threadPool.shutdown();
    }
}
