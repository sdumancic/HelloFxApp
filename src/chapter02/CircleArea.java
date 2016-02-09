/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Sanjin
 */
public class CircleArea {

    /**
     * @param args the command line arguments
     
     */
    public static void main(String[] args) {
        DoubleProperty radius = new SimpleDoubleProperty(7.0d);
        DoubleBinding area = radius.multiply(radius).multiply(Math.PI);
        System.out.println("Radius = " + radius.get() + " Area = " + area.get());
        
        radius.set(14d);
        System.out.println("Radius = " + radius.get() + " Area = " + area.get());
        
        DoubleProperty area2 = new SimpleDoubleProperty();
        area2.bind(radius.multiply(radius).multiply(Math.PI));
        System.out.println("Radius = " + radius.get() + " Area2 = " + area2.get());
    }
    
}
