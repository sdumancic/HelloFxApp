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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class BorderPaneTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Node top = null;
        Node left = null;
        
        VBox center = getCenter();
        
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        
        okBtn.setMaxWidth(Double.MAX_VALUE);
        VBox right = new VBox(okBtn, cancelBtn);
        right.setStyle("-fx-padding:10;");
        
        Label statusLbl = new Label("Status: Ready");
        HBox bottom = new HBox(statusLbl);
        BorderPane.setMargin(bottom, new Insets(10,0,0,0));
        bottom.setStyle("-fx-background-color: lavender;" + 
                        "-fx-font-size: 7pt;" +
                        "-fx-padding: 10 0 0 0;" ); 
        
        BorderPane root = new BorderPane(center, top, right, bottom, left);
        root.setStyle("-fx-background-color: lightgray;");
        
        
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

    private VBox getCenter() {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        HBox.setHgrow(nameFld, Priority.ALWAYS);
        HBox nameFields = new HBox(nameLbl, nameFld);
        
        Label descLbl = new Label("Description");
        TextArea descText = new TextArea();
        descText.setPrefColumnCount(20);
        descText.setPrefRowCount(5);
        VBox.setVgrow(descText, Priority.ALWAYS);
        
        VBox center = new VBox(nameFields, descLbl, descText);
        return center;
    }
    
}
