class CriticalLogger extends Logger {
    @Override
    protected boolean canHandle(String level) {
        return "CRITICAL".equals(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[CRITICAL]: " + message);
    }
}
