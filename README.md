# MULTITHREADED-CHAT-APPLICATION_3
**COMPANY**: CODETECH IT SOLUTIONS
**NAME**: ANJALI T
**INTERN ID**: CT08IWY
**DOMAIN**: JAVA
**BATCH DURATION**: January 5th, 2025 to February 5th, 2025
**MENTOR NAME**: Neela Santhosh Kumar
#DESCRIPTION OF THE TASK: This project is a Multithreaded Client-Server Chat Application implemented in Java. It demonstrates the use of Sockets for network communication and Multithreading for handling multiple clients concurrently. The application facilitates real-time group chat where users can connect to a server, exchange messages, and leave the chat dynamically.
Tools and Resources Used:
Tools:
Programming Language: Java
IDE: Eclipse IDE
JDK Version: Java 8 or later (tested on Java 17)
Libraries/Classes Used:
Networking:
java.net.ServerSocket and java.net.Socket for establishing connections between the server and clients.
I/O Streams:
BufferedReader and InputStreamReader for reading input from clients.
PrintWriter for sending messages from the server to clients.
Multithreading:
Thread class for creating a separate thread for each client to ensure concurrent handling of messages.
Data Structures:
HashSet for managing connected client sockets.
HashMap for mapping client sockets to their usernames.
References:
Socket Programming in Java: Oracle Java Tutorials
Multithreading in Java: GeeksforGeeks Guide
General Java Tutorials: JavaPoint and TutorialsPoint.
How It Works
Server Functionality:
Starts a ServerSocket on port 45676.
Listens for client connections and creates a separate thread for each connected client.
Maintains a list of active clients and broadcasts messages to all clients.
Client Functionality:
Connects to the server using its IP (localhost) and port.
Prompts the user for their name and sends messages to the server.
Displays messages from other clients in real time.
Communication:
Messages are sent from the client to the server and broadcasted to all other connected clients.
Typing exit disconnects the client gracefully.

