/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class CaptureBubblingOrder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50,50,50);
        circle.setFill(Color.CORAL);
        
        Rectangle rect = new Rectangle(100,100);
        rect.setFill(Color.TAN);
        
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rect);
        
        Scene scene = new Scene(root);
        
        EventHandler<MouseEvent> filter = e -> handleEvent("Capture",e);
        EventHandler<MouseEvent> handler = e -> handleEvent("Bubbling",e);
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void handleEvent(String phase, MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        
        double x = e.getX();
        double y = e.getY();
        
        System.out.println(phase + ": Type=" + type + ", Target=" + target + ", Source="+source + ", Location="+x+","+y);
    }
    
}
