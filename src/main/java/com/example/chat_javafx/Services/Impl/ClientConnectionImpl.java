package com.example.chat_javafx.Services.Impl;

import com.example.chat_javafx.Services.ClientConnectionService;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import com.example.chat_javafx.models.MessagesChat;
import javafx.scene.control.TextArea;

public class ClientConnectionImpl implements ClientConnectionService {
    private Socket socket;
    private String message;
    private String user;
    private DataOutputStream dataOutput;

    private TextArea textArea;

    /**
     *
     * @param host este valor nos va a servir para levantar el host
     * @param port numero del puerto del servidor
     * @param textArea cuadro en donde se van a imprimir los mensajes
     */
    public ClientConnectionImpl(String host, int port, TextArea textArea){
        try {
            System.out.println(host);
            System.out.println(port);
            this.socket = new Socket(host,port);
            this.textArea = textArea;
            CompletableFuture.runAsync(this::listenChanges);
        }catch (IOException ex){
            System.out.println("ee");
        }
    }

    /**
     * 1: definimos el flujo de entrada con el servidor
     * 2: levantamos la conexion
     * 3: En un bucle infinito intentamos escuchar los cambios que ocurren cuando otros clientes envian un mensaje
     * (Importante: cuando escribimos nosotros mismos enviamos un mensaje este pasa porque el mensaje primero va al servidor y este lo
     * redistribuye a todos sus clientes incluyendo al que envio el mensaje
     * 4: Si hay un mensaje nuevo este lo apilamos en el textArea
     * )
     */
    private void listenChanges() {
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(getSocket().getInputStream());
        } catch (IOException ex) {
            System.out.println("Exeption en conectar con el socket ");
        } catch (NullPointerException ex) {
            System.out.println("Creacion de flujo de datos Incorrecto");
        }
        boolean conectado = true;
        MessagesChat messagesChat = new MessagesChat();
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                System.out.println("El mensaje captado en TextArea : "+mensaje);
                textArea.appendText(  mensaje + System.lineSeparator());
            } catch (IOException ex) {
                System.out.println(ex);
                conectado = false;
            } catch (NullPointerException ex) {
                System.out.println(ex);
            }
        }
    }
    /**
     *
     * @param user nombre de su usuario que digitamos al comienzo del programa
     * @param text es el mensaje que queremos enviar a todos los clientes
     * @funtion executable es la que vamos a utilizar para mandar el mensaje
     */
    public void metodo(String user, String text) {
        this.message = text;
        this.user = user;
        try {
            this.dataOutput = new DataOutputStream(socket.getOutputStream());
            System.out.println("Exito en dataoutput");
            executable();
        }catch (Exception e){
            System.out.println("ERROR en metodo");
        }
    }

    /**
     * 1:Por el flujo de salida dataOutPut sacamos el mensaje que queremos que escuchen los otros clientes
     */
    public void executable(){
        try {
            dataOutput.writeUTF(getUser()+":"+getMessage());
        }catch (IOException e){
            System.out.println("Error en conectar");
        }

    }

    /**
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message  para actualizar mensaje
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * @Override sobreEscribe el metodo de la interfaz ClientConnectionService
     * @return socket
     */

    public Socket getSocket() {
        return socket;
    }

    public String getUser() {
        return user;
    }
}


