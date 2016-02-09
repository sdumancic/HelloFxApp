/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class HelloFxApp extends Application {
    
    private Stage _primaryStage;
    
    public HelloFxApp(){
        System.out.println("Constructor " + Thread.currentThread().getName());
        Employee e = new Employee("Sanjin",30000d);
        e.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e1) {
                System.out.println(e1.getPropertyName());
                System.out.println("OLD = " + e1.getOldValue());
                System.out.println("NEW = " + e1.getNewValue());
            }
        });
        System.out.println(e); 
        e.setSalary(35000d);
        e.setSalary(35000d);
        e.setName("SanjinD");
        System.out.println("----------------------------------");
        Book b = new Book("Harnessing Java","12345678",48.89);
        b.printDetails(b.priceProperty());
        b.printDetails(b.ISBNProperty());
        b.printDetails(b.titleProperty());
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        System.out.println("Start " + Thread.currentThread().getName());
        VBox vBox = new VBox(5);
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(e-> System.out.println("Hello World"));
        btn.setStyle("-fx-text-fill: blue;");

        Button btn2 = new Button();
        btn2.setText("Switch");
       
        vBox.getChildren().addAll(btn,btn2);
        Scene scene = new Scene(vBox, 300, 250);
        
       
        
        Button btn3 = new Button();
        btn3.setText("Return");
        btn3.setOnAction(e-> changeScene(scene));
        
       
        
        StackPane root2 = new StackPane();
        root2.getChildren().add(btn3);
        
        Scene scene2 = new Scene(root2,300,250);
        btn2.setOnAction(e-> changeScene(scene2));

        
        
        
        _primaryStage = primaryStage;
        
        _primaryStage.setTitle("Hello World!");
        _primaryStage.setScene(scene);
        _primaryStage = primaryStage;
        _primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main " + Thread.currentThread().getName());
        launch(args);
    }

    private void changeScene(Scene scene) {
        _primaryStage.setScene(scene);
    }
    
}
