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

class TransferControllerTest {

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
//50000
    @Test
    @DisplayName("Insufficient Amount")
    void TC1(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Transfer");
        Button Buy = robot.lookup("#Transfer").queryAs(Button.class);
        assertNotNull(Buy);
        robot.clickOn("#To").write("2");
        robot.clickOn("#Amount").write("50000.99");
        robot.clickOn("#Transfer");
    }

    @Test
    @DisplayName("Valid Transfer")
    void priTestFxTest(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Transfer");
        Button Buy = robot.lookup("#Transfer").queryAs(Button.class);
        assertNotNull(Buy);
        robot.clickOn("#To").write("2");
        robot.clickOn("#Amount").write("1000.99");
        robot.clickOn("#Transfer");
    }

    @DisplayName("Incorrect Format")
    @Test
    void failed(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Transfer");
        Button Buy = robot.lookup("#Transfer").queryAs(Button.class);
        assertNotNull(Buy);
        robot.clickOn("#To");
        robot.write("2");
        robot.clickOn("#Amount");
        robot.write("two thousand");
        robot.clickOn("#Transfer");
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
        robot.clickOn("#Transfer");
        robot.clickOn("#MainWindow");
    }

    @Test
    @DisplayName("Transition to Login")
    void toLogin(FxRobot robot){
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("123");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Transfer");
        robot.clickOn("#LogOut");
    }


}
