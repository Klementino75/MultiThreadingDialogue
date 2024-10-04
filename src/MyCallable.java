import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private final String name;
    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int countMSG = 0; // количествово сообщений
        try {
            for (int i = 0; i <= 4; i++) {
                Thread.sleep(2500);
                System.out.println("Я, " + name + ". Всем привет!");
                countMSG++;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.printf("%s завершен.\n", name);
        }
        return countMSG;
    }
}
