package edu.ijse.smart_school;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInit extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Smart_School");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


