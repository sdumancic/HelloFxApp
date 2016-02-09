/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 *
 * @author Sanjin
 */
public class ListBindingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListProperty<String> lp = new SimpleListProperty(FXCollections.observableArrayList());
        StringProperty initStr = new SimpleStringProperty("Size: ");
        StringProperty desc = new SimpleStringProperty();
        desc.bind(initStr.concat(lp.sizeProperty())
                         .concat(", Empty: ")
                         .concat(lp.emptyProperty())
                         .concat(", List: ")
                         .concat(lp.asString())
                 );
        System.out.println("Before " + desc.get());
        lp.addAll("John","jacob");
        System.out.println("After " + desc.get());
    }
    
}
