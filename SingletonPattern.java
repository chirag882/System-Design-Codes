class ConfigManager {
    private static ConfigManager instance;
    private String dbUrl;
    private String apiKey;

    // private constructor
    private ConfigManager() {
        // Imagine reading from a config file here
        dbUrl = "jdbc:mysql://localhost:3306/mydb";
        apiKey = "XYZ123";
    }

    // global access point
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
public class SingletonPattern {
        public static void main(String[] args) {
        ConfigManager config1 = ConfigManager.getInstance();
        ConfigManager config2 = ConfigManager.getInstance();

        System.out.println(config1.getDbUrl());
        System.out.println("Same instance? " + (config1 == config2));
    }
}

