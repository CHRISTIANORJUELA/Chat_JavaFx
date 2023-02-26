package com.example.chat_javafx.controllers;

import com.example.chat_javafx.models.ValuesForConnectWithServer;
import com.example.chat_javafx.utils.ConectFrame;
import com.example.chat_javafx.utils.PrintMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class InitClientChatController {
    @FXML
    private AnchorPane AnchorPaneInformationServer;


    @FXML
    private TextField lbHost;

    @FXML
    private TextField lbPort;

    @FXML
    private TextField lbUser;

    @FXML
    private Label welcomeText;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    /**
     *
     * @param event capturamos el evento de los datos para conetar con el servidor
     * @throws IOException
     */
    @FXML
    void loadInformationServer(ActionEvent event) throws IOException {
        String user = lbUser.getText();
        String host = lbHost.getText();
        String port = lbPort.getText();
        if (user != null && host != null && port != null) {
            mfc.addParameters(new ValuesForConnectWithServer(user,host,port));
            ConectFrame.conectChat(event);
        } else {
            PrintMessage.redAlert("Atencion", "Debe rellenar todos los campos");
        }
    }
}
