import java.util.HashMap;
import java.util.Map;

public class AppSettings {
    private static AppSettings instance;
    private final Map<String, String> settings;

    private AppSettings() {
        settings = new HashMap<>();
    }

    public static synchronized AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }

    public String getSetting(String key) {
        return settings.get(key);
    }

    public void printSettings() {
        settings.forEach((key, value) -> System.out.println(key + ": " + value)
        );
    }
}
