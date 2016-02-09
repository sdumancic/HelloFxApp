/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 *
 * @author Sanjin
 */
public class ListChangeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Callback<Person,Observable[]> cb = new Callback<Person,Observable[]>() {

            @Override
            public Observable[] call(Person p) {
                return new Observable[]{p.firstNameProperty(),p.lastNameProperty()};
            }
        };
        ObservableList<Person> list = FXCollections.observableArrayList(cb);
        list.addListener(new PersonListChangeListener());
        
        Person p1 = new Person("Li","Na");
        list.add(p1);
        
        Person p2 = new Person("Vivi","Gin");
        Person p3 = new Person("Li","He");
        System.out.println("Before adding p2 and p3 -->" + list);
        list.addAll(p2,p3);
        System.out.println("After adding p2 and p3 -->" + list);
        
        System.out.println("\nBefore sorting the list -->" + list);
        FXCollections.sort(list);
        System.out.println("After sorting the list -->" + list);
        
        System.out.println("\nBefore updating the list -->" + list);
        p1.setLastName("Smith");
        System.out.println("After updating " + p1 + "-->" + list); 
        
        Person p = list.get(0);
        Person p4 = new Person("Simon","Ng");
        System.out.println("\nBefore replacing " + p + " with " + p4 + " : " + list);
        list.set(0,p4);
        
        System.out.println("\nBefore setAll()" + list);
        Person p5 = new Person("lia","li");
        Person p6 = new Person("liz","na");
        Person p7 = new Person("Li","Mo");
        list.setAll(p5,p6,p7);
        System.out.println("After setAll()" + list);
        
        System.out.println("\nBefore removeAll()" + list);
        list.removeAll(p5,p7);
        
    }
    
}
