import java.util.Stack;

public class Company {
    String cName;

    public String getName() {
        return cName;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return b;
    }

    double balance;
    Bank b;

    public Company(String name,double balance, Bank b) {
        this.cName=name;
        this.balance = balance;
        this.b = b;
    }

    public void addBill(String usrnm, String reason , double Bill_value){
        Client c = b.findClnt(usrnm);
        if (c==null){
            return;
        }
        else{
            c.getBill(new Bill(this.cName, reason, Bill_value));
        }
    }

    public void addBill(Client a, String reason , double Bill_value){
        a.getBill(new Bill(this.cName, reason, Bill_value));
    }

    public void initbalance(double b){ balance = b;}

}
