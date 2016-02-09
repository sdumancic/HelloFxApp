/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class MnemonicTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setStyle("-fx-padding:10; -fx-border-style: solid inside; -fx-border-width:2; -fx-border-insets:5; -fx-border-radius:5; -fx-border-color:blue;");
        Scene scene = new Scene(root, 300, 350);
        Label msg = new Label("Press CTRL+X to close the window");
        Label lbl = new Label("Press Alt+1 or Alt+2");
        
        Button btn1 = new Button("Button _1");
        btn1.setOnAction(e->lbl.setText("Button 1 clicked"));
                
        Button btn2 = new Button("Button 2");
        btn2.setOnAction(e->lbl.setText("Button 2 clicked"));
        
        KeyCombination kc = new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.ALT_DOWN);
        Mnemonic mnemonic = new Mnemonic(btn2,kc);
        scene.addMnemonic(mnemonic);
        
        KeyCombination kc4 = new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN);
        Runnable taks = () -> scene.getWindow().hide();
        scene.getAccelerators().put(kc4, taks);
        
        Label lbl2 = new Label("_First name:");
        TextField fNameFld = new TextField();
        lbl2.setLabelFor(fNameFld);
        lbl2.setMnemonicParsing(true);
        root.getChildren().addAll(msg, lbl, btn1, btn2, lbl2, fNameFld);
        
        scene.getStylesheets().add("resources/css/Buttons.css");
        btn1.idProperty().set("dark-blue");
        //root.setStyle("-fx-background-color: #373737;");
        
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
