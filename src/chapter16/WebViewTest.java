/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter16;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class WebViewTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       WebView webView = new WebView();
        webView.getEngine().setPromptHandler(JSHandlers.getPromptHandler());
         webView.getEngine().setCreatePopupHandler(JSHandlers.getPopupHandler());        
         webView.getEngine().setOnAlert(JSHandlers::alertHandler);                
         webView.getEngine().setConfirmHandler(JSHandlers.getConfirmHandler()); 
       WebEngine webEngine = webView.getEngine();
       MenuButton options = new WebOptionsMenu(webView);
       
       webEngine.titleProperty().addListener((ObservableValue<? extends String> p, String oldTitle, String newTitle) -> {primaryStage.setTitle(newTitle);});
       //webEngine.load("http://www.google.com");
       
       webEngine.load(this.getClass().getClassLoader().getResource("html/jshandlers.html").toExternalForm());
        
       VBox root = new VBox(options,webView);
        
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
