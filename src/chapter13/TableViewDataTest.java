/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import chapter11.model.Person;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class TableViewDataTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TableView<Person> table =  new TableView<>(PersonTableUtil.getPersonList()); 
        
        table.setTableMenuButtonVisible(true);
        
         // Create an "Age" computed column
         TableColumn<Person, String> ageCol = new TableColumn<>("Age");  
         ageCol.setCellValueFactory(cellData -> { 
             Person p = cellData.getValue(); 
             LocalDate dob = p.getBirthDate();           
             String ageInYear = "Unknown"; 
             if (dob != null) {
                long years = YEARS.between(dob, LocalDate.now());
                if (years == 0) {
                    ageInYear = "< 1 year";
                } else if (years == 1) {
                    ageInYear = years + " year";
                } else {
                    ageInYear = years + " years";
                }
            }
            return new ReadOnlyStringWrapper(ageInYear);
        }
    );
        
        TableColumn<Person, Person.AgeCategory> ageCategoryCol =  new TableColumn<>("Age Category");                
        ageCategoryCol.setCellValueFactory( new PropertyValueFactory<>("ageCategory")); 
        // Add columns to the TableView                
        table.getColumns().addAll(  PersonTableUtil.getIdColumn(),                                          
                                    PersonTableUtil.getFirstNameColumn(),       
                                    PersonTableUtil.getLastNameColumn(),  
                                    PersonTableUtil.getBirthDateColumn(),           
                                    ageCol,                       
                                    ageCategoryCol);    
        HBox root = new HBox(table);    
        root.setStyle("-fx-padding: 10;" +
                      "-fx-border-style: solid inside;" +             
                      "-fx-border-width: 2;" +                    
                      "-fx-border-insets: 5;" +                              
                      "-fx-border-radius: 5;" +                              
                      "-fx-border-color: blue;"); 
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
