package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bill {
    private String src;
    private String time;
    private double amount;

    public Bill(String src, double amount) {
        this.time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        this.src = src;
        if(amount<=0)this.amount=0;
        else this.amount = amount;
    }

    public String getSrc() {
        return src;
    }

    public String getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
