import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Bank;
import model.Override;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Bank b=new Bank();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        Scene scene = new Scene(root,1600, 800);
        stage.setScene(scene);
        stage.show();
        Image icon = new Image ("resources/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Online Banking");
        stage.setMaximized(true);
    }

    public static void main(String[] args) {
        launch(args);

    }

}