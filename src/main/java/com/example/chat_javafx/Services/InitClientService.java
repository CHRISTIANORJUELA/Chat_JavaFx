package com.example.chat_javafx.Services;

import com.example.chat_javafx.models.ValuesForConnectWithServer;

import java.net.Socket;

public interface InitClientService {
    void addParameters(ValuesForConnectWithServer valuesForConnectWithServer);
    ValuesForConnectWithServer getValuesForConnectWithServer();
}
