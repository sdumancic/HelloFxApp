/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class SplitPaneTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextArea desc1 = new TextArea();
        desc1.setPrefColumnCount(10);
        desc1.setPrefRowCount(4);
        
        TextArea desc2 = new TextArea();
        desc2.setPrefColumnCount(10);
        desc2.setPrefRowCount(4);
        
        VBox vb1 = new VBox(new Label("Description1"),desc1);
        VBox vb2 = new VBox(new Label("Description2"),desc2);
        
        SplitPane sp = new SplitPane();
        sp.getItems().addAll(vb1,vb2);
        
        HBox root = new HBox(sp);
        root.setSpacing(10);
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("resources/css/darktheme.css");
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
