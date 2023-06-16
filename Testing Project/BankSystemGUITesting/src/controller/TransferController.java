package controller;
import java.io.IOException;
import java.util.Objects;

import static java.lang.String.valueOf;
import static model.Bank.getCurrentCLinet;

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
import model.Account;
import model.Bank;

public class TransferController {
    private Scene scene;
    Stage stage ;
    @FXML
    Label failed;
    @FXML
    Button LogOut,MainWindow,Transfer;
    @FXML
    TextField Amount;
    @FXML
    TextField To;
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
    public void MainWindow (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
        root = loader.load();
        MainWindowController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainWindow.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
    public void Transfer (ActionEvent e) throws IOException {
        double z;
        Account myacc;
        int y;
        try {
            y = Integer.parseInt(To.getText());
            z = Double.parseDouble(Amount.getText());
            myacc = Bank.clients.get(getCurrentCLinet()).getFirstAccount();
            if (z > myacc.getBalance())
                failed.setText("Not enough funds");
            else {
                myacc.setBalance(myacc.getBalance() - z);
                Bank.clients.get(getCurrentCLinet()).addNotification("Transfer", Amount.getText());
                failed.setText("Transferred Successfully !");
            }
        } catch (NumberFormatException ex) {
            failed.setText("Please Enter Proper Values Types!");
        }
    }
}
