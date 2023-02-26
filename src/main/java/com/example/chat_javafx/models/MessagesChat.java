package com.example.chat_javafx.models;

import java.util.Observable;

public class MessagesChat extends Observable {
    private String mensaje;

    public MessagesChat(){
    }

    public String getMensaje(){
        return mensaje;
    }

    /**
     *
     * @param mensaje lo vamos a utilizar para notificar a los observadores que el mensaje ha cambiado
     */

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
        this.setChanged();
        this.notifyObservers(this.getMensaje());
    }
}
