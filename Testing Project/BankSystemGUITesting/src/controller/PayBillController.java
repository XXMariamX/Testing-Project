package controller;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

import static java.lang.String.valueOf;
import static model.Bank.getCurrentCLinet;

import model.Account;
import model.Bank;
import model.Bill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Notification;

public class PayBillController {

    private Scene scene;
    Stage stage ;
    @FXML
    Label failed;
    @FXML
    Button LogOut,MainWindow,pay;
    @FXML
    TextField Category;
    @FXML
    Label pillInfo;
    @FXML
    ComboBox pills;
    Bill l;
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
    public void setPills (ActionEvent e) throws IOException{
        pills.getItems().addAll("Electricity","Gas","Landline","Mobile","Home Internet","Water");
    }

    public void selectBill (ActionEvent e) throws IOException{
        failed.setText("");
        String x=pills.getSelectionModel().getSelectedItem().toString();
        pillInfo.setText(x+" : 300 EGP");
    }
    public void payPill (ActionEvent e) throws IOException{
        // int x = client.Accounts.get(0).getId();
        // client.payBill(x,l);1
        if(pills.getSelectionModel().getSelectedItem()!=null){
        String x=pills.getSelectionModel().getSelectedItem().toString();
        String msg = x+" Bill Paid successfully !";
        Account myacc = Bank.clients.get(getCurrentCLinet()).getFirstAccount();
            if(myacc.getBalance()<300)
                msg = "Not enough funds";
            else{
                myacc.setBalance(myacc.getBalance()-300);
                Bank.clients.get(getCurrentCLinet()).addNotification("Pay Bill","300");
            }
            failed.setText(msg);
        }
        else failed.setText("Select a bill to pay!");

    }
//    public void chosen (ActionEvent e) throws IOException{
//        String arr="";
//        String x1= pills.getValue().toString();
//        for (int i = 0; i< Bank.clients.get(0).bills.size(); i++)
//        {
//            if(Bank.clients.get(0).bills.get(i).getSrc().equals(x1))
//            {
//                l=Bank.clients.get(0).bills.get(i);
//                break;
//            }
//
//        }
//
//        pillInfo.setText(l.getSrc()+"\n"+l.getTime()+"\n"+l.getContent()+"\n"+l.getAmount());
//    }
}
