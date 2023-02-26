package com.example.chat_javafx;

import com.example.chat_javafx.Services.Impl.ServerConnectionImpl;
import com.example.chat_javafx.models.MessagesChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerChat {
    /**
     * Servidor Para el Chat
     * @author Christián Felippe Orjuela Forero
     * 1: Arranca el hilo del metodo main y primero levantamos la clase del servidor
     * 2: definimos el puerto con el maximo de conexiones
     * 3: inicializamos el ServerSocket y Socket
     * 4: levantamos el Servidor
     * 5: El hilo principal entra en un bucle infininito para esperar conexiones que vengan departe del cliente
     * 6: Si hay una conexion se envia el socket que se conecto y clase messagesChat , se levanta el flujo de datos entre el servidor y el socket que se conecto
     * 7: por ultimo se crea un hilo para que el programa principal repita el proceso
     */
    public static void main(String[] args) throws IOException {
        int port = 5055;
        int maxConections = 10;
        ServerSocket servidor = null;
        Socket socket = null;
        MessagesChat messagesChat = new MessagesChat();
        try {
            servidor = new ServerSocket(port, maxConections);
            while (true) {
                System.out.println("Esperando clientes : ");
                socket = servidor.accept();
                System.out.println("Conectado con el host "+socket.getInetAddress().getHostAddress()+" en el puerto : "+socket.getPort());
                ServerConnectionImpl serverConnection = new ServerConnectionImpl(socket,messagesChat);
                serverConnection.start();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally{
            try {
                if (socket != null) {
                    socket.close();
                }
                if (servidor != null) {
                    servidor.close();
                }
            } catch (IOException ex2) {
                System.out.println(ex2);
            }
        }
    }
    }
