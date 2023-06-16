import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client c1;
    Client c2;
    Bank b;

    @Nested
    class transfers {

        @BeforeEach
        public void init(){
            b=new Bank();
            c1=new Client("c","#","1",25,false,"c1","pass1",b);
            c2=new Client("c","#","2",25,false,"c2","pass2",b);
            c1.addAcc(1,2000,"savings");
            c1.addAcc(2,3000,"Purchases");
            c2.addAcc(3,1000,"Purchases");
        }

        @Test
        @DisplayName("same user different account")
        public void test1() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃    ClientTest1   ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━┛");
            c1.transfer(2,1,2000);
            System.out.println(c1.notifications.get(c1.notifications.size()-1).content);
            assertEquals(c1.findAcc(2).getBalance(),1000);
            assertEquals(c1.findAcc(1).getBalance(),4000);
        }

        @Test
        @DisplayName("different user different account")
        public void test2() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃    ClientTest2   ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━┛");
            c1.transfer(1,3,1000);
            System.out.println(c1.notifications.get(c1.notifications.size()-1).content);
            assertEquals(c1.findAcc(1).getBalance(),1000);
            assertEquals(c2.findAcc(3).getBalance(),2000);
        }

        @Test
        @DisplayName("same user same account")
        public void test3() {
            System.out.println("┏━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃    ClientTest3   ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━┛");
            c1.transfer(2,2,2000);
            System.out.println(c1.notifications.get(c1.notifications.size()-1).content);
            assertEquals(c1.findAcc(2).getBalance(),3000);
        }

        @AfterEach
        public void clean(){
            c1=null ;
            b=null;
        }

    }


}