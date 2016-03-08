/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import chapter11.model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class TableViewCellFactoryTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList()); 
         // Create the birth date column
        TableColumn<Person, LocalDate> birthDateCol = PersonTableUtil.getBirthDateColumn(); 
        // Set a custom cell factory for Birth Date column                
        birthDateCol.setCellFactory(col -> {  
            TableCell<Person, LocalDate> cell = new TableCell<Person, LocalDate>() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {   
                    super.updateItem(item, empty); 
                    // Cleanup the cell before populating it                                        
                    this.setText(null);                                        
                    this.setGraphic(null); 
                    if (!empty) {                                                
                        String formattedDob = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(item);                                                
                        this.setText(formattedDob);                                        
                    }                                
                }                        
            };                        
            return cell;                
        }); 
        
         // Create and configure the baby column                
         TableColumn<Person, Boolean> babyCol = new TableColumn<>("Baby?");                
         babyCol.setCellValueFactory(                                
                 cellData -> {                                        
                     Person p = cellData.getValue();                                        
                     Boolean v = (p.getAgeCategory() == Person.AgeCategory.BABY);                                        
                     return new ReadOnlyBooleanWrapper(v); 
                 }); 
        // Set a custom cell factory for the baby column                
        babyCol.setCellFactory(CheckBoxTableCell.<Person>forTableColumn(babyCol));
        
        // Add columns to the table                
        table.getColumns().addAll(PersonTableUtil.getIdColumn(),                                
                                  PersonTableUtil.getFirstNameColumn(),                                
                                  PersonTableUtil.getLastNameColumn(),                                
                                  birthDateCol,                                
                                  babyCol); 
        table.setEditable(true);
        HBox root = new HBox(table);
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
