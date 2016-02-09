/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class HBoxTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label nameLbl = new Label("Name:");
        
        TextField nameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        
        HBox root = new HBox(10);
        root.setSpacing(10);
        root.setPrefSize(400, 100);
       // root.setAlignment(Pos.CENTER);
        root.setHgrow(nameFld, Priority.ALWAYS);
        root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);
        Insets margin = new Insets(10,2,10,2);
        HBox.setMargin(nameLbl, margin);
        HBox.setMargin(okBtn, margin);
        root.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style:solid inside;" +
                      "-fx-border-width:2;" +
                      "-fx-border-insets:5;" +
                      "-fx-border-radius:5;" +
                      "-fx-border-color:blue;" 
                ); 
        
        
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
