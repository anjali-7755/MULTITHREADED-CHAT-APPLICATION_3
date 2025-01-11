package chatapp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 2346;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the chat server.");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            out.println(name);

            // Thread to read messages from the server
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from the server.");
                }
            });
            readThread.start();

            // Main loop to send messages
            while (true) {
                String message = scanner.nextLine();
                out.println(message);
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting chat...");
                    break;
                }
            }

            // Ensure the read thread terminates gracefully
            readThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
