/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class CoordinateConversion extends Application {
    
    private Circle marker;
    
    @Override
    public void start(Stage primaryStage) {
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField salary = new TextField();
        
        marker = new Circle(5);
        marker.setFill(Color.RED);
        marker.setManaged(false);
        marker.setMouseTransparent(true);
        
        HBox hb1 = new HBox(5);
        hb1.setPadding(new Insets(5,5,5,5));
        HBox hb2 = new HBox(5);
        hb2.setPadding(new Insets(5,5,5,5));
        HBox hb3 = new HBox(5);
        hb3.setPadding(new Insets(5,5,5,5));
        
        
        hb1.getChildren().addAll(new Label("First name:"), fName);
        hb2.getChildren().addAll(new Label("Last name:"), lName);
        hb3.getChildren().addAll(new Label("Salary:"), salary);

        
        VBox root = new VBox();
        root.getChildren().addAll(hb1,hb2,hb3,marker);
        
        Scene scene = new Scene(root);
        
        scene.focusOwnerProperty().addListener((prop, oldNode, newNode) -> placeMarker(newNode));
        
        primaryStage.setTitle("Coordindate space transformation!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void placeMarker(Node newNode) {
        double nodeMinX = newNode.getLayoutBounds().getMinX();
        double nodeMinY = newNode.getLayoutBounds().getMinY();
        Point2D nodeInScene = newNode.localToScene(nodeMinX, nodeMinY);
        System.out.println(nodeInScene.toString());
        Point2D nodeInMarkerLocal =  marker.sceneToLocal(nodeInScene);
        System.out.println(nodeInMarkerLocal.toString());
        Point2D nodeInMarkerParent =  marker.localToParent(nodeInMarkerLocal);
        System.out.println(nodeInMarkerParent.toString());

        marker.relocate(nodeInMarkerParent.getX() + marker.getLayoutBounds().getMinX(),
                nodeInMarkerParent.getY() +marker.getLayoutBounds().getMinY());
        
    }
    
}
