/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sanjin
 */
public class ObservableListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList("one","two");
        System.out.println("After creating list " + list);
        list.addAll("three","four");
        System.out.println("After creating list " + list);
        list.remove(1,3);
        System.out.println("After creating list " + list);
        list.retainAll("one");
        System.out.println("After creating list " + list);
        ObservableList<String> list2 = FXCollections.<String>observableArrayList("1","2","3");
        list.setAll(list2);
        System.out.println(list);
        ObservableList<String> list3 = FXCollections.<String>observableArrayList("ten","20","thirty");
        ObservableList<String> list4 = FXCollections.concat(list2, list3);
        System.out.println(list4);
    }
    
}
