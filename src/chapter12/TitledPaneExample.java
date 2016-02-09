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
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class TitledPaneExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField firstNameFld = new TextField();
        firstNameFld.setPrefColumnCount(10);
        
        TextField lastNameFld = new TextField();
        lastNameFld.setPrefColumnCount(10);
        
        DatePicker dob = new DatePicker();
        dob.setPrefWidth(150);
        
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("First name:"), firstNameFld);
        grid.addRow(1, new Label("Last name:"), lastNameFld);
        grid.addRow(2, new Label("DOB:"),dob);
        
        TitledPane infoPane = new TitledPane(); 
        infoPane.setText("Personal Info");
        infoPane.setGraphic(null);
        infoPane.setContent(grid);
        
        Accordion acc = new Accordion();
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("First Name:"), new TextField());
        gridPane.addRow(1, new Label("Last Name:"), new TextField());
        gridPane.addRow(2, new Label("DOB:"), new DatePicker());
        TitledPane generalPane = new TitledPane("General",gridPane);
        
        GridPane addressGrid = new GridPane();
        addressGrid.addRow(0, new Label("Street:"), new TextField());
        addressGrid.addRow(1, new Label("City:"), new TextField());
        addressGrid.addRow(2, new Label("State:"), new TextField());
        addressGrid.addRow(3, new Label("ZIP:"), new TextField());
        TitledPane addressPane = new TitledPane("Address",addressGrid);
        
        GridPane phonesGrid = new GridPane();
        phonesGrid.addRow(0, new Label("Home:"), new TextField());
        phonesGrid.addRow(1, new Label("Work:"), new TextField());
        phonesGrid.addRow(2, new Label("Cell:"), new TextField());
        phonesGrid.addRow(3, new Button("Pressme"), new ComboBox());
        
        
        TitledPane phonesPane = new TitledPane("Phone",phonesGrid);

        acc.getPanes().addAll(generalPane, addressPane,phonesPane);
        acc.setExpandedPane(generalPane);
        
        
        
        
        HBox root = new HBox(infoPane,acc);
        root.setSpacing(10);
        
        Scene scene = new Scene(root, 500, 550);
        scene.getStylesheets().add("resources/css/darktheme.css");
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
