package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.String.valueOf;
import static model.Bank.MYBANK;
import static model.Bank.getCurrentCLinet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;
import model.Bank;
import model.Notification;

public class InfoController {
    private Scene scene;
    Stage stage ;

    @FXML
    Button LogOut,MainWindow,View,notification;
    @FXML
    TextField Category;
    @FXML
    Label omar;
    @FXML
    ListView<String> list,list2;
    @FXML
    private Parent root;
    public void logout (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
        root = loader.load();
        LoginController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Login.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
//        MYBANK.deleteClient("Omar");
        Bank.logout();
    }
    public void MainWindow (ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainWindow.fxml"));
        root = loader.load();
        MainWindowController c = loader.getController();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/MainWindow.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,1600,800);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
    public void editView(ActionEvent e) throws IOException
    {
        list.getItems().clear();
        Account myacc = Bank.clients.get(getCurrentCLinet()).getFirstAccount();
        int id = myacc.getId();
        String type = myacc.getType();
        double balance = myacc.getBalance();
        String msg = " Account ID :"+id+" \n Account Type:"+type+" \n Account Balance:"+String.format("%.2f",balance)+" \n-------------------------------------- ";
        list.getItems().add(msg);
    }
    public void editNotification(ActionEvent e) throws IOException
    {
        list2.getItems().clear();
        String arr="";
        String x="",y="",z="";
        ArrayList<Notification> mynot= Bank.clients.get(getCurrentCLinet()).notifications;
        if(mynot!=null) {
            for (int i = 0; i < Bank.clients.get(getCurrentCLinet()).notifications.size(); i++) {
                x = Bank.clients.get(getCurrentCLinet()).notifications.get(i).getSrc() + "\n";
                y = Bank.clients.get(getCurrentCLinet()).notifications.get(i).getTime() + "\n";
                z = Bank.clients.get(getCurrentCLinet()).notifications.get(i).getContent() + "\n";
                arr += " Source :" + x + " Date:" + y + " Amount $: " + z + "-------------------------------------- \n";

            }
        }

        list2.getItems().add(arr);
    }
}
