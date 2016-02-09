/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Sanjin
 */
public class BoundProperty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(10);
        IntegerProperty y = new SimpleIntegerProperty(20);
        IntegerProperty z = new SimpleIntegerProperty(60);
        
        z.bind(x.add(y));
        System.out.println("After binding " + z.isBound() + ",z="+z.get());
        
        x.set(15);
        y.set(25);
        System.out.println("After binding " + z.isBound() + ",z="+z.get());
        z.unbind();
        x.set(150);
        y.set(250);
        System.out.println("After binding " + z.isBound() + ",z="+z.get());
    }
    
}
