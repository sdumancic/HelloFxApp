/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Sanjin
 */
public class BindingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);
        NumberBinding sum = x.add(y);
        System.out.println("After creating sum="+sum.isValid() + "," + sum);
        int value = sum.intValue();
        System.out.println("After creating sum="+sum.isValid() + "," + sum);
        x.set(250);
        System.out.println("After creating sum="+sum.isValid() + "," + sum);
        value = sum.intValue();
        System.out.println("After creating sum="+sum.isValid() + "," + sum);
    }
    
}
