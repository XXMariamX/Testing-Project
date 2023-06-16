package controller;
import java.io.IOException;

import java.util.Objects;

import static java.lang.String.valueOf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Bank;

public class MainWindowController {
    private Scene scene;
    Stage stage ;
    @FXML
    Button LogOut,BuyItem,PayBill,Transfer,Info;
    @FXML
    TextField Category;
    @FXML
    Label omar;

    @FXML
    private Parent root;

    public void logout (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
        root = loader.load();
        LoginController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        Bank.logout();
    }
    public void BuyItem (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/BuyItem.fxml"));
        root = loader.load();
        BuyItemController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/BuyItem.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
    public void Transfer (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Transfer.fxml"));
        root = loader.load();
        TransferController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Transfer.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
    public void PayBill (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PayBill.fxml"));
        root = loader.load();
        PayBillController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/PayBill.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
    public void Info (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Info.fxml"));
        root = loader.load();
        InfoController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Info.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
}