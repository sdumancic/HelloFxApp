/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class ScreenDetailsApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ObservableList<Screen> screenList = Screen.getScreens();
        System.out.println("ScreenList size=" + screenList.size());
        for (Screen screen:screenList){
            print(screen);
        }
        primaryStage.setTitle("Stage with a Button");
        Group root = new Group();
        root.getChildren().add(new Button("Hello"));
        Scene scene = new Scene(root,300,100);
        scene.setFill(Color.RED);
        
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.show();
        primaryStage.centerOnScreen();
        //Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void print(Screen screen) {
        System.out.println("DPI=" + screen.getDpi());
        Rectangle2D bounds = screen.getBounds();
        System.out.println("Bounds="+bounds);
        Rectangle2D visualBounds = screen.getVisualBounds();
        System.out.println("VisualBounds="+visualBounds);
    }
    
}
