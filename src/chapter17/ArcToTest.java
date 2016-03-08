/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter17;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class ArcToTest extends Application {
    private ArcTo arcTo;
    
    @Override
    public void start(Stage primaryStage) {
        arcTo = new ArcTo(); 
        
        Path path = new Path(new MoveTo(0, 0),
                new VLineTo(100),                                     
                new HLineTo(100),                                     
                new VLineTo(50),                                     
                arcTo);
        
        BorderPane root = new BorderPane();
        root.setTop(this.getTopPane());  
        root.setCenter(path); 
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);         
        primaryStage.setTitle("Using ArcTo Path Elements");       
        primaryStage.show(); 
    }
    
     private GridPane getTopPane() {       
         CheckBox largeArcFlagCbx = new CheckBox("largeArcFlag");                
         CheckBox sweepFlagCbx = new CheckBox("sweepFlag");                
         Slider xRotationSlider = new Slider(0, 360, 0);                
         xRotationSlider.setPrefWidth(300);                
         xRotationSlider.setBlockIncrement(30);                
         xRotationSlider.setShowTickMarks(true);                
         xRotationSlider.setShowTickLabels(true); 
         Slider radiusXSlider = new Slider(100, 300, 100);                
         radiusXSlider.setBlockIncrement(10);                
         radiusXSlider.setShowTickMarks(true);                
         radiusXSlider.setShowTickLabels(true); 
         Slider radiusYSlider = new Slider(100, 300, 100);                
         radiusYSlider.setBlockIncrement(10);                
         radiusYSlider.setShowTickMarks(true);                
         radiusYSlider.setShowTickLabels(true); 
         // Bind ArcTo properties to the control data                
         arcTo.largeArcFlagProperty().bind(largeArcFlagCbx.selectedProperty());                
         arcTo.sweepFlagProperty().bind(sweepFlagCbx.selectedProperty());                
         arcTo.XAxisRotationProperty().bind(xRotationSlider.valueProperty());                
         arcTo.radiusXProperty().bind(radiusXSlider.valueProperty());                
         arcTo.radiusYProperty().bind(radiusYSlider.valueProperty());                                 
         GridPane pane = new GridPane();                
         pane.setHgap(5);                
         pane.setVgap(10);                
         pane.addRow(0, largeArcFlagCbx, sweepFlagCbx);                
         pane.addRow(1, new Label("XAxisRotation"), xRotationSlider);                
         pane.addRow(2, new Label("radiusX"), radiusXSlider);                
         pane.addRow(3, new Label("radiusY"), radiusYSlider); 
                return pane;        } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
