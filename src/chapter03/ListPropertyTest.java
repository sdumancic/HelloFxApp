/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;

/**
 *
 * @author Sanjin
 */
public class ListPropertyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListProperty<String> lp = new SimpleListProperty<>(FXCollections.observableArrayList());
        lp.addListener(ListPropertyTest::invalidated);
        lp.addListener(ListPropertyTest::changed);
        lp.addListener(ListPropertyTest::onChanged);
        
        // isto je implementirano pod changed
        lp.addListener(new ChangeListener<ObservableList<String>>() {

            @Override
            public void changed(ObservableValue<? extends ObservableList<String>> observable, ObservableList<String> oldValue, ObservableList<String> newValue) {
                System.out.println("List property has changed");
                System.out.println("Old value=" + oldValue);
                System.out.println("New value=" + newValue);
            }
          
        });
        
        lp.addAll("one","two","three");
        lp.addAll("four");
    }
    
    public static void invalidated(Observable list){
        System.out.println("List property is invalid");
    }
    
    // A change listener
    public static void changed(ObservableValue<? extends ObservableList<String>> observable, ObservableList<String> oldList, ObservableList<String> newList){
        System.out.println("List property has changed");
        System.out.println("Old list=" + oldList);
        System.out.println("New list=" + newList);
    }
    // A list change listener
    public static void onChanged(Change<? extends String> change){
        while (change.next()){
            String action = change.wasPermutated() ? "Permutated"
                    :change.wasUpdated() ? "Updated"
                    :change.wasRemoved() && change.wasAdded() ? "Replaced"
                    :change.wasRemoved() ? "Removed" : "Added";
            System.out.println("Change taken on the list " + action);         
            System.out.println("Removed " + change.getRemoved());
            System.out.println("Added " + change.getAddedSubList());
        }
    }
}

