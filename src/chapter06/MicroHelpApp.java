/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class MicroHelpApp extends Application {
    
    private Text helpText = new Text();
    
    @Override
    public void start(Stage primaryStage) {
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField salary = new TextField();
        
        
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e->Platform.exit());
        
        fName.getProperties().put("microHelpText", "Enter the first name");
        lName.getProperties().put("microHelpText", "Enter the last name");
        salary.getProperties().put("microHelpText", "Enter a salary greater then 2000");
        
        helpText.setManaged(false);
        helpText.setTextOrigin(VPos.TOP);
        helpText.setFill(Color.RED);
        helpText.setFont(Font.font(null,9));
        helpText.setMouseTransparent(true);
                
        GridPane root = new GridPane();
        root.add(new Label("First name:"), 1,1);
        root.add(fName, 2,1);
        root.add(new Label("Last name:"), 1,2);
        root.add(lName, 2,2);
        root.add(new Label("Salary:"), 1,3);
        root.add(salary, 2,3);
        root.add(closeBtn,3,3);
        root.add(helpText, 4,3);
        
        Scene scene = new Scene(root, 300, 100);
        
        scene.focusOwnerProperty().addListener(new ChangeListener<Node>() {

            @Override
            public void changed(ObservableValue<? extends Node> observable, Node oldValue, Node newValue) {
                focusChanged(observable, oldValue, newValue);
            }

           
          
        });
        
        primaryStage.setTitle("Showing micro help!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void focusChanged(ObservableValue<? extends Node> observable, Node oldValue, Node newValue){
        if (newValue != null){
            String microHelpText = (String) newValue.getProperties().get("microHelpText");
            if (microHelpText != null && microHelpText.trim().length() > 0){
                helpText.setText(microHelpText);
                helpText.setVisible(true);
                double x = newValue.getLayoutX() + newValue.getLayoutBounds().getMinX() -helpText.getLayoutBounds().getMinX();
                double y = newValue.getLayoutY() + newValue.getLayoutBounds().getMinY() + newValue.getLayoutBounds().getHeight() - helpText.getLayoutBounds().getMinX();
                System.out.println("getLayoutY()="+newValue.getLayoutY() + " newValue.getLayoutBounds()=" + newValue.getLayoutBounds().toString());
                helpText.setLayoutX(x);
                helpText.setLayoutY(y);
                helpText.setWrappingWidth(newValue.getLayoutBounds().getWidth());
            }
            else
                helpText.setVisible(false);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
