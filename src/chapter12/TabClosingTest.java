/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.InputStream;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class TabClosingTest extends Application {
    Tab generalTab = new Tab("General",null);
    Tab addressTab = new Tab("Address",null);
    TabPane tabPane = new TabPane();
    CheckBox allowClosingTabsFlag = new CheckBox("Are tabs closable?");
    Button restoreTabsBtn = new Button("Restore tabs");
    ChoiceBox<TabPane.TabClosingPolicy> tabClosingPolicyChoices = new ChoiceBox<>();
        
    @Override
    public void start(Stage primaryStage) {
        
        //Font.loadFont(TabClosingTest.class.getResource("fontawesome/fonts/fontawesome-webfont.ttf").toExternalForm(), 12);
        InputStream font = TabClosingTest.class.getResourceAsStream("/fontawesome/fonts/fontawesome-webfont.ttf");
        Font fontAwesome = Font.loadFont(font, 18);
        //Font.loadFont("fontawesome/fonts/fontawesome-webfont.ttf", 12);
        tabPane.getTabs().addAll(generalTab, addressTab);
        generalTab.setOnCloseRequest(this::tabClosingRequest);
        addressTab.setOnCloseRequest(this::tabClosingRequest);
        
        generalTab.setOnClosed(e->tabClosed(e));
        addressTab.setOnClosed(e->tabClosed(e));
        
        restoreTabsBtn.setOnAction(e->restoreTabs());
        
        tabClosingPolicyChoices.getItems().addAll(TabClosingPolicy.ALL_TABS,TabClosingPolicy.SELECTED_TAB, TabClosingPolicy.UNAVAILABLE);
        
        tabClosingPolicyChoices.setValue(tabPane.getTabClosingPolicy());
        
        tabPane.tabClosingPolicyProperty().bind(tabClosingPolicyChoices.valueProperty());
        
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-padding:10;");
        grid.addRow(0, allowClosingTabsFlag, restoreTabsBtn);
        HBox headerBox = new HBox();
 
        Label label = new Label(FxFontAwesome.Icons.faw_adjust.toString());
        label.setFont(fontAwesome);
        
        Button b1 = new Button(FxFontAwesome.Icons.faw_adjust.toString());
        b1.setPrefSize(30,30);
        b1.setFont(fontAwesome);
        
        headerBox.getChildren().addAll(label, b1);
        
        grid.addRow(1, new Label("Tab closing policy"), tabClosingPolicyChoices);
        grid.addRow(2, headerBox);
        root.setTop(grid);
        root.setCenter(tabPane);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("resources/css/darktheme.css");
        //scene.getStylesheets().add("fontawesome/css/font-awesome.css");
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
    
    public void tabClosingRequest(Event e){
        if (!allowClosingTabsFlag.isSelected())
            e.consume();
    }
    
    public void tabClosed(Event e){
        Tab tab = (Tab)e.getSource();
        String text = tab.getText();
        System.out.println(text + " tab has been closed");
    }

    private void restoreTabs() {
        ObservableList<Tab> list = tabPane.getTabs();
        if (!list.contains(generalTab)){
            list.add(0, generalTab);
        }
        
        if (!list.contains(addressTab)){
            list.add(1, addressTab);
        }
        
    }
    
}
