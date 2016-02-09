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
import javafx.scene.control.CheckBox;
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
public class ConsumingEvents extends Application {
    
    private CheckBox consumeEventCbx = new CheckBox("Consume Mouse Click at Circle");
    
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50,50,50);
        circle.setFill(Color.CORAL);
        
        Rectangle rect = new Rectangle(100,100);
        rect.setFill(Color.TAN);
        
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rect,consumeEventCbx);
        
        Scene scene = new Scene(root);
        
        
        EventHandler<MouseEvent> handler = e -> handleEvent(e);
        EventHandler<MouseEvent> circleMeHandler = e -> handleEventForCircle(e);
        
        
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, circleMeHandler);
        
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

    private void handleEvent(MouseEvent e) {
       print (e);
    }

    private void handleEventForCircle(MouseEvent e) {
        print (e);
        if (consumeEventCbx.isSelected())
            e.consume();
    }

    private void print(MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        
        double x = e.getX();
        double y = e.getY();
        
         System.out.println(": Type=" + type + ", Target=" + target + ", Source="+source + ", Location="+x+","+y);
    }
    
}
