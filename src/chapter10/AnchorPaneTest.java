package chapter10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class AnchorPaneTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button topLeft = new Button("Top Left");
        AnchorPane.setTopAnchor(topLeft, 10.0);
        AnchorPane.setLeftAnchor(topLeft, 10.0);
        
        Button bottomRight = new Button("Bottom Right");
        AnchorPane.setBottomAnchor(bottomRight, 10.0);
        AnchorPane.setRightAnchor(bottomRight, 10.0);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(topLeft, bottomRight);
        
        Scene scene = new Scene(root);
        
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
