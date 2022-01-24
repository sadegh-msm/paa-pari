package src.main.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

public class Main extends Application {

    File file = new File("unnamed.png");

    Image e = new Image(Paths.get(file.getAbsolutePath()).toUri().toString());


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Twitter");
        primaryStage.getIcons().add(e);
        primaryStage.setScene(new Scene(root, 612, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

