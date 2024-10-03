public class Main {

    public static void main(String[] args) {

        // Главная группа потоков.
        ThreadGroup mainGroup = new ThreadGroup("main group");

        // Создание 4 потоков, каждый из которых имеет свое имя.
        System.out.println("Создаю потоки...");
        final Thread threadID1 = new MyThread(mainGroup, "Поток 1");
        final Thread threadID2 = new MyThread(mainGroup, "Поток 2");
        final Thread threadID3 = new MyThread(mainGroup, "Поток 3");
        final Thread threadID4 = new MyThread(mainGroup, "Поток 4");

        // Запуск потоков.
        System.out.println("Старт!");
        threadID1.start();
        threadID2.start();
        threadID3.start();
        threadID4.start();

        // Завершаем все потоки одним вызовом
        try {
            Thread.sleep(15000); // Ожидание 15 секунд
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Завершаю все потоки.");
        mainGroup.interrupt();
    }
}