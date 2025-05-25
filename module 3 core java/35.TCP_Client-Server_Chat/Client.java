import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Connected to server. Type messages:");

            String message;
            while (true) {
                message = userInput.readLine();
                output.println(message);
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
                String response = input.readLine();
                System.out.println(response);
            }

            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
