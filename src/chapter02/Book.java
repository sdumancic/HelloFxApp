/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sanjin
 */
public class Book {
    private final StringProperty title = new SimpleStringProperty(this,"title","Unknown");
    private final ReadOnlyStringWrapper ISBN = new ReadOnlyStringWrapper(this,"ISBN","Unknown");
    private final DoubleProperty price = new SimpleDoubleProperty(this,"price",0.0d);
    private StringProperty lazzyInitialized;
    private String lazzyString = null;
    

    public String getLazzyInitialized() {
        return (lazzyInitialized==null?lazzyString:lazzyInitialized.get());
    }

    public void setLazzyInitialized(String value) {
        if (lazzyInitialized==null){
            lazzyString = value;
        }
        else
        {
            lazzyInitialized.set(value);
        }
    }

    public StringProperty lazzyInitializedProperty() {
        if (lazzyInitialized == null)
        {
            lazzyInitialized = new SimpleStringProperty(this,"lazzy",lazzyString);
        }
        return lazzyInitialized;
    }
    

    public Book(String title, String ISBN, Double price) {
        this.title.set(title);
        this.ISBN.set(ISBN);
        this.price.set(price);
        
    }
    

    public void printDetails(ReadOnlyProperty<?> property){
        String name = property.getName();
        Object value = property.getValue();
        Object bean = property.getBean();
        String beanName = null;
        if (bean != null)
            beanName = bean.getClass().getSimpleName();
        System.out.println("name="+name);
        System.out.println("value="+value);
        System.out.println("beanName="+beanName);
    }
    
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String value) {
        title.set(value);
    }

    public StringProperty titleProperty() {
        return title;
    }
    

    public String getISBN() {
        return ISBN.get();
    }

    public ReadOnlyStringProperty ISBNProperty() {
        return ISBN.getReadOnlyProperty();
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double value) {
        price.set(value);
    }

    public DoubleProperty priceProperty() {
        return price;
    }
    
}
