import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankDriver {

    @Test
    public void testBankAddCompany() {
        Bank bank = new Bank();
        bank.addCompany("Company A", 1000);
        Company company = bank.findCompany("Company A");
        assertNotNull(company);
        assertEquals(1000, company.balance);
    }


    @Test
    public void testBankObject() {
        Bank bank = new Bank();
        bank.Bank();
        assertEquals(1, bank.viewClients().size());
    }

    @Test
    public void testBankFindClientByUsername() {
        Bank bank = new Bank();
        bank.addClient("Bob", "", "Johnson", 35, "bob", "password");
        Client client = bank.findClnt("bob");
        assertNotNull(client);
        assertEquals("Bob", client.getFirstName());
        assertEquals("Johnson", client.getLastName());
    }

    @Test
    public void testBankFindClientByUsername_NotFound() {
        Bank bank = new Bank();
        Client client = bank.findClnt("bob");
        assertNull(client);
    }

    @Test
    public void testBankFindCompanyByName() {
        Bank bank = new Bank();
        bank.addCompany("Company A", 1000);
        Company company = bank.findCompany("Company A");
        assertNotNull(company);
        assertEquals("Company A", company.cName);
        assertEquals(1000, company.balance);
    }

    @Test
    public void testBankFindCompanyByName_NotFound() {
        Bank bank = new Bank();
        Company company = bank.findCompany("Company A");
        assertNull(company);
    }

    @Test
    public void testBankConstructor() {
        Bank bank = new Bank();
        ArrayList<Client> clients = bank.viewClients();
        assertNotNull(clients);
    }


    @Test
    public void testBankDeleteClient() {
        Bank bank = new Bank();
        bank.addClient("Bob", "", "Johnson", 35, "bob", "password");
        boolean result = bank.deleteClient("bob");
        assertTrue(result); // Client with username "bob" should be deleted
        ArrayList<Client> clients = bank.viewClients();
        Client deletedClient = bank.findClnt("bob");
        assertNull(deletedClient); // Client should not be found after deletion
    }

    @Test
    public void testBankDeleteClient_NotFound() {
        Bank bank = new Bank();
        boolean result = bank.deleteClient("bob");
        assertFalse(result); // Client with username "bob" doesn't exist, deletion should fail
    }
}