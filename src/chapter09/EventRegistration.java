/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class EventRegistration extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Circle circle = new Circle(100,100,50);
       circle.setFill(Color.CORAL);
       EventHandler<MouseEvent> mouseEventFilter = e-> {System.out.println("Mouse event filter has been called");};
       EventHandler<MouseEvent> mouseEventHandler = e->System.out.println("Mouse event handler has been called");

       circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
       // 2 su načina za registriranje event handlera
       //circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
       circle.setOnMouseClicked(mouseEventFilter);
        
        HBox root = new HBox();
        root.getChildren().add(circle);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.sizeToScene();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
