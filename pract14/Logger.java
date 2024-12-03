abstract class Logger {
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(String level, String message) {
        if (canHandle(level)) {
            writeMessage(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract boolean canHandle(String level);

    protected abstract void writeMessage(String message);
}
