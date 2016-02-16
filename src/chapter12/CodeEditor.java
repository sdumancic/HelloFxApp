/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * A syntax highlighting code editor for JavaFX created by wrapping a CodeMirror
 * code editor in a WebView.
 *
 * See http://codemirror.net for more information on using the codemirror
 * editor.
 */
public class CodeEditor extends StackPane {

    /**
     * a webview used to encapsulate the CodeMirror JavaScript.
     */
    final WebView webview = new WebView();

    /**
     * a snapshot of the code to be edited kept for easy initilization and
     * reversion of editable code.
     */
    private String editingCode;

    /**
     * a template for editing code - this can be changed to any template derived
     * from the supported modes at http://codemirror.net to allow syntax
     * highlighted editing of a wide variety of languages.
     */
    
    
        
    private final String editingTemplate
            = "<!doctype html>"
            + "<html>"
            + "<head>"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/lib/codemirror.css\">"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/theme/erlang-dark.css\">"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/theme/ambiance.css\">"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/addon/fold/foldgutter.css\">"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/doc/docs.css\">"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/addon/display/fullscreen.css\">"
            + "  <script src=\"http://codemirror.net/lib/codemirror.js\"></script>"
            + "  <script src=\"http://codemirror.net/mode/sql/sql.js\"></script>"
            + "  <script src=\"http://codemirror.net/addon/edit/closebrackets.js\"></script>"
            + "  <link rel=\"stylesheet\" href=\"http://codemirror.net/addon/hint/show-hint.css\">"
            + "  <script src=\"http://codemirror.net/addon/hint/show-hint.js\"></script>"
            + "  <script src=\"http://codemirror.net/addon/hint/sql-hint.js\"></script>"
            + "  <script src=\"http://codemirror.net/addon/display/fullscreen.js\"></script>"
            + "<body>"
            + "<form><textarea id=\"code\" name=\"code\">\n"
            + "${code}"
            + "</textarea></form>"
            + "<script>"
            + "  var editor = CodeMirror.fromTextArea(document.getElementById(\"code\"), {"
            + "    lineNumbers: true,"
            + "    matchBrackets: true,"
            + "    autoCloseBrackets: true,"
            + "    fullScreen: true,"
            + "    theme: \"ambiance\","
            + "    mode: \"text/x-plsql\","
            + "    hint: CodeMirror.hint.sql,"
            + "    hintOptions: {tables: {\"table1\": [ \"col_A\", \"col_B\", \"col_C\" ],\"table2\": [ \"other_columns1\", \"other_columns2\" ] }}"
            + "  });"
            + "editor.setOption(\"extraKeys\", {\n" 
            +     "\"Ctrl-Space\": \"autocomplete\","
            +     "\"Ctrl-Enter\": function(cm) { cm.replaceSelection(\"CTRL+ENTER pressed\"); }    ,"
            +     "\"Ctrl-1\": function(cm) { cm.setValue(\"Ctrl + 1 pressed\"); }    "
            +    "});"
            + "</script>"
            + "</body>"
            + "</html>"; 
    

    /**
     * applies the editing template to the editing code to create the
     * html+javascript source for a code editor.
     */
    private String applyEditingTemplate() {
        return editingTemplate.replace("${code}", editingCode);
    }

    /**
     * sets the current code in the editor and creates an editing snapshot of
     * the code which can be reverted to.
     */
    public void setCode(String newCode) {
        this.editingCode = newCode;
        webview.getEngine().loadContent(applyEditingTemplate());
    }

    /**
     * returns the current code in the editor and updates an editing snapshot of
     * the code which can be reverted to.
     */
    public String getCodeAndSnapshot() {
        this.editingCode = (String) webview.getEngine().executeScript("editor.getValue();");
        return editingCode;
    }

    /**
     * revert edits of the code to the last edit snapshot taken.
     */
    public void revertEdits() {
        setCode(editingCode);
    }

     public void  fullScreen() {
        //this.editingCode = (String) webview.getEngine().executeScript(" editor.setOption(\"theme\", \"ambiance\");");
        //this.editingCode = (String) webview.getEngine().executeScript(" editor.setOption(\"fullScreen\", \"true\");");
        
                
        
     }
     
    /**
     * Create a new code editor.
     *
     * @param editingCode the initial code to be edited in the code editor.
     */
    CodeEditor(String editingCode) {
        this.editingCode = editingCode;
        webview.setPrefSize(650, 325);
        webview.setMinSize(650, 325);
        
        webview.getEngine().loadContent(applyEditingTemplate());
        
        webview.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event) {
                if (event.isControlDown() && event.getCode() == KeyCode.ENTER)
                System.out.println("Execute code at caret");
            }
        });

        this.getChildren().add(webview);
        
    }
}
