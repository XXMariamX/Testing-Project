import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminDriver {
    Bank b = new Bank();
    Admin F = new Admin("A","#","1",25,true,"A1","pass1",1,"1",b);
    driver d;

    class driver{
        public boolean format(Admin F,Bank b){
            F.addClient("c","#","1",25,"c1","pass1");
            F.addCompany("test comp",2000);
            b.findClnt("c1").addAcc(1,2000,"test type");
            if (b.findAcc(1).getBalance()!=2000)
                return false;
            b.findCompany("test comp").addBill(b.findClnt("c1"),"test",500);
            if (b.findClnt("c1").bills.get(0).getSrc().equals("test comp")!=true)
                return false;
            b.findClnt("c1").payBill(1,b.findClnt("c1").bills.get(0));
            if (b.findClnt("c1").accounts.get(0).getBalance()!=1500)
                return false;
            b.findClnt("c1").buy(1,"store","product",500);
            if (b.findClnt("c1").notifications.get(1).getSrc().equals("store")!= true)
                return false;
            return true;
        }
    }

    @Test
    @DisplayName("Admin driver test1")
    public void test1(){
        d = new driver();
        assertTrue(d.format(F,b));
    }

    @Test
    @DisplayName("Test getAuthority")
    public void testGetAuthority(){
        int authority = F.getAuthority();
        assertEquals(1, authority);
    }

    @Test
    @DisplayName("Test getLevel")
    public void testGetLevel(){
        String level = F.getLevel();
        assertEquals("1", level);
    }




}