/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import chapter11.model.Person;
import javafx.util.StringConverter;

/**
 *
 * @author Sanjin
 */
public class PersonStringConverter extends StringConverter<Person>{

    @Override
    public String toString(Person p) {
        return p == null?"[None]":p.getLastName()+ ", " + p.getFirstName();
    }

    @Override
    public Person fromString(String string) {
        return new Person(string,null,null);
    }
    
    
}
