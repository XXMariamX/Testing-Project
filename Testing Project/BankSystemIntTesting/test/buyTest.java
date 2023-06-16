import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class buyTest {
    Client c1;
    Bank b;

    @Nested
    class transfers {

        @BeforeEach
        public void init(){
            b=new Bank();
            c1=new Client("c","#","1",25,false,"c1","pass1",b);
            c1.addAcc(1,3000,"Purchases");
        }

        @Test
        @DisplayName("item under budget")
        public void test1() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃      BuyTest1     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━┛");
            c1.buy(1,"store","product",200);
            System.out.println(c1.notifications.get(c1.notifications.size()-1).content);
            assertEquals(c1.findAcc(1).getBalance(),2800);
        }

        @Test
        @DisplayName("item over budget")
        public void test2() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃      BuyTest2     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━┛");
            c1.buy(1,"store","product",4000);
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
