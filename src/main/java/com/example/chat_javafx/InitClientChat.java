package com.example.chat_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
* Esta clase es la que lanza el programa de parte del cliente y la primera ventana que nos mostrara sera Un formulario para conectar con el servidor
*  @author Christián Felippe Orjuela Forero
 */
public class InitClientChat extends Application {

    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("initClientChat.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
