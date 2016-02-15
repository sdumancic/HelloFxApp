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
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class HTMLEditorTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HTMLEditor editor = new HTMLEditor();
        editor.setPrefSize(600,300);
        
        TextArea html = new TextArea();
        html.setPrefSize(600,300);
        html.setStyle("-fx-font-size:10pt; -fx-font-family: \"Courier New\";");
        
        VBox root = new VBox(editor, html);
        root.setSpacing(10);
        
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
