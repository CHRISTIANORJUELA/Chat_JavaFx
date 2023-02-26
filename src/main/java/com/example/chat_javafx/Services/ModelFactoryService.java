package com.example.chat_javafx.Services;

import com.example.chat_javafx.models.ValuesForConnectWithServer;

import java.net.Socket;

public interface ModelFactoryService {
    void addParameters(ValuesForConnectWithServer valuesForConnectWithServer);
    ValuesForConnectWithServer getValuesForConnectWithServer();

}
