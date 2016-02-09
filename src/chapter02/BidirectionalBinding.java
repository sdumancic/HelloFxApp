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
public class BidirectionalBinding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);
        IntegerProperty z = new SimpleIntegerProperty(300);
        System.out.println("Before binding");
        System.out.println("x="+x.get()+" ,y="+y.get() + ",z="+z.get());
        x.bindBidirectional(y);
        System.out.println("After binding");
        System.out.println("x="+x.get()+" ,y="+y.get() + ",z="+z.get());
        x.bindBidirectional(z);
        System.out.println("After binding 2");
        System.out.println("x="+x.get()+" ,y="+y.get() + ",z="+z.get());
        z.set(19);
        System.out.println("x="+x.get()+" ,y="+y.get() + ",z="+z.get());
        x.unbindBidirectional(y);
        x.unbindBidirectional(z);
    }
    
}
