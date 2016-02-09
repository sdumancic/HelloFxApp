/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class CenteredCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Circle circle = new Circle();
        
        
        StackPane root = new StackPane();
        root.getChildren().add(circle);
        
        Scene scene = new Scene(root, 100, 100);
        
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        circle.radiusProperty().bind(Bindings.min(scene.widthProperty(),scene.heightProperty()).divide(2));
        
        
        primaryStage.setTitle("Bindings in java fx");
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
