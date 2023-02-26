package com.example.chat_javafx.Services.Impl;

public class Instances {
    InitClientImpl initClient;
    public Instances(){
        initClient = new InitClientImpl();
    }

    public InitClientImpl getInitClient() {
        return initClient;
    }
}

