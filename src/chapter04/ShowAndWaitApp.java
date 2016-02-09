/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class ShowAndWaitApp extends Application {
    
    protected static int counter = 0;
    protected Stage lastOpenStage;
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        
        Button openButton = new Button("Open");
        openButton.setOnAction(e-> open(++counter));
        
        root.getChildren().add(openButton);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("The primary stage");
        primaryStage.setScene(scene);
        primaryStage.show();
        this.lastOpenStage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void open(int stageNumber) {
        Stage stage = new Stage();
        stage.setTitle("#" + stageNumber);
        Button sayHelloButton = new Button("Say hello");
        sayHelloButton.setOnAction(e->System.out.println("Hello from #" + stageNumber));
        Button openButton = new Button("Open");
        openButton.setOnAction(e->open(++counter));
        
        VBox root = new VBox();
        root.getChildren().addAll(sayHelloButton,openButton);
        Scene scene = new Scene(root,200,200);
        stage.setScene(scene);
        stage.setX(this.lastOpenStage.getX()+50);
        stage.setY(this.lastOpenStage.getY()+50);
        this.lastOpenStage = stage;
        System.out.println("Before stage.showAndWait() " + stageNumber);
        stage.showAndWait();
        System.out.println("After stage.showAndWait() " + stageNumber);
    }
    
}
