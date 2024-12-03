public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Создаем обработчики
        Logger infoLogger = new InfoLogger();
        Logger warningLogger = new WarningLogger();
        Logger errorLogger = new ErrorLogger();
        Logger criticalLogger = new CriticalLogger();
        Logger debugLogger = new DebugLogger();

        // Настраиваем цепочку
        infoLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(criticalLogger);
        criticalLogger.setNextLogger(debugLogger);

        // Тестируем цепочку
        infoLogger.logMessage("INFO", "This is an informational message.");
        infoLogger.logMessage("WARNING", "This is a warning message.");
        infoLogger.logMessage("ERROR", "This is an error message.");
        infoLogger.logMessage("CRITICAL", "This is a critical message.");
        infoLogger.logMessage("DEBUG", "This is a debug message.");
    }
}
