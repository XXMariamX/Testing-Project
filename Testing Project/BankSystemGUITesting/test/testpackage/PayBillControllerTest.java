package testpackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.service.query.PointQuery;

import java.awt.*;
import java.util.Objects;

@ExtendWith(ApplicationExtension.class)

class PayBillControllerTest {
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
    @DisplayName("PayBill to Main")
    void ToMain(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#PayBill");
        robot.clickOn("#MainWindow");
    }

    @Test
    @DisplayName("PayBill to Login")
    void ToLogin(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#PayBill");
        robot.clickOn("#LogOut");
    }

    @Test
    @DisplayName("PayBill without selecting bill1")
    void TC3(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#PayBill");
        robot.clickOn("#pay");
    }

    @Test
    @DisplayName("PayBill without selecting bill1")
    void TC4(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#PayBill");
        robot.clickOn("#pay1");
        robot.clickOn("#pay");
    }

    @Test
    @DisplayName("PayBill ")
    void TC5(FxRobot robot) throws InterruptedException {
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#PayBill");
        robot.clickOn("#pay1");
        robot.clickOn("#pills");
        robot.clickOn(600,400);
        robot.clickOn("#pay");

    }

}