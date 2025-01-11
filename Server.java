package chatapp;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 45676;
    private static Set<Socket> clientSockets = new HashSet<>();
    private static Map<Socket, String> clientNames = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat server started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                synchronized (clientSockets) {
                    clientSockets.add(clientSocket);
                }

                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                out.println("Enter your name:");
                clientName = in.readLine();
                synchronized (clientNames) {
                    clientNames.put(clientSocket, clientName);
                }
                broadcastMessage("Server: " + clientName + " has joined the chat!");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                    broadcastMessage(clientName + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    synchronized (clientSockets) {
                        clientSockets.remove(clientSocket);
                    }
                    synchronized (clientNames) {
                        broadcastMessage("Server: " + clientName + " has left the chat.");
                        clientNames.remove(clientSocket);
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message) {
            synchronized (clientSockets) {
                for (Socket socket : clientSockets) {
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
