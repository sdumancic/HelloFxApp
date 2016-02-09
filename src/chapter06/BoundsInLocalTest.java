/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class BoundsInLocalTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button b1 = new Button("Ok");
        b1.setEffect(new DropShadow());
        b1.setLayoutX(20);
        b1.setLayoutY(20);
        
        Button b2 = new Button("Cancel");
        b2.setLayoutX(50);
        b2.setLayoutY(50);
        
        Group parent = new Group();
        parent.getChildren().addAll(b1,b2);
        System.out.println(b1.isResizable());
        
        Scene scene = new Scene(parent, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        System.out.println("layoutBounds="+b1.layoutBoundsProperty().get());
        System.out.println("boundsInLocal="+b1.boundsInLocalProperty().get());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
