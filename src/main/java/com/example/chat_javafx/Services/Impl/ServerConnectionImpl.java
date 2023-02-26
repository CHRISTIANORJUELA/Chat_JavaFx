package com.example.chat_javafx.Services.Impl;

import com.example.chat_javafx.models.MessagesChat;
import com.example.chat_javafx.utils.PrintMessage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * Esta clase hereda de Thread y implementa Observer
 */

public class ServerConnectionImpl extends Thread implements Observer {
    private Socket socket;
    private DataInputStream dataInput;
    private DataOutputStream dataOutPut;

    private MessagesChat menssagesChat;

    /**
     *
     * @param socket con la informacion del cliente conectado
     * @param messagesChat instancia de MessagesChat
     */
    public ServerConnectionImpl(Socket socket,MessagesChat messagesChat){
       this.socket = socket;
       this.menssagesChat = messagesChat;
       createFlush(socket);
    }

    /**
     *
     * @param socket para levantar la conexión directa entre el servidor y el nuevo cliente
     */
    public void createFlush(Socket socket){
        try {
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutPut = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            PrintMessage.redAlert("Atención","Hubo un fallo al crear el flujo hacia el cliente");
        }

    }

    /**
     * 1: Hilo que va entrar en un bucle infinito para escuchar cualquier mensaje que halla agregado un cliente
     * 2: con setMessage estamos Aplicando el patron observador
     */
    @Override
    public void run(){
        String mensajeReceived;
        boolean conected = true;
        menssagesChat.addObserver(this);
        while (conected){
            try {
                mensajeReceived = dataInput.readUTF();
                System.out.println("Numero de observadores "+menssagesChat.countObservers());
                System.out.println("El mensaje recibido es : "+mensajeReceived);
                menssagesChat.setMensaje(mensajeReceived);
            }catch (IOException e){
                conected = false;
            }catch (Exception e){
                conected = false;
                try {
                    dataInput.close();
                    dataOutPut.close();
                }catch (IOException ex2){
                    PrintMessage.redAlert("Error","No se pudo cerrar el flujo de datos");
                }
            }
        }

    }



    /**
     * This method is called whenever the observed object is changed. An
     * application calls an {@code Observable} object's
     * {@code notifyObservers} method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
      try {
          dataOutPut.writeUTF(arg.toString());
      }catch (IOException e){
          PrintMessage.redAlert("Error "," En comunicar el mensaje a la comunidad");
      }
    }
}
