/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import chapter11.model.Person;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Sanjin
 */
public class SimpleTableView extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Person> table = new TableView<>(/*PersonTableUtil.getPersonList()*/);
table.setEditable(true);
        table.getColumns().addAll(PersonTableUtil.getIdColumn(), 
                                  PersonTableUtil.getFirstNameColumn(), 
                                  PersonTableUtil.getLastNameColumn(), 
                                  PersonTableUtil.getBirthDateColumn());

        Callback<CellDataFeatures<Person,String>,ObservableValue<String>> fNameCellFactory = 
                new Callback<CellDataFeatures<Person,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Person, String> param) {
                Person p = param.getValue();
                return p.firstNameProperty();
            }
        };
        
        VBox root = new VBox(table);
        root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simplest TableView");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
