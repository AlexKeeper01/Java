class WarningLogger extends Logger {
    @Override
    protected boolean canHandle(String level) {
        return "WARNING".equals(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[WARNING]: " + message);
    }
}
