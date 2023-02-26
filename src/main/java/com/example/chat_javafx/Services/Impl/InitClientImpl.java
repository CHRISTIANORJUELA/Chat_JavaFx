package com.example.chat_javafx.Services.Impl;

import com.example.chat_javafx.Services.InitClientService;
import com.example.chat_javafx.models.ValuesForConnectWithServer;

public class InitClientImpl implements InitClientService {
    ValuesForConnectWithServer valuesForConnectWithServer;

    /**
     *
     * @param valuesForConnectWithServer contiene el host , port , user
     */

    public void addParameters(ValuesForConnectWithServer valuesForConnectWithServer){
        this.valuesForConnectWithServer = valuesForConnectWithServer;
    }


    /**
     *
     * @return retornamos valuesForConnectWithServer
     */
    public ValuesForConnectWithServer getValuesForConnectWithServer() {
        return valuesForConnectWithServer;
    }

}
