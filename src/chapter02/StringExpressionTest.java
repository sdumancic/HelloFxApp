/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import java.util.Locale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sanjin
 */
public class StringExpressionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleProperty radius = new SimpleDoubleProperty(7.0d);
        DoubleProperty area = new SimpleDoubleProperty(0);
        StringProperty initStr = new SimpleStringProperty("Radius = ");
        
        area.bind(radius.multiply(radius).multiply(Math.PI));
        
        StringExpression desc = initStr.concat(radius.asString())
                                       .concat(" Area = ")
                                       .concat(area.asString(Locale.GERMAN,"%.4f"));
        System.out.println(desc.getValue());
        radius.set(14d);
        System.out.println(desc.getValue());
        
        // drugi način
        area.bind(Bindings.multiply(Bindings.multiply(radius,radius), Math.PI));
        radius.set(21d);
        System.out.println(desc.getValue());
    }
    
}
