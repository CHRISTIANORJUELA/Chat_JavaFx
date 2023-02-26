package com.example.chat_javafx.controllers;

import com.example.chat_javafx.Services.Impl.ClientConnectionImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientChatController implements Initializable {
    @FXML
    private TextArea textArea;

    @FXML
    private TextField textFieldMessage;


    @FXML
    public Button btnSend;
    ClientConnectionImpl clientConnection;

    ModelFactoryController mfc = ModelFactoryController.getInstance();


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.setEditable(false);
        clientConnection = new ClientConnectionImpl(mfc.getValuesForConnectWithServer().getHost(),Integer.parseInt(mfc.getValuesForConnectWithServer().getPort()),textArea);
    }

    /**
     * @param event
     *
     * Parametro que usarmos cuando capturemos el evento de enviar el mensake
     */
    @FXML
    void sendMessage(ActionEvent event) {
        clientConnection.metodo(mfc.getValuesForConnectWithServer().getUser(),textFieldMessage.getText());
    }
}
