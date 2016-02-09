/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

import java.awt.BorderLayout;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class StyleClassTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label nameLbl = new Label("Name:");
        TextField nameTf = new TextField();
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e->Platform.exit());
        closeBtn.setId("closeButton");
        
        HBox root = new HBox();
        root.getChildren().addAll(nameLbl,nameTf,closeBtn);
        
        //Za HBox kao i Region, Pane, VBox, ne postoji defaultni style class name hbox, dok za Button postoji -> button
        // Zato treba explicitno pozvati getStyleClass
        root.getStyleClass().add("hbox"); 
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("resources/css/styleclass.css");
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ObservableList<String> styleClassList = root.getStyleClass();
        if (!styleClassList.isEmpty()){
            styleClassList.stream().forEach((styleClassName) -> {  System.out.println(styleClassName);   });
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
