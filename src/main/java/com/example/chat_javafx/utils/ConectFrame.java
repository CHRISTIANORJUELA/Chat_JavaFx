package com.example.chat_javafx.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ConectFrame {
    private static Stage stage;
    private static Scene scene;
    public static void conectChat(ActionEvent e) throws IOException {

        URL url = new File("src/main/resources/com/example/chat_javafx/chatClient.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
}
