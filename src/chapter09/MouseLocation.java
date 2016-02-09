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
public class MouseLocation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50,50,50);
        circle.setFill(Color.CORAL);
        
        Rectangle rect = new Rectangle(100,100);
        rect.setFill(Color.TAN);
        
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle,rect);
        
        Scene scene = new Scene(root, 300, 250);
        
        EventHandler<MouseEvent> mouseMoveHandler = e-> {
            System.out.println("Mouse move handler has been called, source="+  e.getSource().toString() + " target="+e.getTarget());
            double sourceX = e.getX();
            double sourceY = e.getY();
            double sceneX = e.getSceneX();
            double sceneY = e.getSceneY();
            double screenX = e.getScreenX();
            double screenY = e.getScreenY();
            System.out.println("Node(x,y)="+sourceX+","+sourceY + " Scene(x,y)=" + sceneX + "," + sceneY + " Screen(x,y)=" + screenX + "," + screenY);
        };
        
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseMoveHandler);
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
    
}
