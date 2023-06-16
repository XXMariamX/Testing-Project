import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDriver {

    @Test
    public void testPersonConstructorAndGetters() {
        String firstName = "John";
        String middleName = "Doe";
        String lastName = "Smith";
        int age = 30;
        boolean isWorker = true;
        String usrName = "johndoe";
        String password = "password123";

        Bank b = new Bank();
        Admin person = new Admin(firstName, middleName, lastName, age, isWorker, usrName, password,1,"1", b);

        assertEquals(firstName, person.getFirstName());
        assertEquals(middleName, person.getMiddleName());
        assertEquals(lastName, person.getLastName());
        assertEquals(age, person.getAge());
        assertEquals(isWorker, person.isWorker());
        assertEquals(usrName, person.getUsrName());
        assertEquals(password, person.getPassword());
    }


    @Test
    public void testPersonCheckPass() {
        String firstName = "John";
        String middleName = "Doe";
        String lastName = "Smith";
        int age = 30;
        boolean isWorker = true;
        String usrName = "johndoe";
        String password = "password123";

        Bank b = new Bank();
        Admin person = new Admin(firstName, middleName, lastName, age, isWorker, usrName, password,1,"1", b);

        boolean result = person.checkPass("password123");

        assertTrue(result);

        person.setPassword("wrongPassword");
        assertEquals("wrongPassword", person.getPassword());
    }


}
