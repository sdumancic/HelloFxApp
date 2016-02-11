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
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class ToolbarTest extends Application {
    Canvas canvas = new Canvas(200,200);
    
    @Override
    public void start(Stage primaryStage) {
        
        Button rectBtn = new Button("",new Rectangle(16,16, Color.WHEAT));
        Button circleBtn = new Button("",new Circle(8,Color.WHEAT));
        Button ellipseBtn = new Button("",new Ellipse(8,8,8,6));
        Button exitBtn = new Button("Exit");

        rectBtn.setTooltip(new Tooltip("Draws a rectangle"));
        circleBtn.setTooltip(new Tooltip("Draws a circle"));
        ellipseBtn.setTooltip(new Tooltip("Draws a elipse"));
        exitBtn.setTooltip(new Tooltip("Exits"));
        
        rectBtn.setOnAction(e->draw("Rectangle"));
        circleBtn.setOnAction(e->draw("Circle"));
        ellipseBtn.setOnAction(e->draw("Ellipse"));
        exitBtn.setOnAction(e->Platform.exit());
        
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu optionsMenu = new Menu("Options");
        Menu helpMenu = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        fileMenu.getItems().addAll(newItem,openItem);
        Menu saveAsMenu = new Menu("Save As");
        MenuItem textItem = new MenuItem("Text");
        MenuItem pdfItem = new MenuItem("PDF");
        saveAsMenu.getItems().addAll(textItem, pdfItem);
        
        menuBar.getMenus().addAll(fileMenu,editMenu, optionsMenu, helpMenu,saveAsMenu);
        
        ToolBar toolbar = new ToolBar(rectBtn,circleBtn,ellipseBtn, new Separator(), menuBar, exitBtn);
        toolbar.setOrientation(Orientation.VERTICAL);
        BorderPane root = new BorderPane();
        root.setTop(new VBox(new Label("Click a shape to draw"), toolbar));
        root.setCenter(canvas);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("resources/css/darktheme.css");
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void draw(String shapeType){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,200,200);
        gc.setFill(Color.TAN);
        
        if (shapeType.equals("Rectangle"))
            gc.fillRect(0,0,200,200);
        else if (shapeType.equals("Circle"))
            gc.fillOval(0,0,200,200);
        else if (shapeType.equals("Ellipse"))
            gc.fillOval(10,40,180,120);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
