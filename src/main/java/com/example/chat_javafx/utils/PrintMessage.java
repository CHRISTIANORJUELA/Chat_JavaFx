package com.example.chat_javafx.utils;

import javafx.scene.control.Alert;

public class PrintMessage {
    public static void redAlert(String messageHeader,String messageContent ){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(messageHeader);
        a.setContentText(messageContent);
        a.showAndWait();
    }
}
