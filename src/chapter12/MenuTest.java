/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class MenuTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Menu fileMenu = new Menu("File");
            MenuItem newItem = new MenuItem("New");
            MenuItem openItem = new MenuItem("Open");
            Menu saveAsMenu = new Menu("Save As");
                MenuItem textItem = new MenuItem("Text");
                MenuItem pdfItem = new MenuItem("PDF");
            saveAsMenu.getItems().addAll(textItem, pdfItem);
            SeparatorMenuItem sep = new SeparatorMenuItem();
            MenuItem exitItem = new MenuItem("Exit");
            exitItem.setOnAction(e->Platform.exit());
            KeyCombination kr = new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN);
            exitItem.setAccelerator(kr);
            RadioMenuItem rectItem = new RadioMenuItem("Rectangle");
            RadioMenuItem circleItem = new RadioMenuItem("Circle");
            RadioMenuItem ellipseItem = new RadioMenuItem("Ellipse");
            rectItem.setSelected(true);
            ToggleGroup shapeGroup = new ToggleGroup();
            shapeGroup.getToggles().addAll(rectItem,circleItem,ellipseItem);
            CheckMenuItem strokeItem = new CheckMenuItem("Draw stroke");
            Slider slider = new Slider(1,10,1);
            CustomMenuItem cmi1 = new CustomMenuItem(slider);
            cmi1.setHideOnClick(false);
            Slider slider2 = new Slider(1,100,10);
            CustomMenuItem cmi2 = new CustomMenuItem(slider2);
            cmi2.setHideOnClick(true);
        fileMenu.getItems().addAll(newItem, openItem, saveAsMenu, sep, exitItem, rectItem, circleItem, ellipseItem,strokeItem, cmi1, cmi2);
        
        Menu editMenu = new Menu("Edit");
        Menu optionsMenu = new Menu("Options");
        Menu helpMenu = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, optionsMenu, helpMenu);
        
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("resources/css/darktheme.css");
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
