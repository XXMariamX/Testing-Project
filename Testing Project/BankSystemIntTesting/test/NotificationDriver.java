import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class NotificationDriver {

    class driver{
        public boolean format(Notification n){
            String billSrc= n.getContent();
            if (billSrc.equals("this content is right")){
                return true;
            }
            return false;
        }
    }

    Notification n1;
    driver d1;

    @Test
    @DisplayName("Notification driver test1")
    public void test1(){
        n1 =new Notification("tmp src","this content is right");
        d1=new driver();
        assertTrue(d1.format(n1));
    }

    @Test
    @DisplayName("Notification driver test2")
    public void test2(){
        n1 =new Notification("tmp src","this content is wrong");
        d1=new driver();
        assertFalse(d1.format(n1));
    }

    @Test
    public void testGetTime() {
        String expectedFormat = "yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat);

        LocalDateTime currentTime = LocalDateTime.now();
        String expectedTime = currentTime.format(formatter);

        Notification notification = new Notification("Source", "Content");

        String actualTime = notification.getTime();

        assertEquals(expectedTime, actualTime);
    }


}
