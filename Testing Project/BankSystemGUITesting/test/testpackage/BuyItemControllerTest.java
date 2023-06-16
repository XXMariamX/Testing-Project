package testpackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class BuyItemControllerTest {

    @Start
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        Scene scene = new Scene(root,1600, 800);
        stage.setScene(scene);
        stage.show();
        Image icon = new Image ("resources/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Online Banking");
        stage.setMaximized(true);
        stage.toFront();
        Bank b = new Bank();
    }

    @Test
    @DisplayName("Correctly Filled")
    void priTestFxTest(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#BuyItem");
        Button Buy = robot.lookup("#Buy").queryAs(Button.class);
        assertNotNull(Buy);
        robot.clickOn("#ID").write("1");
        robot.clickOn("#StoreName").write("store1");
        robot.clickOn("#ProductName").write("product1");
        robot.clickOn("#Price").write("2000");
        robot.clickOn("#Buy");

    }

    @Test
    @DisplayName("Incorrect Fill")
    void failed(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#BuyItem");
        Button Buy = robot.lookup("#Buy").queryAs(Button.class);
        assertNotNull(Buy);
        robot.clickOn("#ID").write("char");
        robot.clickOn("#StoreName").write("store1");
        robot.clickOn("#ProductName").write("product1");
        robot.clickOn("#Price").write("char");
        robot.clickOn("#Buy");
        robot.lookup("#failed").tryQuery().isPresent();
        Label failed = robot.lookup("#failed").queryAs(Label.class);
        assertNotNull(failed);
    }
    @Test
    @DisplayName("Transition to main Window")
    void toMain(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#BuyItem");
        robot.clickOn("#MainWindow");
    }

    @Test
    @DisplayName("Transition to Login")
    void toLogin(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#BuyItem");
        robot.clickOn("#LogOut");
    }
}