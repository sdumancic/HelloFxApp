/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafx.stage.StageStyle.DECORATED;
import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNDECORATED;
import static javafx.stage.StageStyle.UNIFIED;
import static javafx.stage.StageStyle.UTILITY;

/**
 *
 * @author Sanjin
 */
public class StageStyleApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label styleLabel = new Label("Stage Style");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e->primaryStage.close());
        
        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, closeButton);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
       // this.show(primaryStage, styleLabel, DECORATED);
        this.show(primaryStage, styleLabel, UNDECORATED);
       // this.show(primaryStage, styleLabel, TRANSPARENT);
       // this.show(primaryStage, styleLabel, UNIFIED);
       // this.show(primaryStage, styleLabel, UTILITY);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void show(Stage primaryStage, Label styleLabel, StageStyle stageStyle) {
        styleLabel.setText(stageStyle.toString());
        primaryStage.initStyle(stageStyle);
        if (stageStyle == StageStyle.TRANSPARENT){
            primaryStage.getScene().setFill(null);
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: transparent");
        } else if (stageStyle == StageStyle.UNIFIED)
            primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.show();
    }
    
}

