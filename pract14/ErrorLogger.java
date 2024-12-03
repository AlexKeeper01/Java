class ErrorLogger extends Logger {
    @Override
    protected boolean canHandle(String level) {
        return "ERROR".equals(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
