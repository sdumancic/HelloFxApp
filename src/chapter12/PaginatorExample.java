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
import javafx.scene.control.Pagination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class PaginatorExample extends Application {
    private static final int PAGE_COUNT = 5;
            
    @Override
    public void start(Stage primaryStage) {
        Pagination pagination = new Pagination(PAGE_COUNT);
        pagination.setPageFactory(this::getPage);
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        
        VBox root = new VBox(pagination);
        
        Scene scene = new Scene(root,400,400);
         scene.getStylesheets().add("resources/css/darktheme.css");
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Label getPage(int pageIndex){
        Label content = null;
        
        if (pageIndex >= 0 && pageIndex < PAGE_COUNT){
            content = new Label("Content for page " + (pageIndex+1));
        }
        
        return content;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
