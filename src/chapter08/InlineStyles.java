/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class InlineStyles extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");
        
        Button openBtn = new Button("OPen");
        Button saveBtn = new Button("Save");
        Button closeBtn = new Button("Close");
        
        VBox vb1 = new VBox();
        vb1.setPadding(new Insets(10,10,10,10));
        vb1.getChildren().addAll(yesBtn, noBtn, cancelBtn);
        
        VBox vb2 = new VBox();
        vb2.setPadding(new Insets(10,10,10,10));
        vb2.getChildren().addAll(openBtn, saveBtn, closeBtn);
        
        vb1.setStyle("-fx-border-width:4.0;-fx-border-color:blue;");
        vb2.setStyle("-fx-border-width:4.0;-fx-border-color:blue;");
        
        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(10,10,10,10));
        root.getChildren().addAll(vb1,vb2);
        
        root.setStyle("-fx-border-width:2.0;-fx-border-color:navy;");
        
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
