import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDriver {


    @Test
    @DisplayName("Test getId")
    public void testGetId() {
        Account account = new Account(1);
        int expectedId = 1;
        int actualId = account.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    @DisplayName("Test getBalance")
    public void testGetBalance() {
        Account account = new Account(1, 100.0, "Savings");
        double expectedBalance = 100.0;
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test setBalance")
    public void testSetBalance() {
        Account account = new Account(1);
        double newBalance = 500.0;
        account.setBalance(newBalance);
        double expectedBalance = 500.0;
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test getType")
    public void testGetType() {
        Account account = new Account(1, 1000.0, "Checking");
        String expectedType = "Checking";
        String actualType = account.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    @DisplayName("Test setType")
    public void testSetType() {
        Account account = new Account(1);
        String newType = "Savings";
        account.setType(newType);
        String expectedType = "Savings";
        String actualType = account.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    @DisplayName("Test withdraw with sufficient balance")
    public void testWithdrawSufficientBalance() {
        Account account = new Account(1, 500.0, "Savings");
        double withdrawalAmount = 200.0;
        account.withdraw(withdrawalAmount);
        double expectedBalance = 300.0;
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test withdraw with insufficient balance")
    public void testWithdrawInsufficientBalance() {
        Account account = new Account(1, 100.0, "Checking");
        double withdrawalAmount = 200.0;
        account.withdraw(withdrawalAmount);
        double expectedBalance = 100.0;
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test deposit")
    public void testDeposit() {
        Account account = new Account(1);
        double depositAmount = 500.0;
        account.deposit(depositAmount);
        double expectedBalance = 500.0;
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }



}