/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Sanjin
 */
public class TernaryTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerProperty num = new SimpleIntegerProperty(10);
        StringBinding desc = new When(num.divide(2).multiply(2).isEqualTo(num)).then("even").otherwise("odd");
        System.out.println(num.get() + " is " + desc.get());
        num.set(7);
        System.out.println(num.get() + " is " + desc.get());
    }
    
}
