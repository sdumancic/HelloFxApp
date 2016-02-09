/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import java.util.List;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;

/**
 *
 * @author Sanjin
 */
public class PersonListChangeListener implements ListChangeListener<Person>{

    private static final Logger LOG = Logger.getLogger(PersonListChangeListener.class.getName());
    
    @Override
    public void onChanged(Change<? extends Person> change) {
        while (change.next()){
            if (change.wasPermutated())
                handlePermutated(change);
            else if (change.wasUpdated())
                handleUpdated(change);
            else if (change.wasReplaced())
                handleReplaced(change);
            else{
                if (change.wasRemoved())
                    handleRemoved(change);
                else if (change.wasAdded())
                    handleAdded(change);
            }
        }
    }

    private void handlePermutated(Change<? extends Person> change) {
        System.out.println("Permutated");
        System.out.println("Permutated range " + getRangeText(change));
        int start = change.getFrom();
        int end = change.getTo();
        for (int oldIndex = start; oldIndex<end;oldIndex++){
            int newIndex = change.getPermutation(oldIndex);
            System.out.println("index[" + oldIndex + "] moved to index["+ newIndex +"]");
        }
        
    }
    

    private void handleUpdated(Change<? extends Person> change) {
        System.out.println("Updated");
        System.out.println("Updated range " + getRangeText(change));
        System.out.println("Updated elements are " + change.getList().subList(change.getFrom(), change.getTo()));
        
    }

    private void handleReplaced(Change<? extends Person> change) {
        System.out.println("Replaced");
        handleRemoved(change);
        handleAdded(change);
    }

    private void handleRemoved(Change<? extends Person> change) {
        System.out.println("Removed");
        int removedSize = change.getRemovedSize();
        List<? extends Person> subList = change.getRemoved();
        System.out.println("Removed size=" + removedSize);
        System.out.println("Removed range=" + getRangeText(change));
        System.out.println("Removed list=" + subList);
    }

    private void handleAdded(Change<? extends Person> change) {
        System.out.println("Added");
        int addedSize = change.getAddedSize();
        List<? extends Person> subList = change.getAddedSubList();
        System.out.println("Added size=" + addedSize);
        System.out.println("Added range=" + getRangeText(change));
        System.out.println("Added list=" + subList);
    }

    private String getRangeText(Change<? extends Person> change) {
        return "[" + change.getFrom() + ", " + change.getTo() + "]";
    }
    
}
