package src.main.javaFX;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.accessibility.AccessibleIcon;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button SignUp;
    @FXML
    public Button SingIn;
    @FXML
    public Button about;
    @FXML
    public Button help;
    @FXML
    public Button close;
    @FXML
    public Button logOut;
    @FXML
    public AnchorPane anchorPane;

    @FXML
    public void setSingIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void closeButtonHandler(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void logOutButtonHandler(ActionEvent actionEvent) throws IOException {

    }

    @FXML
    public void Help(ActionEvent event) throws IOException {

    }

    @FXML
    public void About(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleSwitch button = new ToggleSwitch();
        SimpleBooleanProperty isOn = button.switchOnProperty();
        isOn.addListener((observable,oldValue,newValue) ->{
                if(newValue){
                    button.getScene().getRoot().getStylesheets().add(Objects.requireNonNull(getClass().getResource("darktheme.css")).toString());
                }else{
                    button.getScene().getRoot().getStylesheets().remove(Objects.requireNonNull(getClass().getResource("darktheme.css")).toString());
                }

        });
        anchorPane.getChildren().add(button);
    }
}
