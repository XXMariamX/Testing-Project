package model;

public abstract class Person {
    String FirstName;
    String MiddleName;
    String LastName;
    int age;
    boolean isWorker;
    String usrName;
    String password;

    public Person(String firstName, String middleName, String lastName, int age,boolean i, String usrName, String password) {
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        this.isWorker=i;
        this.age = age;
        this.usrName = usrName;
        this.password = password;
    }
    public String getUsrName() {
        return usrName;
    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return this.FirstName + ' ' + this.MiddleName +' '+ this.LastName;
    }
}
