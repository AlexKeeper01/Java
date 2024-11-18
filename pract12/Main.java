public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            AppSettings settings = AppSettings.getInstance();
            settings.setSetting("Theme", "Dark");
            settings.setSetting("Language", "English");
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        AppSettings.getInstance().printSettings();
    }
}
