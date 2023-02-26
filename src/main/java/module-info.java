module com.example.chat_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.example.chat_javafx to javafx.fxml;
    opens com.example.chat_javafx.controllers to javafx.fxml;
    exports com.example.chat_javafx;
    exports com.example.chat_javafx.controllers;

}