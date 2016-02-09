/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sanjin
 */
public class DraggingStage extends Application {
    
    private Stage stage;
    private Double dragOffsetX;
    private Double dragOffsetY;
    
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        
        Label msgLabel = new Label("Press the mouse button and drag");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e-> stage.close());
        
        VBox root = new VBox();
        root.getChildren().addAll(msgLabel,closeButton);
        
        Scene scene = new Scene(root, 300, 250);
        scene.setOnMousePressed(e-> handleMousePressed(e));
        scene.setOnMouseDragged(e-> handleMouseDragged(e));
        
        primaryStage.setTitle("Moving a stage");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void handleMousePressed(MouseEvent e) {
        System.out.println("stage.getX()="+stage.getX() + " e.getScreenX()="+e.getScreenX());
        this.dragOffsetX = e.getScreenX() - stage.getX();
        this.dragOffsetY = e.getScreenY() - stage.getY();
    }

    private void handleMouseDragged(MouseEvent e) {
        stage.setX(e.getScreenX()-this.dragOffsetX);
        stage.setY(e.getScreenY()-this.dragOffsetY);
    }
    
}
