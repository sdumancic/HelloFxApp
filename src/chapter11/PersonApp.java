/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter11;

import chapter11.model.Person;
import chapter11.view.PersonPresenter;
import chapter11.view.PersonView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class PersonApp extends Application{
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Person model = new Person();
        String dateFormat = "MM/dd/yyyy";
        PersonView view = new PersonView(model, dateFormat);
        Scene scene = new Scene(view);
        
        PersonPresenter presenter = new PersonPresenter(model, view);
        view.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width:2;" + 
                      "-fx-border-insets: 5;"+
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color:blue;"
        );
        
        scene.getStylesheets().add("resources/css/mystyle.css");
        stage.setScene(scene);
        stage.setTitle("Person Management");
        stage.show();
    }
}
