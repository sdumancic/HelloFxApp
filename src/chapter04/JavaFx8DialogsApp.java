/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter04;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author Sanjin
 */
public class JavaFx8DialogsApp extends Application {
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Button infoDialogButtonHeader = new Button("InformationDialog with header");
        infoDialogButtonHeader.setOnAction(e-> showDialog(AlertType.INFORMATION, true,false));
        Button infoDialogButtonNoHeader = new Button("InformationDialog without header");
        infoDialogButtonNoHeader.setOnAction(e-> showDialog(AlertType.INFORMATION, false,false));
        
        Button warnDialogButtonHeader = new Button("WarningDialog with header");
        warnDialogButtonHeader.setOnAction(e-> showDialog(AlertType.WARNING, true,false));
        Button warnDialogButtonNoHeader = new Button("WarningDialog without header");
        warnDialogButtonNoHeader.setOnAction(e-> showDialog(AlertType.WARNING, false,false));
        
        Button errDialogButtonHeader = new Button("ErrorDialog with header");
        errDialogButtonHeader.setOnAction(e-> showDialog(AlertType.ERROR, true,false));
        Button errDialogButtonNoHeader = new Button("ErrorDialog without header");
        errDialogButtonNoHeader.setOnAction(e-> showDialog(AlertType.ERROR, false,false));
        
        Button confirmDialogButton = new Button("ConfirmationDialog with header");
        confirmDialogButton.setOnAction(e-> showDialog(AlertType.CONFIRMATION, true,false));
        
        Button confirmDialogButtonCustom = new Button("ConfirmationDialog without custom controls");
        confirmDialogButtonCustom.setOnAction(e-> showDialog(AlertType.CONFIRMATION, false,true));
        
        Button textInputDialog = new Button("Text input dialog");
        textInputDialog.setOnAction(e-> showTextInputDialog());
        
        Button choiceDialog = new Button("Choice dialog");
        choiceDialog.setOnAction(e-> showChoiceDialog());
        
        Button customDialog = new Button("Custom dialog");
        customDialog.setOnAction(e-> showCustomDialog());
        
        Button exceptionDialog = new Button("Exception dialog");
        exceptionDialog.setOnAction(e-> showExceptionDialog());
        
        VBox root = new VBox();
        root.getChildren().addAll(infoDialogButtonHeader,infoDialogButtonNoHeader,warnDialogButtonHeader,warnDialogButtonNoHeader,errDialogButtonHeader,errDialogButtonNoHeader);
        root.getChildren().addAll(confirmDialogButton,confirmDialogButtonCustom,textInputDialog,choiceDialog,customDialog,exceptionDialog);
        
        Scene scene = new Scene(root, 300, 400);
        
        primaryStage.setTitle("Dialogs example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void showDialog(AlertType alertType, boolean showHeader, boolean customControls) {
        Alert alert = new Alert(alertType);
        alert.setTitle(alertType.toString());
        if (showHeader)
            alert.setHeaderText("Look, an " + alertType.toString() + " Dialog");
        else
            alert.setHeaderText(null);
        alert.setContentText("I have a great message for you!");
        
        if (alertType == AlertType.CONFIRMATION){
            
            if  (!customControls){
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                    System.out.println("User choosed ok");
                else
                    System.out.println("User choosed cancel");
            }
            else{
                ButtonType buttonTypeOne = new ButtonType("One",ButtonData.LEFT);
                ButtonType buttonTypeTwo = new ButtonType("Two",ButtonData.BACK_PREVIOUS);
                ButtonType buttonTypeThree = new ButtonType("Three",ButtonData.YES);
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeOne,buttonTypeTwo,buttonTypeThree,buttonTypeCancel);
                Optional<ButtonType> result = alert.showAndWait();
                System.out.println("result="+result.get());
                if (result.get() == ButtonType.OK)
                    System.out.println("User choosed ok");
                else if (result.get().getButtonData() == ButtonData.LEFT)
                    System.out.println("User choosed left");
                else
                    System.out.println("User choosed cancel");
            }
        }
        else       
            alert.showAndWait();
    }

    private void showTextInputDialog() {
        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your name: " + result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }

    private void showChoiceDialog() {
        List<String> choices = new ArrayList<>();
        choices.add("a");
        choices.add("b");
        choices.add("c");
        

        ChoiceDialog<String> dialog = new ChoiceDialog<>("b", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText("Choose your letter:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your choice: " + result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(letter -> System.out.println("Your choice: " + letter));
    }

    private void showCustomDialog() {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.APPLICATION_MODAL);

        // Set the icon (must be included in the project).
        dialog.setGraphic(new ImageView(this.getClass().getResource("images/login.png").toString()));
        

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        });
    }

    private void showExceptionDialog() {
        ExceptionDialog dialog = new ExceptionDialog(AlertType.ERROR, "Title", "Header text", "Content text");
        //ExceptionDialog dialog = new ExceptionDialog(AlertType.ERROR, "Title", null, "Content text");
        Exception ex = new FileNotFoundException("Could not find file blabla.txt");
        dialog.setException(ex);
        dialog.showAndWait();
    }
    
}
