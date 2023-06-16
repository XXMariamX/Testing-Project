package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Bank;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private Scene scene;
    Stage stage ;

    @FXML
    public Button LoginButton;
    @FXML
    TextField UserName;
    @FXML
    PasswordField Password;
    @FXML
    Label failed;
    @FXML
    Image LoginImage;
    @FXML
    ImageView LoginImageView;
    @FXML
    private Parent root;


    public void Login (ActionEvent e) throws IOException{
        String name=UserName.getText();
        String pass = Password.getText();
        String text=Bank.login(name,pass);
        if(text.equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            root = loader.load();
            MainWindowController c = loader.getController();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainWindow.fxml")));
            Label welcome = (Label) root.lookup("#welcome");
            welcome.setText("Welcome");
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root,1600,800);
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
        }
        else {failed.setText(text);}
        }
    }



