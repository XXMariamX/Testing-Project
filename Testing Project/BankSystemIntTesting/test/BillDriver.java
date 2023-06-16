import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BillDriver {

    class driver1{
        public  Bill received;
        public boolean format(Bill s) {
            String billSrc= s.getSrc();
            if (billSrc.equals("water comp.")) {
                return true;
            }
            return false;
        }

        public void getBill(Bill a){
            this.received = a;
        }
    }

    class driver2{
        driver1 l= new driver1();


        public driver2(Bill s){

            this.l.getBill(s);

        }
    }

    Bill b1;
    driver1 d1;
    driver2 d2;

    @Test
    @DisplayName("Bill driver1 test1")
    public void testDriver1_1(){
        b1 =new Bill("water comp.","test bill 1",2000);
        d1=new driver1();
        assertTrue(d1.format(b1));
    }

    @Test
    @DisplayName("Bill driver1 test2")
    public void testDriver1_2(){
        b1 =new Bill("electrical comp.","test bill 1",2000);
        d1=new driver1();
        assertFalse(d1.format(b1));
    }

    @Test
    @DisplayName("Bill driver2 test1")
    public void testDriver2_1(){
        b1 =new Bill("water comp.","test bill 2",2000);
        d2=new driver2(b1);
        assertEquals(d2.l.received.getContent(),("test bill 2"));

    }

    @Test
    public void testBillConstructorAndGetters() {
        String src = "ABC Company";
        String content = "Purchase";
        double amount = 100.0;

        Bill bill = new Bill(src, content, amount);

        assertEquals(src, bill.getSrc());
        assertNotNull(bill.getTime());
        assertEquals(content, bill.getContent());
        assertEquals(amount, bill.getAmount());
    }

    @Test
    public void testBillSetAmount() {
        Bill bill = new Bill("ABC Company", "Purchase", 100);
        bill.setAmount(200);
        assertEquals(200, bill.getAmount());
    }

    @Test
    public void testBillTimeIsSetToCurrentTime() {
        String expectedFormat = "yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat);

        String currentTime = LocalDateTime.now().format(formatter);
        Bill bill = new Bill("ABC Company", "Purchase", 100.0);

        assertEquals(currentTime, bill.getTime());
    }


}
