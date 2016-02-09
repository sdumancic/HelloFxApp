/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class KeyPressedReleased extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(nameLbl, nameFld);
        
        EventHandler<? extends KeyEvent> nameFldKeyPressedHandler = (KeyEvent event) -> {
            String type = event.getEventType().getName();
            KeyCode keyCode = ((KeyEvent)event).getCode();
            System.out.println(type + " key_code=" + keyCode.getName() + " Text=" + ((KeyEvent)event).getText());
            
            if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.F1){
                displayHelp();
                event.consume();
                    
            }
        };
        
        nameFld.setOnKeyPressed((EventHandler<? super KeyEvent>) nameFldKeyPressedHandler);
        
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

    private void displayHelp() {
        Text helpText = new Text("Please enter a name");
        HBox root = new HBox();
        root.setStyle("-fx-background-color: yellow;");
        root.getChildren().add(helpText);
        
        Scene scene = new Scene(root,200,100);
        Stage helpStage = new Stage();
        helpStage.setScene(scene);
        helpStage.setTitle("Help");
        helpStage.show();
    }
    
}
