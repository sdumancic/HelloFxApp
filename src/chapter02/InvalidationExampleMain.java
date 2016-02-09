/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
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
public class InvalidationExampleMain extends Application {
    
    IntegerProperty ip = new SimpleIntegerProperty(100);
    
    @Override
    public void start(Stage primaryStage) {
        
        ip.addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                System.out.println(observable.getClass().getSimpleName());
            }
        });
        
        /* by using anonymous block and generics*/
        ip.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {
                System.out.println("oldValue="+oldValue + " newValue="+newValue);
            }

        });
        
        /* by using lambda*/
        ip.addListener(InvalidationExampleMain::xx);
        
        /* by explicitely instantiation of class ChangeListener and WeakChangeListener*/
        ChangeListener<Number> listener = InvalidationExampleMain::xx;
        WeakChangeListener<Number> wListener = new WeakChangeListener<>(listener);
        ip.addListener(wListener);
        
        
        ip.set(200);
        ip.set(200);
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.close();
    }

    public static void xx(ObservableValue<? extends Number> observable,Number oldValue, Number newValue){
        System.out.println("xx");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
