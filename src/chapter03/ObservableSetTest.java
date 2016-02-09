/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import java.util.HashSet;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

/**
 *
 * @author Sanjin
 */
public class ObservableSetTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObservableSet<String> s1 = FXCollections.observableSet("one","two","three");
        System.out.println("s1="+s1);
        Set<String> s2 = new HashSet<>();
        s2.add("one");
        s2.add("three");
        System.out.println("s2="+s2);
    }
    
}
