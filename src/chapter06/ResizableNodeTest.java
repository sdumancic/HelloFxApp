/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class ResizableNodeTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("A big button");
        
        Rectangle rect = new Rectangle(100,50);
        rect.setFill(Color.WHITE);
        rect.setStrokeWidth(1);
        rect.setStroke(Color.BLACK);
        
        HBox root = new HBox();
        root.setSpacing(20);
        root.getChildren().addAll(btn,rect);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("btn.isResizable()="+btn.isResizable());
        System.out.println("rect.isResizable()="+rect.isResizable());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
