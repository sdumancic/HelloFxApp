/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter16;

import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class JSCommandTest extends Application {
    
    /*
        When you use .getClass().getResource(fileName) it considers the location of the fileName is the same location of the of the calling class.
        When you use .getClass().getClassLoader().getResource(fileName) it considers the location of the fileName is the root - in other words bin folder.
    */
     private final String DEFAULT_HOME_PAGE = "html/jshandlers.html"; 
     
    
    
    @Override
    public void start(Stage primaryStage) {
         String homePageUrl = getDefaultHomePageUrl();
         BrowserPane root = new BrowserPane(homePageUrl, primaryStage);                
         Scene scene = new Scene(root);               
         primaryStage.setScene(scene);                
         primaryStage.show(); 
    }

    public String getDefaultHomePageUrl() {
        String pageUrl = "http://www.google.com"; 
        
        
        URL url = this.getClass().getClassLoader().getResource(DEFAULT_HOME_PAGE);   
        System.out.println(url);
        if (url == null) {                        
            System.out.println("Could not find " + DEFAULT_HOME_PAGE + " in CLASSPATH. " + "Using " + pageUrl + " as the default home page." );                }
         else {                        
            pageUrl = url.toExternalForm(); 
            System.out.println(pageUrl);
        }                
        return pageUrl;        
    } 

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
