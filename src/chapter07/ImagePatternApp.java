/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter07;

import java.net.URL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class ImagePatternApp extends Application {
    private Image img;

    @Override
    public void init() throws Exception {
        super.init(); 
        final String IMAGE_PATH = "chapter07/images/blue-rounded-rectangle.png";
        URL url = this.getClass().getClassLoader().getResource(IMAGE_PATH);
        if (url == null){
            System.out.println(IMAGE_PATH + " file not found on classpath");
            Platform.exit();
            return;
        }
        img = new Image(url.toExternalForm());
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        ImagePattern p1 = new ImagePattern(img,0,0,0.25,0.25,true);
        Rectangle r1 = new Rectangle(200,100);
        r1.setFill(p1);
        
        ImagePattern p2 = new ImagePattern(img,0,0,0.5,0.5,true);
        Rectangle r2 = new Rectangle(200,100);
        r2.setFill(p2);
        
        ImagePattern p3 = new ImagePattern(img,40,15,20,20,false);
        Rectangle r3 = new Rectangle(200,100);
        r3.setFill(p3);
        
        ImagePattern p4 = new ImagePattern(img,0,0,0.1,0.1,true);
        Circle c = new Circle(100,100,50);
        c.setFill(p4);
        
        HBox root = new HBox();
        root.getChildren().addAll(r1,r2,r3,c);
        
        Scene scene = new Scene(root, 900, 350);
        
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
