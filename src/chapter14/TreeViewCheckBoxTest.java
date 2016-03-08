/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sanjin
 */
public class TreeViewCheckBoxTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CheckBoxTreeItem<String> depts = new CheckBoxTreeItem<>("Departments");
        CheckBoxTreeItem<String> isDept = new CheckBoxTreeItem<>("IS");
        CheckBoxTreeItem<String> claimsDept = new CheckBoxTreeItem<>("Claims");
        CheckBoxTreeItem<String> underwritingDept = new CheckBoxTreeItem<>("Underwriting");
        depts.getChildren().addAll(isDept, claimsDept, underwritingDept);
        isDept.getChildren().addAll(new CheckBoxTreeItem<String>("Doug Dyer"),
                                    new CheckBoxTreeItem<String>("Jim Beeson"),
                                    new CheckBoxTreeItem<String>("Simon Ng"));
        claimsDept.getChildren().addAll(new CheckBoxTreeItem<String>("Lael Boyd"),
                                    new CheckBoxTreeItem<String>("Janet Biddle"));
        underwritingDept.getChildren().addAll(new CheckBoxTreeItem<String>("Key Mceven"),
                                    new CheckBoxTreeItem<String>("Ken Mann"),
                                    new CheckBoxTreeItem<String>("Lola Ng"));
        claimsDept.setIndependent(true);
        TreeView<String> treeView = new TreeView<>(depts);
        treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
        
        HBox root = new HBox(treeView);
        root.setSpacing(20);
        
        
        Scene scene = new Scene(root, 300, 250);
        
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
