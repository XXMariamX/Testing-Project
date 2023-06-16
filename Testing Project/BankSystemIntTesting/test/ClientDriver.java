import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientDriver {
    Client c = new Client("c","#","1",25,false,"c1","pass1", new Bank());
    driver d;
    class driver{
        public boolean format(Client c){
            c.buy(1,"store","product",200);
            if(c.accounts.get(0).getBalance()!=800){
                System.out.println("buy failed");
                return false;}
            c.transfer(1,2,200);
            if(c.accounts.get(0).getBalance()!=600 || c.accounts.get(1).getBalance()!=1200) {
                System.out.println("transfer failed");
                return false;
            }
            c.payBill(1,c.bills.get(0));
            if(c.accounts.get(0).getBalance()!=400) {
                System.out.println("bill failed");
                return false;
            }
            if(c.notifications.get(0).getSrc().equals("store")!= true) {
                System.out.println("notification failed");
                return false;
            }
            return true;
        }
    }

    @Test
    @DisplayName("Client driver test1")
    public void test1(){
        d = new driver();
        c.addAcc(1,1000,"tst type");
        c.addAcc(2,1000,"tst type");
        c.getBill(new Bill("tst src","tst bill",200));
        c.getBill(new Bill("tst src","tst bill",200));
        assertTrue(d.format(c));
    }


    @Test
    @DisplayName("Client driver test2")
    public void testViewAccs(){
        Client testClient = new Client("c","#","1",25,false,"c1","pass1", new Bank());
        String result = testClient.viewAccs();
        assertEquals("No accounts found", result);
        testClient.addAcc(1,1000,"tst type");
        result = testClient.viewAccs();
        assertEquals("That is all accounts", result);
    }


}