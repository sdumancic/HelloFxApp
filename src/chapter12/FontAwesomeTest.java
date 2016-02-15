/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class FontAwesomeTest extends Application {
    
    public static Font getAwesomeFont() {
        return Font.loadFont(FontAwesomeTest.class.getResource("/fonts/fontawesome-webfont.ttf").toExternalForm(), 18);
    }
    
    public static Font getCommunityFont() {
        return Font.loadFont(FontAwesomeTest.class.getResource("/fonts/materialdesignicons-webfont.ttf").toExternalForm(), 18);
    }
    
    @Override
    public void start(Stage primaryStage) {
  
        TabPane pane = new TabPane();
        Tab awesomeTab = new Tab("Font awesome");
        Tab communityTab = new Tab("Community");
        pane.getTabs().addAll(awesomeTab, communityTab);
        pane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
        
        FxFontAwesome.Icons[] iconsAwesome = FxFontAwesome.Icons.values();
        FxFontCommunity.Icons[] iconsCommunity = FxFontCommunity.Icons.values();
        
        FlowPane fp1 = new FlowPane(Orientation.HORIZONTAL);
        fp1.setPadding(new Insets(5,5,5,5));
        fp1.setVgap(5);
        fp1.setHgap(5);
        fp1.setAlignment(Pos.CENTER);
        
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Horizontal scroll bar
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Vertical scroll bar
        scroll.setContent(fp1);
        scroll.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                fp1.setPrefWidth(bounds.getWidth());
                fp1.setPrefHeight(bounds.getHeight());
            }
        });
        
        FlowPane fp2 = new FlowPane(Orientation.HORIZONTAL);
        fp2.setPadding(new Insets(5,5,5,5));
        fp2.setVgap(5);
        fp2.setHgap(5);
        fp2.setAlignment(Pos.CENTER);
        
        ScrollPane scroll2 = new ScrollPane();
        scroll2.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Horizontal scroll bar
        scroll2.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Vertical scroll bar
        scroll2.setContent(fp2);
        scroll2.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                fp2.setPrefWidth(bounds.getWidth());
                fp2.setPrefHeight(bounds.getHeight());
            }
        });
        
        
        for (int i = 0;i<iconsAwesome.length;i++){
            Button b = new Button(iconsAwesome[i].toString());
            b.setFont(FontAwesomeTest.getAwesomeFont());
            b.setTooltip(new Tooltip(iconsAwesome[i].getName()));
            b.setOnAction(e->buttonClicked(b));
            fp1.getChildren().add(b);
        }
        awesomeTab.setContent(scroll);
        
        
        for (int i = 0;i<iconsCommunity.length;i++){
            Button b = new Button(iconsCommunity[i].toString());
            b.setFont(FontAwesomeTest.getCommunityFont());
            b.setTooltip(new Tooltip(iconsCommunity[i].getName()));
            b.setOnAction(e->buttonClicked(b));
            //b.setStyle("-fx-text-fill: red; -fx-cursor: hand;");
            fp2.getChildren().add(b);
            
        }
        communityTab.setContent(scroll2);
        
        
        Scene scene = new Scene(pane, 800, 800);
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

    private void buttonClicked(Button b) {
        System.out.println( b.getWidth() + "," + b.getHeight() );
    }


    
}
