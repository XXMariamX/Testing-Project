import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PaybillTest {
    Client c1;
    Bill d1;
    Bill d2;
    Bank b;

    @Nested
    class transfers {

        @BeforeEach
        public void init(){
            b=new Bank();
            d1=new Bill("Company1","water bill",2000);
            d2=new Bill("Company1","water bill",10000);
            c1=new Client("c","#","1",25,false,"c1","pass1",b);
            c1.addAcc(1,3000,"Purchases");
        }

        @Test
        @DisplayName("bill under budget")
        public void test1() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃     PaybillTest1   ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
            c1.payBill(1,d1);
            System.out.println(c1.notifications.get(c1.notifications.size()-1).content);
            assertEquals(c1.findAcc(1).getBalance(),1000);
        }

        @Test
        @DisplayName("bill over budget")
        public void test2() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃    PaybillTest2    ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
            c1.payBill(1,d2);
            System.out.println(c1.notifications.get(c1.notifications.size()-1).content);
            assertEquals(c1.findAcc(1).getBalance(),3000);
        }

        @AfterEach
        public void clean(){
            c1=null ;
            b=null;
        }

    }

}