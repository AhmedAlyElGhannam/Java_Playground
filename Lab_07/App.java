import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.application.Platform;
import javafx.scene.control.ButtonBar.ButtonData;

public class App extends Application {

    BorderPane bpane;
    MenuBar mbar;
    
    Menu file;
    MenuItem newFile;
    MenuItem openFile;
    MenuItem saveFile;
    MenuItem exitFile;
    

    Menu edit;
    MenuItem cutText;
    MenuItem copyText;
    MenuItem pasteText;
    MenuItem deleteText;
    MenuItem undoText;
    MenuItem selectAllText;

    Menu help;
    MenuItem about;
    
    TextArea ta;

    FileChooser saveDialogue;

    boolean isFileSaved = false;

    @Override
    public void init() throws Exception {
        // call superclass's init function
        super.init(); 
        
        // text area initialization
        ta = new TextArea();

        // file submenus + shortcuts       
        newFile  = new MenuItem("New");
        newFile.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        openFile = new MenuItem("Open File");
        openFile.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        saveFile = new MenuItem("Save");
        saveFile.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        exitFile = new MenuItem("Exit");
        exitFile.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));

        // file menu
        file = new Menu("File");

        // add submenus to file menu
        file.getItems().addAll(newFile, openFile, saveFile, exitFile);

        // edit submenus + shortcuts      
        undoText = new MenuItem("Undo");
        undoText.setAccelerator(KeyCombination.keyCombination("Ctrl+Z"));
        cutText = new MenuItem("Cut");
        cutText.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        copyText = new MenuItem("Copy");
        copyText.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        pasteText = new MenuItem("Paste");
        pasteText.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        deleteText = new MenuItem("Delete");
        deleteText.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        selectAllText = new MenuItem("Select All");
        selectAllText.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        
        // edit menu
        edit = new Menu("Edit");

        // add submenus to edit menu
        edit.getItems().addAll(undoText, cutText, copyText, pasteText, deleteText, selectAllText);

        // file submenus + shortcut
        about  = new MenuItem("About");
        about.setAccelerator(KeyCombination.keyCombination("Alt+Ctrl+S"));

        // help menu
        help = new Menu("Help");

        // add submenus to file menu
        help.getItems().addAll(about);

        // menu bar
        mbar = new MenuBar();

        // add menus to menu bar
        mbar.getMenus().addAll(file, edit, help);

        // defining borderpane 
        bpane = new BorderPane();
        
        // setting menu bar position
        bpane.setTop(mbar);

        // setting text area position
        bpane.setCenter(ta);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        newFile.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Warning!");
                alert.setHeaderText("Creating a New File Will Delete All Unsaved Progress");
                alert.setContentText("Do You Want To Proceed?");
                
                Optional<ButtonType> result = alert.showAndWait();
                if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                    ta.clear();
                } else {
                    // do nothing
                }
           }
        });

        openFile.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failure!");
                alert.setHeaderText(null);
                alert.setContentText("Feature is Not Implemented!");

                alert.showAndWait();
           }
        });

        saveFile.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog("file.txt");
                dialog.setTitle("Save File");
                dialog.setHeaderText("");
                dialog.setContentText("Enter File Name: ");

                // Traditional way to get the response value.
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    isFileSaved = true;
                }
           }
        });

        exitFile.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (!isFileSaved) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("You are Trying to Exit Without Saving");
                    alert.setContentText("Choose Your Option");
                                    
                    ButtonType saveAndExit = new ButtonType("Save and Exit");
                    ButtonType exitWithoutSaving = new ButtonType("Exit without Saving");
                    ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                                    
                    alert.getButtonTypes().setAll(saveAndExit, exitWithoutSaving, cancelButton);
                                    
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == saveAndExit){
                        TextInputDialog dialog = new TextInputDialog("file.txt");
                        dialog.setTitle("Save File");
                        dialog.setHeaderText("");
                        dialog.setContentText("Enter File Name: ");

                        // Traditional way to get the response value.
                        Optional<String> result2 = dialog.showAndWait();
                        if (result2.isPresent()){
                            isFileSaved = true;
                        }

                        Platform.exit();

                    } else if (result.get() == exitWithoutSaving) {
                        Platform.exit();
                    } else {
                        // no nothing
                    }
                } else {
                    Platform.exit();
                }
           }
        });

        about.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("About Suspad++");
                alert.setHeaderText(null);
                alert.setContentText("Just a Wicked Notetaking App with Sussy Spice!");

                alert.showAndWait();
           }
        });

        cutText.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.cut();
           }
        });

        copyText.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.copy();
           }
        });

        pasteText.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.paste();
           }
        });

        deleteText.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.deletePreviousChar();
           }
        });

        undoText.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.undo();
           }
        });

        selectAllText.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.selectAll();
           }
        });

        Scene myS = new Scene(bpane,640,480);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(myS);
        primaryStage.setTitle("Suspad++");
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}