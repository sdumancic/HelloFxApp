/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import chapter11.model.Person;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Sanjin
 */
public class TableViewEditing extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());
       table.setEditable(true);
       addIdColumn(table);
       addFirstNameColumn(table);
       addLastNameColumn(table);
       addBirthDateColumn(table);
       addBabyColumn(table);
       addGenderColumn(table);
       
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

    private void addIdColumn(TableView<Person> table) {
        table.getColumns().add(PersonTableUtil.getIdColumn());
    }

    private void addFirstNameColumn(TableView<Person> table) {
        TableColumn<Person, String> firstNameColumn = PersonTableUtil.getFirstNameColumn();
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        table.getColumns().add(firstNameColumn);
    }

    private void addLastNameColumn(TableView<Person> table) {
        TableColumn<Person, String> lastNameColumn = PersonTableUtil.getLastNameColumn();
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        table.getColumns().add(lastNameColumn);
    }

    private void addBirthDateColumn(TableView<Person> table) {
        TableColumn<Person, LocalDate> birthDateColumn = PersonTableUtil.getBirthDateColumn();
        LocalDateStringConverter converter = new LocalDateStringConverter();
        birthDateColumn.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        table.getColumns().add(birthDateColumn);
    }

    private void addBabyColumn(TableView<Person> table) {
        TableColumn<Person,Boolean> babyCol = new TableColumn("Baby?");
        babyCol.setEditable(false);
        
        babyCol.setCellValueFactory(cellData->{
            Person p = cellData.getValue();
            Boolean v = (p.getAgeCategory() == Person.AgeCategory.BABY);
            return new ReadOnlyBooleanWrapper(v);
        });
        
        babyCol.setCellFactory(CheckBoxTableCell.forTableColumn(babyCol));
        table.getColumns().add(babyCol);
                
    }

    private void addGenderColumn(TableView<Person> table) {
       TableColumn<Person,String> genderCol = new TableColumn("Gender");
       genderCol.setMinWidth(80);
       genderCol.setCellValueFactory(cellData->new ReadOnlyStringWrapper(null));
       genderCol.setCellFactory(ComboBoxTableCell.forTableColumn("Male","Female"));
       genderCol.setOnEditCommit(e->{
           int row = e.getTablePosition().getRow();
           Person p = e.getRowValue();
           System.out.println("Gender changed for " + p.getFirstName() + " " + p.getLastName() + " at row " + (row+1) + " to " + e.getNewValue());
       });
       table.getColumns().add(genderCol);
    }
    
}
