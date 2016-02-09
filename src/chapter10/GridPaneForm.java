/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class GridPaneForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        
        Label descLbl = new Label("Description");
        TextArea descText = new TextArea();
        descText.setPrefColumnCount(20);
        descText.setPrefRowCount(5);
        
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button ("Cancel");
        
        Label statusLbl = new Label("Status: Ready");
        statusLbl.setStyle("-fx-background-color: lavender; "+
                           "-fx-font-size: 7;"
                         + "-fx-padding: 10 0 0 0 ");
        
        GridPane root = new GridPane();
        //root.setGridLinesVisible(true);
        root.setStyle("-fx-background-color: lightgray;");
        root.add(nameLbl,0,0,1,1);
        root.add(nameFld,1,0,1,1);
        root.add(descLbl, 0,1,3,1);
        root.add(descText,0,2,2,1);
        root.add(okBtn, 2,0,1,1);
        root.add(cancelBtn, 2,1,1,1);
        root.add(statusLbl, 0,3,GridPane.REMAINING,1);
        GridPane.setHgrow(nameFld, Priority.ALWAYS);
        GridPane.setVgrow(descText, Priority.ALWAYS);
        statusLbl.setMaxWidth(Double.MAX_VALUE);
        
        okBtn.setMaxWidth(Double.MAX_VALUE);
        
        root.setHgap(10);
        
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
