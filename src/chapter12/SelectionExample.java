/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import chapter11.model.Person;
import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Sanjin
 */
public class SelectionExample extends Application {
 
     public static void main(String[] args) {
        Application.launch(args);
    }
     
      public void start(Stage stage) {                
          
        Label selectedValueLbl = new Label("None");
        Label selectedPersonLbl = new Label("None");
        ObservableList<String> seasonList = FXCollections.<String>observableArrayList("Spring","Summer","Fall","Winter");
        ChoiceBox<String> seasons = new ChoiceBox<>(seasonList);
        seasons.getSelectionModel().selectFirst();
        seasons.getSelectionModel().selectedItemProperty().addListener(this::itemChanged);
        selectedValueLbl.textProperty().bind(seasons.valueProperty());
        
        ChoiceBox<Person> persons = new ChoiceBox<>();
        Person p1 = new Person("Sanjin","Dumancic",LocalDate.of(1977, Month.SEPTEMBER, 4));
        Person p2 = new Person("Štef","Blažov",LocalDate.of(1977, Month.SEPTEMBER, 4));
        Person p3 = new Person("Aston","Kutcher", LocalDate.now());
        Person p4 = new Person("Mena","Suvari", LocalDate.now());
        persons.getItems().addAll(null,p1,p2,p3,p4);
        selectedPersonLbl.textProperty().bind(persons.valueProperty().asString());
        persons.setConverter(new PersonStringConverter());
        
        ComboBox<Person> comboPersons = new ComboBox<>();
        comboPersons.getItems().addAll(p1,p2,p3,p4);
        comboPersons.setEditable(true);
        comboPersons.setConverter(new PersonStringConverter());
        comboPersons.setVisibleRowCount(3);
        Label comboLbl = new Label();
        StringProperty str = new SimpleStringProperty("Your selection:");
        comboLbl.textProperty().bind(str.concat("Person=").concat(comboPersons.valueProperty()));
        comboPersons.getSelectionModel().selectedItemProperty().addListener(this::comboItemChanged);
        
        ListView<Person> listview = new ListView<>();
        listview.getItems().addAll(p1,p2,p3,p4); 
        Label placeHolder = new Label("No seasons available for selection");
        listview.setPrefSize(300,70);
        listview.setPlaceholder(placeHolder);
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listview.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {

            @Override
            public ListCell<Person> call(ListView<Person> param) {
                  return new ListCell<Person>(){
                      @Override
                      public void updateItem(Person item, boolean empty){
                          super.updateItem(item, empty);
                          int index = this.getIndex();
                          String name = null;
                          if (item == null || empty){}
                          else{
                              name = (index + 1) + "." + item.getLastName() + ", " + item.getFirstName();
                          }
                          this.setText(name);
                          setGraphic(null);
                      }
                  };
            }
        });
        
        
        DatePicker dp = new DatePicker(LocalDate.now());
        dp.setEditable(false);
        
        TextField text1 = new TextField();
        PasswordField text2 = new PasswordField();
        text2.setPrefColumnCount(20);
        ContextMenu cm = new ContextMenu();
        MenuItem dummyItem = new MenuItem("Context menu is disabled");
        cm.getItems().add(dummyItem);
        text2.setContextMenu(cm);
        
        TextArea ta = new TextArea();
        ta.setPrefColumnCount(40);
        ta.setPrefRowCount(10);
        ta.wrapTextProperty().set(true);
        ta.setText("Lorem Ipsum je jednostavno probni tekst koji se koristi u tiskarskoj i slovoslagarskoj industriji. Lorem Ipsum postoji kao industrijski standard još od 16-og stoljeća, kada je nepoznati tiskar uzeo tiskarsku galiju slova i posložio ih da bi napravio knjigu s uzorkom tiska. Taj je tekst ne samo preživio pet stoljeća, već se i vinuo u svijet elektronskog slovoslagarstva, ostajući u suštini nepromijenjen. Postao je popularan tijekom 1960-ih s pojavom Letraset listova s odlomcima Lorem Ipsum-a, a u skorije vrijeme sa software-om za stolno izdavaštvo kao što je Aldus PageMaker koji također sadrži varijante Lorem Ipsum-a.");
        
        Button b2 = new Button("Paragraphs");
        b2.setOnAction(e->{
            ObservableList<CharSequence> paragraphs = ta.getParagraphs();
            for (int i = 0;i<paragraphs.size();i++){
                CharSequence cs = paragraphs.get(i);
                System.out.println("Paragraph #" + (i+1) + " " + cs.length());
            }
        });
        
        ProgressIndicator pi = new ProgressIndicator();
        ProgressBar pb = new ProgressBar();
        
        
        // Add ToggleButtons to an HBox              
        HBox buttonBox = new HBox(seasons,selectedValueLbl);
        HBox personBox = new HBox(persons,selectedPersonLbl);
        HBox personComboBox = new HBox(comboPersons,comboLbl);
        HBox buttonsBox = new HBox(new Button("Button1"), new Button("Button2"));
        HBox listViewBox = new HBox(listview);
        HBox textInputBox = new HBox(text1, text2);
        HBox taBox = new HBox(ta);
        HBox dpBox = new HBox(dp,b2);
        HBox progressBox = new HBox(pi,pb);
        buttonBox.setSpacing(10);
        personBox.setSpacing(10);
        personComboBox.setSpacing(10);
        buttonsBox.setSpacing(10);
        VBox root = new VBox(buttonBox,personBox,personComboBox,buttonsBox,listViewBox,dp, textInputBox, taBox,dpBox,progressBox);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        Scene scene = new Scene(root,500,500);
        scene.getStylesheets().add("resources/css/darktheme.css");
        stage.setScene(scene);
        stage.show();
    }                
      
    private void itemChanged(ObservableValue observable, String oldValue, String newValue)  {
        System.out.println("chapter12.SelectionExample.itemChanged()" + oldValue + ", " + newValue);
    }
    
    private void comboItemChanged(ObservableValue<? extends Person> observable, Person oldValue, Person newValue)  {
        System.out.println("chapter12.SelectionExample.itemChanged()" + oldValue + ", " + newValue);
    }
    
}
