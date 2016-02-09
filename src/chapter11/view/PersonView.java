/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter11.view;

import chapter11.model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sanjin
 */
public class PersonView extends GridPane{
    private final Person model;
    
    Label personIdLbl = new Label("Person Id:");
    Label fNameLbl = new Label("First Name:");
    Label lNameLbl = new Label("Last Name:");
    Label bDateLbl = new Label("Birth date:");
    Label ageCategoryLbl = new Label("Age Category:");
    
    TextField personIdFld = new TextField();
    TextField fNameFld = new TextField();
    TextField lNameFld = new TextField();
    TextField bDateFld = new TextField();
    TextField ageCategoryFld = new TextField();
    
    Button saveBtn = new Button("_Save");
    Button closeBtn = new Button("_Close");
    
    String dateFormat;
    
    public PersonView(Person model, String dateFormat){
        this.model = model;
        this.dateFormat = dateFormat;
        layoutForm();
        initFieldData();
        bindFieldsToModel();
    }

    private void layoutForm() {
        this.setHgap(5);
        this.setVgap(5);
        
        this.add(personIdLbl, 1,1);
        this.add(fNameLbl, 1,2);
        this.add(lNameLbl, 1,3);
        this.add(bDateLbl, 1,4);
        this.add(ageCategoryLbl,1,5);
        this.add(personIdFld, 2,1);
        this.add(fNameFld, 2,2);
        this.add(lNameFld, 2,3);
        this.add(bDateFld, 2,4);
        this.add(ageCategoryFld, 2,5);
        
        VBox buttonBox = new VBox(saveBtn, closeBtn);
        saveBtn.setMaxWidth(Double.MAX_VALUE);
        closeBtn.setMaxWidth(Double.MAX_VALUE);
        
        this.add(buttonBox,3,1,1,5);
        
        personIdFld.setDisable(true);
        ageCategoryFld.setDisable(true);
        
        bDateFld.setPromptText(dateFormat.toLowerCase());
    }

    public void bindFieldsToModel(){
        personIdFld.textProperty().bind(model.personIdProperty().asString());
        fNameFld.textProperty().bindBidirectional(model.firstNameProperty());
        lNameFld.textProperty().bindBidirectional(model.lastNameProperty());
    }
    
    public void syncBirthDate(){
        LocalDate bDate = model.getBirthDate();
        if (bDate != null){
            bDateFld.setText(bDate.format(DateTimeFormatter.ofPattern(dateFormat)));
        }
        syncAgeCategory();    
    }
    
    public void syncAgeCategory(){
        ageCategoryFld.setText(model.getAgeCategory().toString());
    }
    
    private void initFieldData() {
        syncBirthDate();
    }

    
}
