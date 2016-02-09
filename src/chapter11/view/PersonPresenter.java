/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter11.view;

import chapter11.model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sanjin
 */
public class PersonPresenter {
    private final Person model;
    private final PersonView view;
    
    public PersonPresenter(Person model, PersonView view){
        this.model = model;
        this.view = view;
        attachEvents();
    }
    
    private void attachEvents(){
        view.bDateFld.setOnAction(e->handleBirthDateChange());
        view.bDateFld.getScene().focusOwnerProperty().addListener(this::focusChanged);
        view.saveBtn.setOnAction(e->saveData());
        view.closeBtn.setOnAction(e->view.getScene().getWindow().hide());
    }

    public void focusChanged(ObservableValue<? extends Node> value, Node oldNode, Node newNode){
        if (oldNode == view.bDateFld)
            handleBirthDateChange();
    }
    
    private void handleBirthDateChange(){
        System.out.println("chapter11.view.PersonPresenter.handleBirthDateChange()");
        String bDateStr = view.bDateFld.getText();
        if (bDateStr == null || bDateStr.trim().equals("")){
            model.setBirthDate(null);
            view.syncBirthDate();
        }
        else{
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(view.dateFormat);
                LocalDate bdate = LocalDate.parse(bDateStr, formatter);
                List<String> errorList = new ArrayList();
                if (model.isValidBirthDate(bdate, errorList)){
                    model.setBirthDate(bdate);
                    view.syncAgeCategory();
                }
                else{
                    this.showError(errorList);
                    view.syncBirthDate();
                }
            }
            catch (DateTimeParseException e){
                List<String> errorList = new ArrayList();
                errorList.add("Birth date must be in the " + view.dateFormat.toLowerCase() + " format");
                this.showError(errorList);
                view.syncBirthDate();
            }
        }
    }
    
    private void saveData(){
        List<String> errorList = new ArrayList<>();
        System.out.println("chapter11.view.PersonPresenter.saveData()");
        boolean isSaved = model.save(errorList);
        if (!isSaved)
            this.showError(errorList);
    }
    
    public void showError(List<String> errorList){
        System.out.println("chapter11.view.PersonPresenter.showError()");
        String msg = "";
        if (errorList.isEmpty()){
            msg = "No message to display";
        }
        else{
            for (String s: errorList){
                msg = msg + s + "\n";
            }
        }
        
        Label msgLbl = new Label(msg);
        Button okBtn = new Button("OK");
        VBox root = new VBox(new StackPane(msgLbl), new StackPane(okBtn));
        root.setSpacing(10);
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.initOwner(view.getScene().getWindow());
        okBtn.setOnAction(e->stage.close());
        
        stage.setTitle("Error");
        stage.sizeToScene();
        stage.showAndWait();
                
        
    }
    
}
