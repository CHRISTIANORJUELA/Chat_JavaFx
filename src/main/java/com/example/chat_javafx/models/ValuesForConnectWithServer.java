package com.example.chat_javafx.models;

public class ValuesForConnectWithServer {
    private String user;
    private String host;
    private String port;

    /**
     *
     * @param user
     * @param host
     * @param port
     *
     * parametros que usamos para formar un objeto
     */

    public ValuesForConnectWithServer(String user, String host, String port) {
        this.user = user;
        this.host = host;
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
