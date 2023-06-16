package testpackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Bank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)

class InfoControllerTest {

    @Start
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
        stage.toFront();
    }

    @Test
    @DisplayName("Info to Main")
    void infoToMain(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Info");
        robot.clickOn("#MainWindow");
    }

    @Test
    @DisplayName("Info to Login")
    void infoToLogin(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Info");
        robot.clickOn("#LogOut");
    }

    @Test
    @DisplayName("View Statement")
    void viewStmnt(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Info");
        robot.clickOn("#View");
    }
    @Test
    @DisplayName("View Empty Notifications")
    void emptyNtf(FxRobot robot) {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Info");
        robot.clickOn("#notification");
    }
    @Test
    @DisplayName("View Full Notifications")
    void viewNtf(FxRobot robot)  {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");

        robot.clickOn("#BuyItem");
        robot.clickOn("#ID").write("1");
        robot.clickOn("#StoreName").write("store1");
        robot.clickOn("#ProductName").write("product1");
        robot.clickOn("#Price").write("50.99");
        robot.clickOn("#Buy");

        robot.clickOn("#MainWindow");
        robot.clickOn("#Info");
        robot.clickOn("#notification");
        robot.clickOn("#View");
        robot.clickOn("#MainWindow");

        robot.clickOn("#PayBill");
        robot.clickOn("#pay1");
        robot.clickOn("#pills");
        robot.clickOn(600,400);
        robot.clickOn("#pay");

        robot.clickOn("#MainWindow");
        robot.clickOn("#Info");
        robot.clickOn("#notification");
        robot.clickOn("#View");
        robot.clickOn("#MainWindow");

        robot.clickOn("#Transfer");
        robot.clickOn("#To").write("2");
        robot.clickOn("#Amount").write("1000.99");
        robot.clickOn("#Transfer");

        robot.clickOn("#MainWindow");
        robot.clickOn("#Info");
        robot.clickOn("#notification");
        robot.clickOn("#View");
        robot.clickOn("#View");
    }
}