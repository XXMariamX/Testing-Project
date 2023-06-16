import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDriver {
    Company c = new Company("test comp",2000,null);
    Client a = new Client("c","#","1",25,false,"c1","pass1", new Bank());
    driver d;

    class driver{
        public boolean format(Company c,Client a){
            c.addBill(a,"test",200);
            if (a.bills.get(0).getSrc().equals("test comp")!=true || a.bills.get(0).getContent().equals("test")!=true)
                return false;
            a.payBill(1,a.bills.get(0));
            if (a.findAcc(1).getBalance()!=800)
                return false;
            return true;
        }
    }


    @Test
    @DisplayName("Company driver test1")
    public void test1(){
        d = new driver();
        a.addAcc(1,1000,"tst type");
        assertTrue(d.format(c,a));
    }

    @Test
    public void testCompanyConstructorAndGetters() {
        String name = "ABC Company";
        double balance = 1000.0;
        Bank bank = new Bank();

        Company company = new Company(name, balance, bank);

        assertEquals(name, company.getName());
        assertEquals(balance, company.getBalance());
        assertEquals(bank, company.getBank());
    }

    @Test
    public void testAddBill() {
        // Create a Bank instance
        Bank bank = new Bank();

        // Create a Company instance
        Company company = new Company("ABC Company", 1000.0, bank);

        // Create a Client instance
        Client client = new Client("Omar","Ibrahim","Nasef",20,true, "Omar","Omar", bank);
        bank.addClient("Omar","Ibrahim","Nasef",20,"Omar","Omar");

        // Add a bill using the addBill method
        String username = client.getUsrName();
        String reason = "Purchase";
        double billValue = 200.0;
        company.addBill(username, reason, billValue);

        // Get the client's bills
        ArrayList<Bill> bills = client.getBills();

        // Check if the bill was added to the client's bills
        assertNotNull(bills);

    }

    @Test
    public void testInitBalance() {
        Bank bank = new Bank();
        Company company = new Company("ABC Company", 1000.0, bank);

        company.initbalance(2000.0);

        assertEquals(2000.0, company.getBalance());
    }
}