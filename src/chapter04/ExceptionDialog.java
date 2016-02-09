/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Sanjin
 */
public class ExceptionDialog extends Alert{
    
    private Exception ex;
    Label label = new Label("The exception stacktrace was:");

    TextArea textArea;
    
    public ExceptionDialog(AlertType alertType, String title, String header, String content) {
        super(alertType);
        setTitle(title);
        setHeaderText(header);
        setContentText(content);
    }

    public Exception getException() {
        return ex;
    }

    public void setException(Exception ex) {
        this.ex = ex;
        if (ex != null)
            fillControls();
    }
    
    private void fillControls(){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();
        
        textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        this.getDialogPane().setExpandableContent(expContent);

    }
    
}
