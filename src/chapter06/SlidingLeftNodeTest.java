/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class SlidingLeftNodeTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");
        Button visibleButton = new Button("Make invisible");
        
        
        visibleButton.setOnAction(e->b2.setVisible(!b2.isVisible()));
        visibleButton.textProperty().bind(new When(b2.visibleProperty()).then("Make invisible").otherwise("Make visible"));
        b2.managedProperty().bind(b2.visibleProperty());
        
        HBox root = new HBox();
        root.getChildren().addAll(visibleButton,b1,b2,b3);
        
        Scene scene = new Scene(root, 300, 250);
        
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
