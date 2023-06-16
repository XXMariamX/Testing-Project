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

public class BuyItemController {
    private Scene scene;
    Stage stage ;
    @FXML
    Label failed;
    @FXML
    Button LogOut,MainWindow,Buy;
    @FXML
    TextField ID;
    @FXML
    TextField StoreName;
    @FXML
    TextField ProductName;
    @FXML
    TextField Price;
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
    public void Buy (ActionEvent e) throws IOException {
        //int id =Integer.parseInt(ID.getText());
        String s = StoreName.getText();
        String d = ProductName.getText();
        //double p=Double.parseDouble(Price.getText());
        Account myacc = Bank.clients.get(getCurrentCLinet()).getFirstAccount();
        failed.setText("Bought Successfully !");
        try {
            double price = Double.parseDouble(Price.getText());

            int id = Integer.parseInt(ID.getText());

            if (price > myacc.getBalance())
                failed.setText("Not enough funds");
            else {
                Bank.clients.get(getCurrentCLinet()).addNotification("Buy Item", Price.getText());
                myacc.setBalance(myacc.getBalance() - price);
            }

        } catch (NumberFormatException ex) {
            failed.setText("Please Enter Proper Values Types !");
        }
    }


}
