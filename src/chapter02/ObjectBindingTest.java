/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Sanjin
 */
public class ObjectBindingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book b1 = new Book("Programming Java FX","12345678",39.99);
        Book b2 = new Book("Programming C++","12345679",39.99);
        ObjectProperty<Book> book1 = new SimpleObjectProperty<>(b1);
        ObjectProperty<Book> book2 = new SimpleObjectProperty<>(b2);
        
        BooleanBinding isEqual = book1.isEqualTo(book2);
        System.out.println(isEqual.get());
        
        book2.set(b1);
        System.out.println(isEqual.get());
    }
    
}
