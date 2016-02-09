/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter05;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 *
 * @author Sanjin
 */
public class RunLaterApp extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Init " + Thread.currentThread().getName());
        Runnable task = () -> {
            System.out.println("Running the task on thread " + Thread.currentThread().getName());
        };
        Platform.runLater(task);
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println("" + Platform.isSupported(ConditionalFeature.SCENE3D));
        getHostServices().showDocument("www.bug.hr");
        primaryStage.setScene(new Scene(new Group(),400,100));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
