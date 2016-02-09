/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Sanjin
 */
public class StageModalityApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        
        Button ownedNoneButton = new Button("Owned None");
        ownedNoneButton.setOnAction(e-> showDialog(primaryStage, Modality.NONE));
        
        Button nonOwnedNoneButton = new Button("Non-Owned None");
        nonOwnedNoneButton.setOnAction(e-> showDialog(null, Modality.NONE));
        
        Button ownedWinButton = new Button("Owned Window Modal");
        ownedWinButton.setOnAction(e-> showDialog(primaryStage, Modality.WINDOW_MODAL));
        
        Button nonOwnedWinButton = new Button("Non-Owned Window Modal");
        nonOwnedWinButton.setOnAction(e-> showDialog(null, Modality.WINDOW_MODAL));
        
        Button ownedAppButton = new Button("Owned Application Modal");
        ownedAppButton.setOnAction(e-> showDialog(primaryStage, Modality.APPLICATION_MODAL));
        
        Button nonOwnedAppButton = new Button("Non-Owned Application Modal");
        nonOwnedAppButton.setOnAction(e-> showDialog(null, Modality.APPLICATION_MODAL));
        
        VBox root = new VBox();
        root.getChildren().addAll(ownedNoneButton,nonOwnedNoneButton,ownedWinButton,nonOwnedWinButton,ownedAppButton,nonOwnedAppButton);
        
        Scene scene = new Scene(root, 300,200);
        primaryStage.setScene(scene);
       /* primaryStage.setX(visualBounds.getMinX());
        primaryStage.setY();
        primaryStage.setWidth(visualBounds.getWidth());
        primaryStage.setHeight(visualBounds.getHeight());*/
        
        //primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void showDialog(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.setOpacity(0.8);
        stage.initModality(modality);
        Label modalityLabel = new Label(modality.toString());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e->stage.close());
        VBox root = new VBox();
        root.getChildren().addAll(modalityLabel,closeButton);
        Scene scene = new Scene(root,200,100);
        stage.setScene(scene);
        stage.setTitle("A dialog box");
        stage.show();
    }
    
}
