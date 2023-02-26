package com.example.chat_javafx.controllers;

import com.example.chat_javafx.Services.Impl.Instances;
import com.example.chat_javafx.Services.ModelFactoryService;
import com.example.chat_javafx.models.ValuesForConnectWithServer;

public class ModelFactoryController implements ModelFactoryService {
    Instances instances;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        instances = new Instances();
    }

    //******************************* -------Funtions------ ****************************************

    public void addParameters(ValuesForConnectWithServer valuesForConnectWithServer){
        instances.getInitClient().addParameters(valuesForConnectWithServer);
    }

    public ValuesForConnectWithServer getValuesForConnectWithServer(){
        return instances.getInitClient().getValuesForConnectWithServer();
    }
}
