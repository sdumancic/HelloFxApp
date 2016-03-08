/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import chapter11.model.Person;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class TableViewAddDeleteRows extends Application {
    private final TextField fNameField = new TextField();        
    private final TextField lNameField = new TextField();        
    private final DatePicker dobField = new DatePicker(); 
    
    TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList()); 
        
    @Override
    public void start(Stage primaryStage) {
        TableViewSelectionModel<Person> tsm = table.getSelectionModel();      
        tsm.setSelectionMode(SelectionMode.MULTIPLE); 
        
        table.getColumns().addAll( PersonTableUtil.getIdColumn(),      
                                    PersonTableUtil.getFirstNameColumn(),                                          
                                    PersonTableUtil.getLastNameColumn(),                                          
                                    PersonTableUtil.getBirthDateColumn()); 
        
        GridPane newDataPane  = this.getNewPersonDataPane(); 
         
        Button restoreBtn = new Button("Restore Rows");   
        restoreBtn.setOnAction(e -> restoreRows()); 

        Button deleteBtn = new Button("Delete Selected Rows");  
        deleteBtn.setOnAction(e -> deleteSelectedRows()); 
         
        VBox root = new VBox(newDataPane, new HBox(restoreBtn, deleteBtn), table); 
          
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
    
     public GridPane getNewPersonDataPane() {
         GridPane pane = new GridPane();
         pane.setHgap(10);       
         pane.setVgap(5);   
         pane.addRow(0, new Label("First Name:"), fNameField);     
         pane.addRow(1, new Label("Last Name:"), lNameField);     
         pane.addRow(2, new Label("Birth Date:"), dobField);    
         Button addBtn = new Button("Add");        
         addBtn.setOnAction(e -> addPerson());      
         // Add the "Add" button     
         pane.add(addBtn, 2, 0);     
         return pane;     
     } 
    
      public void deleteSelectedRows() { 
          TableViewSelectionModel<Person> tsm = table.getSelectionModel();
          if (tsm.isEmpty()) {
              System.out.println("Please select a row to delete.");
              return;        
          }
          // Get all selected row indices in an array                
          ObservableList<Integer> list = tsm.getSelectedIndices();                
          Integer[] selectedIndices = new Integer[list.size()];                
          selectedIndices = list.toArray(selectedIndices); 
          // Sort the array                
          Arrays.sort(selectedIndices);                                 
          // Delete rows (last to first)                
          for(int i = selectedIndices.length - 1; i >= 0; i--) {
              tsm.clearSelection(selectedIndices[i].intValue());                        
              table.getItems().remove(selectedIndices[i].intValue());                
          } 
      } 
      
       public void restoreRows() {
           table.getItems().clear();                
           table.getItems().addAll(PersonTableUtil.getPersonList());        
       } 
       
        public Person getPerson() {      
            return new Person(fNameField.getText(),                                  
                    lNameField.getText(),                                  
                    dobField.getValue());        
        }
        
        public void addPerson() {
            Person p = getPerson();                
            table.getItems().add(p);                
            clearFields();        
        } 
        
        public void clearFields() {
            fNameField.setText(null);                
            lNameField.setText(null);                
            dobField.setValue(null);        
        } 
     
}
