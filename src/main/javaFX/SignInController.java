package src.main.javaFX;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignInController {
    @FXML
    TextField username;
    @FXML
    TextField password;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button back;
    @FXML
    public Button next;

    @FXML
    public void BackToFirstPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void nextPage(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void setUsername(ActionEvent event) throws IOException{
        String name = username.getText();
    }

    @FXML public void setPassword(ActionEvent event) throws IOException{
        String pass = password.getText();
    }

}