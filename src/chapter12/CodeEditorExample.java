package chapter12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 * An example application which demonstrates use of a CodeMirror based
 * JavaScript CodeEditor wrapped in a JavaFX WebView.
 */
public class CodeEditorExample extends Application {

    // some sample code to be edited.

    static final private String editingCode
         = "SELECT SQL_NO_CACHE DISTINCT\n" +
            "		@var1 AS `val1`, @'val2', @global.'sql_mode',\n" +
            "		1.1 AS `float_val`, .14 AS `another_float`, 0.09e3 AS `int_with_esp`,\n" +
            "		0xFA5 AS `hex`, x'fa5' AS `hex2`, 0b101 AS `bin`, b'101' AS `bin2`,\n" +
            "		DATE '1994-01-01' AS `sql_date`, { T \"1994-01-01\" } AS `odbc_date`,\n" +
            "		'my string', _utf8'your string', N'her string',\n" +
            "        TRUE, FALSE, UNKNOWN\n" +
            "	FROM DUAL\n" +
            "	-- space needed after '--'\n" +
            "	# 1 line comment\n" +
            "	/* multiline\n" +
            "	comment! */\n" +
            "	LIMIT 1 OFFSET 0";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // create the editing controls.
        Label title = new Label("Editing: CodeEditor.java");
        title.setStyle("-fx-font-size: 20;");
        final Label labeledCode = new Label(editingCode);
        final CodeEditor editor = new CodeEditor(editingCode);
        final Button revertEdits = new Button("Revert edits");
        revertEdits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                editor.revertEdits();
            }
        });
        final Button copyCode = new Button(
                "Take a snapshot from the editor and set a revert point"
        );
        copyCode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labeledCode.setText(editor.getCodeAndSnapshot());
                System.out.println(editor.getCodeAndSnapshot());
            }
        });

        final Button fullScreen = new Button("Full Screen");
        fullScreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                editor.fullScreen();
            }
        });
        
        final VBox layout = VBoxBuilder.create().spacing(10).children(
                title,
                editor,
                HBoxBuilder.create().spacing(10).children(copyCode, revertEdits, fullScreen).build(),
                labeledCode
        ).build();
        //layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");

        // display the scene.
        final Scene scene = new Scene(layout);
        scene.getStylesheets().add("resources/css/darktheme.css");
        stage.setScene(scene);
        stage.show();
    }
}
