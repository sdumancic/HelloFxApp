/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sanjin
 */
public class Person implements Comparable<Person>{
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();

    public Person() {
        this.setFirstName("Unknown");
        this.setLastName("Unknown");
    }

    public Person(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    

    
    public String getLastName() {
        return lastName.get();
    }

    public final void setLastName(String value) {
        lastName.set(value);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }
    

    public String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(String value) {
        firstName.set(value);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    @Override
    public int compareTo(Person p) {
        int diff = this.getFirstName().compareTo(p.getFirstName());
        if (diff == 0){
            diff = this.getLastName().compareTo(p.getLastName());
        }
        return diff;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
}
