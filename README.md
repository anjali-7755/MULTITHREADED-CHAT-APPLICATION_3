# MULTITHREADED-CHAT-APPLICATION_3
#### **COMPANY**: CODETECH IT SOLUTIONS
#### **NAME**: ANJALI T
#### **INTERN ID**: CT08IWY       
#### **DOMAIN**: JAVA
#### **BATCH DURATION**: January 5th, 2025 to February 5th, 2025
#### **MENTOR NAME**: Neela Santhosh Kumar
#### DESCRIPTION OF THE TASK:  This project is a multithreaded chat application built in Java that enables multiple users to communicate simultaneously over a network. It demonstrates the use of Java's networking and multithreading capabilities, specifically using Sockets and Threads, to create a client-server architecture.
The application consists of two components:
1.Server: Manages all client connections, broadcasts messages to connected clients, and handles client join/exit events.
2.Client: Allows users to send and receive messages interactively in real-time.
### **Tools Used**:
Java Development Kit (JDK): Version used is JDK 17.It Provides the core libraries (java.net, java.io) required for implementing sockets and multithreading.
Eclipse IDE: Used for writing, debugging, and testing the Java code.
GitHub: The project is version-controlled and hosted on GitHub for easy access and collaboration.
### **Libraries Used**:
java.net.Socket and java.net.ServerSocket: For establishing client-server connections.
java.io.PrintWriter and java.io.BufferedReader: Enable efficient communication by sending and receiving text messages.
java.util.Scanner: Captures user input on the client-side interactively.
java.util.Collections: Ensures thread-safe operations while managing client connections.
### **Features**:
Multithreading: Each client connection is handled in a separate thread to support multiple users simultaneously.
Broadcast Messaging: Messages sent by one client are relayed to all other connected clients in real-time.
Interactive Input/Output: Clients can type messages and see updates about other clients joining or exiting the chat.
Graceful Exit Handling: Clients can exit by typing exit, and the server notifies all remaining clients about the disconnection.
Persistent Server: The server remains active and continues handling new connections even if clients leave.
### **Program Workflow**:
Server Initialization: The server listens on a specific port and waits for client connections.
Client Connection: Each client connects to the server and provides a name.The server announces the new connection to all clients.
Messaging: Clients send and receive messages in real-time.All messages are prefixed with the sender’s name for clarity.
Client Exit: Clients can type exit to leave the chat.The server removes the client from the active connections list and informs other clients.

## OUTPUT OF THE TASK:
![Screenshot 2025-01-11 141341](https://github.com/user-attachments/assets/696c0b6d-d337-412a-b37b-446a7452a8bb)
![Screenshot 2025-01-11 141826](https://github.com/user-attachments/assets/f4061131-edb1-44f9-ae4b-7cfb0f01691c)

