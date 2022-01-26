package src.main.javaFX;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button back;
    @FXML
    public Button next;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public TextField DateOfBirth;
    @FXML
    public TextField biography;
    @FXML
    public AnchorPane anchorPane;

    @FXML
    public void BackToFirstPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void nextPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setFirstName(ActionEvent actionEvent) {
        String fName = firstName.getText();
    }

    @FXML
    public void setLastName(ActionEvent actionEvent) {
        String lName = lastName.getText();
    }

    @FXML
    public void setUserName(ActionEvent actionEvent) {
        String uName = username.getText();
    }

    @FXML
    public void setPassword(ActionEvent actionEvent) {
        String pass = password.getText();
    }

    @FXML
    public void setDateOfBirth(ActionEvent actionEvent) {
        LocalDate dateOfBirth = LocalDate.parse(DateOfBirth.getText());
    }

    @FXML
    public void setBiography(ActionEvent actionEvent) {
        String bio = biography.getText();
    }

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


}
