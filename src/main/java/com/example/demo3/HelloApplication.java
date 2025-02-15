package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private LoginController loginController;
    @Override
    public void start(Stage stage) throws IOException {



        
        Class<LoginController> helloControllerClass = LoginController.class;
        URL helloControllerUrL= helloControllerClass.getResource(helloControllerClass.getSimpleName() + ".fxml");
        FXMLLoader loader = new FXMLLoader(helloControllerUrL);
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);

       // stage.setTitle("ACE DUMAGUETE DOCOTOR TICKET");
        stage.setScene(scene);
        stage.show();

        loginController = new LoginController();
        System.out.println("inside in userlogin");
    }

    public static void main(String[] args)
    {
        launch();
    }
}