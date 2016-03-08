/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import chapter11.model.Person;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Sanjin
 */
public class CustomTableCellTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());                                 
        // Make sure teh TableView is editable                
        table.setEditable(true);                                 
        // Set up teh Birth Date column to use DatePickerTableCell                
        TableColumn<Person, LocalDate> birthDateCol = PersonTableUtil.getBirthDateColumn();                
        StringConverter converter = new LocalDateStringConverter(FormatStyle.MEDIUM);
                
                //"MMMM dd, yyyy");
        birthDateCol.setCellFactory( DatePickerTableCell.<Person>forTableColumn(converter, false)); 
        table.getColumns().addAll(PersonTableUtil.getIdColumn(),  PersonTableUtil.getFirstNameColumn(), PersonTableUtil.getLastNameColumn(), birthDateCol); 
        
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
