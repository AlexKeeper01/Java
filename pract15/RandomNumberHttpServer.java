import java.io.*;
import java.net.*;
import java.util.Random;


public class RandomNumberHttpServer {
    private static final int PORT = 2121;
    private static final String STUDENT_NAME = "Попов Алексей Валерьевич";
    private static final String STUDENT_ID = "21";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Random Number HTTP Server запущен на порту " + PORT);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка запуска сервера: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

        String line = in.readLine();
        if (line == null) return;

        String[] parts = line.split(" ");
        String method = parts[0];
        String path = parts[1];

        if (method.equals("GET") && path.startsWith("/random")) {
            handleRandomRequest(path, out);
        } else {
            sendHttpResponse(out, 404, "<html><body><h1>404 Not Found</h1></body></html>");
        }

        out.flush();
    }

    private static void handleRandomRequest(String path, PrintWriter out) {
        try {
            String[] params = path.split("\\?")[1].split("&");
            int min = Integer.parseInt(params[0].split("=")[1]);
            int max = Integer.parseInt(params[1].split("=")[1]);

            if (min > max) {
                sendHttpResponse(out, 400, "<html><body><h1>Error: min is greater than max</h1></body></html>");
                return;
            }

            int randomNum = new Random().nextInt((max - min) + 1) + min;
            sendHttpResponse(out, 200, "<html><body><h1>Random number: " + randomNum + "</h1></body></html>");
        } catch (Exception e) {
            sendHttpResponse(out, 400, "<html><body><h1>Error: Incorrect parameters</h1></body></html>");
        }
    }

    private static void sendHttpResponse(PrintWriter out, int statusCode, String body) {
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/html");
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }
}
