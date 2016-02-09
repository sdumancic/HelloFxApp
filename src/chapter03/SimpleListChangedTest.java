/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author Sanjin
 */
public class SimpleListChangedTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change c) {
                while (c.next()){
                    System.out.println("onChanged " + c.toString());
                    System.out.println("getList()="+ c.getList());
                    System.out.println(c.getFrom() + "-" + c.getTo());

                    System.out.println(c.wasAdded());
                    System.out.println(c.wasPermutated());
                    System.out.println(c.wasRemoved());
                    System.out.println(c.wasUpdated());
                }
            }
        });
        list.add("one");
        list.add("two");
        FXCollections.sort(list);
        list.clear();
        list.addAll("one","two","three");
    }
    
}

