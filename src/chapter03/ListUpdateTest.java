/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import java.util.List;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 *
 * @author Sanjin
 */
public class ListUpdateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Callback<IntegerProperty, Observable[]> extractor = new Callback<IntegerProperty,Observable[]>() {

            @Override
            public Observable[] call(IntegerProperty param) {
                System.out.println("Extractor is called for " + param);
                return new Observable[]{param};
            }

        };
        ObservableList<IntegerProperty> list = FXCollections.observableArrayList(extractor);
        
        IntegerProperty p1 = new SimpleIntegerProperty(10);
        IntegerProperty p2 = new SimpleIntegerProperty(20);
        list.addAll(p1,p2);
        list.addListener(ListUpdateTest::onChanged);
        
        p1.set(100);
        
    }
    
    /**
     *
     * @param change
     */
    public static void onChanged(ListChangeListener.Change<? extends IntegerProperty> change){
        System.out.println("List is " + change.getList());
        while (change.next()){
            if (change.wasUpdated()){
                System.out.println("An update was detected");
                int start = change.getFrom();
                int to = change.getTo();
                System.out.println("Updated range " + start + "-" + to);
                List<? extends IntegerProperty> subList = change.getList().subList(start, to);
                System.out.println("update list " + subList);
            }
        }
    }
    
}
