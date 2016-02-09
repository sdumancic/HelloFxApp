/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Sanjin
 */
public class Employee {
    private String name;
    private Double salary;
    private final PropertyChangeSupport pcs;

    public Employee(String name, Double salary) {
        this.pcs = new PropertyChangeSupport(this);
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange("name", oldName, name);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        double oldSalary = this.salary;
        this.salary = salary;
        pcs.firePropertyChange("salary", oldSalary, salary);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }
    
    public void removeProperyChangeListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }
    
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + '}';
    }
    
}
