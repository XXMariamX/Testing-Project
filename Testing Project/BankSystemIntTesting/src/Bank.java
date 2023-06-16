import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients= new ArrayList<Client>();
    private ArrayList<Account> accounts= new ArrayList<Account>();
    private ArrayList<Company> companies= new ArrayList<Company>();

    public void Bank(){
        this.addClient("Omar","Mohamed","Elsayed",20,"Omar","Omar");
    }

    public boolean addClient(String firstName, String middleName, String lastName, int age, String usrName, String password){
        clients.add(new Client( firstName,  middleName,  lastName,  age,  false,  usrName,  password,this));
        return true;
    }

    public boolean addCompany(String name,double balance){
        companies.add(new Company(name, balance, this));
        return true;
    }

    public void addAccount(Client c){
        Account tmp = c.accounts.get(c.accounts.size()-1);
        accounts.add(tmp);
    }

    public Client findClnt(String usrnm){
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

    boolean deleteClient(String userName){
        for(int i = 0; i < clients.size(); i++){
            if(userName.equals(clients.get(i).getUsrName())){
                clients.remove(i);
                return true;
            }
        }
        return false;
    }

    ArrayList<Client> viewClients(){
        return clients;
    }

}
