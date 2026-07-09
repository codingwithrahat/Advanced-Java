public class Agent extends Person{
    private double balance;

    Agent(String name, String phnNumber, double balance){
        super(name, phnNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    void substractMoney(double amount){
        balance -= amount;
    }

    void addMoney(double amount){
        balance += amount;
    }


}
