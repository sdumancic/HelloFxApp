/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class NodeSizeSentinelValue extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setPrefWidth(100);
        
        VBox root = new VBox();
        root.getChildren().addAll(okBtn, cancelBtn);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("okBtn.getPrefWidth " + okBtn.getPrefWidth());
        System.out.println("okBtn.getMinWidth " + okBtn.getMinWidth());
        System.out.println("okBtn.getMaxWidth " + okBtn.getMaxWidth());
        
        
        
        System.out.println("cancelBtn.getPrefWidth " + cancelBtn.getPrefWidth());
        System.out.println("cancelBtn.getMinWidth " + cancelBtn.getMinWidth());
        System.out.println("cancelBtn.getMaxWidth " + cancelBtn.getMaxWidth());
        
        double prefWidth = okBtn.prefWidth(-1);
        double prefHeight = okBtn.prefHeight(-1);
        System.out.println(okBtn.getContentBias() +"->" + prefWidth + "," + prefHeight);
        System.out.println(okBtn.getWidth() +"," +okBtn.getHeight());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
