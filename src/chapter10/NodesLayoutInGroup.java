/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class NodesLayoutInGroup extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button okBtn = new Button("Ok");
        Button cancelBtn = new Button("Cancel");
        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);
        
        NumberBinding layoutXBinding = okBtn.layoutXProperty().add(okBtn.widthProperty().add(10));
        cancelBtn.layoutXProperty().bind(layoutXBinding);
        cancelBtn.layoutYProperty().bind(okBtn.layoutYProperty());
        
        Group root = new Group();
        root.getChildren().addAll(okBtn,cancelBtn);
        
        root.setEffect(new DropShadow());
        root.setOpacity(0.8d);
        root.setRotate(10);
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
