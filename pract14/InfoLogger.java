class InfoLogger extends Logger {
    @Override
    protected boolean canHandle(String level) {
        return "INFO".equals(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[INFO]: " + message);
    }
}
