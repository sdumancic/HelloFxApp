/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

import javafx.application.Application;
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
public class ButtonStyleText extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");
        
        HBox root = new HBox();
        root.getChildren().addAll(yesBtn,noBtn,cancelBtn);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("resources/css/buttonStyles.css");
        
        primaryStage.setTitle("Styling buttons");
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
