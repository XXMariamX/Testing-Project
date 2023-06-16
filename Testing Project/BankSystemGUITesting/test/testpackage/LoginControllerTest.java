package testpackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)

class LoginControllerTest {

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
    @DisplayName("Invalid Password then Valid Login")
    void priTestFxTest(FxRobot robot) throws InterruptedException {
        Button LoginButton = robot.lookup("#LoginButton").queryAs(Button.class);
        assertNotNull(LoginButton);
        TextField x = robot.lookup("#UserName").queryAs(TextField.class);
        PasswordField y = robot.lookup("#Password").queryAs(PasswordField.class);
        robot.clickOn("#UserName").write("Mariam");
        robot.clickOn("#Password").write("2222");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Password").eraseText(4).write("123");
        assertEquals("Mariam", x.getText() );
        assertEquals("123", y.getText() );
        robot.clickOn("#LoginButton");
    }

    @Test
    @DisplayName("Invalid Password")
    void nextTest(FxRobot robot){
        robot.clickOn("#UserName");
        robot.write("ay haga");
        robot.clickOn("#LoginButton");
        robot.clickOn("#Password");
        robot.lookup("#failed").tryQuery().isPresent();
        Label failed = robot.lookup("#failed").queryAs(Label.class);
        assertNotNull(failed);

    }
}