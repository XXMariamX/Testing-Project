package model;

import java.util.ArrayList;

public  class Bank {
    public static ArrayList<Client> clients= new ArrayList<Client>();
    public static ArrayList<Account> accounts= new ArrayList<Account>();
    public static ArrayList<Company> companies= new ArrayList<Company>();

    public static Bank MYBANK;

    public static int currentCLinet;


    public void addClient(String firstName, String middleName, String lastName, int age, String usrName, String password){
        clients.add(new Client( firstName,  middleName,  lastName,  age,  false,  usrName,  password, MYBANK));
    }
    public Bank(){
        MYBANK = this;
        clients.add(new Client("Ibarhim ","Ashraf","Ibrahim",20,false,"ibra","ibra", MYBANK));
        clients.add(new Client("Mariam","","",20,false,"Mariam","123", MYBANK));
        clients.add(new Client("Ibrahim","","",20,false,"Ibrahim","555", MYBANK));

        clients.get(0).addAcc(1, 10000, "Savings");
        clients.get(1).addAcc(2, 50000, " Money Market");
        clients.get(2).addAcc(3, 400750.50, "Certificate of Deposit");


        currentCLinet= -1;

    }
    public void addCompany(String name, double balance){
        companies.add(new Company(name, balance, MYBANK));
    }

    public void addAccount(Client c){
        Account tmp = c.accounts.get(c.accounts.size()-1);
        accounts.add(tmp);
    }

    public static Client findClnt(String usrnm){
        for (int i = 0;i<clients.size();i++){
            if (clients.get(i).getUsrName().equals(usrnm)){
                return clients.get(i);
            }
        }
        return null;
    }

    public Company findCompany(String name){
        for (int i = 0;i<companies.size();i++){
            if (companies.get(i).cName.equals(name)){
                return companies.get(i);
            }
        }
        return null;
    }

    public Account findAcc(int id){
        for (int i = 0;i<accounts.size();i++){
            if (accounts.get(i).getId()==id){
                return accounts.get(i);
            }
        }
        return null;
    }

//    public boolean deleteClient(String userName){
//        for(int i = 0; i < clients.size(); i++){
//            if(userName.equals(clients.get(i).getUsrName())){
//                clients.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }

    ArrayList<Client> viewClients(){
        return clients;
    }

    public static String login(String username,String password) {
        for (int i = 0; i < clients.size(); i++) {
           Boolean x=username.equals(clients.get(i).getUsrName());
            if (username.equals(clients.get(i).getUsrName())) {
                if (password.equals(clients.get(i).getPassword())) {
                    currentCLinet = i;
                    return "";
                }
                else return "Invalid Password !";
            }
        }
        return "Invalid Username !";
    }

    public static void logout(){
        currentCLinet = -1;
    }

    public static int getCurrentCLinet() {
        return currentCLinet;
    }

    public static void setCurrentCLinet(int currentCLinet) {
        Bank.currentCLinet = currentCLinet;
    }
}
