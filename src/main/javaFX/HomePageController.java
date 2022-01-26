package src.main.javaFX;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{
    private Parent root;

    @FXML
    public Button back;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    public MenuBar menuBar;
    @FXML
    public Menu App;
    @FXML
    public Menu Help;
    @FXML
    public Menu View;
    @FXML
    public Menu options;
    @FXML
    public MenuItem exit;
    @FXML
    public MenuItem logout;
    @FXML
    public MenuItem about;
    @FXML
    public MenuItem help;
    @FXML
    public MenuItem fullScreen;
    @FXML
    public MenuItem quit;
    @FXML
    public MenuItem systemTray;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleSwitch button = new ToggleSwitch();
        SimpleBooleanProperty isOn = button.switchOnProperty();
        isOn.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                button.getScene().getRoot().getStylesheets().add(Objects.requireNonNull(getClass().getResource("darktheme.css")).toString());
            } else {
                button.getScene().getRoot().getStylesheets().remove(Objects.requireNonNull(getClass().getResource("darktheme.css")).toString());
            }

        });
        anchorPane.getChildren().add(button);
    }

    @FXML
    public void BackToFirstPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void quitListener(){
        quit.setOnAction(event -> javafx.application.Platform.exit());
        quit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
    }

    @FXML
    public void fullScreen(){
        fullScreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root, 1280, 720));
                    stage.show();
                    stage.setFullScreen(true);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });

        fullScreen.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
    }

    @FXML
    public void aboutListener(){
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("About.fxml")));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root, 1280, 720));
                    stage.show();
                    stage.setResizable(false);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });

        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
    }

}
