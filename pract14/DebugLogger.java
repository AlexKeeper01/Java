class DebugLogger extends Logger {
    @Override
    protected boolean canHandle(String level) {
        return "DEBUG".equals(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[DEBUG]: " + message);
    }
}
