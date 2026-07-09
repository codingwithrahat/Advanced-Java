public class User extends Person{
    private String pin;
    private double balance;

    User(String name, String phnNumber, String pin, double balance){
        super(name, phnNumber);
        this.pin = pin;
        this.balance = balance;
    }

    String getPin(){
        return pin;
    }

    double getBalance(){
        return balance;
    }

    void setPin(String pin){
        this.pin = pin;
    }

    void subtractMoney(double amount){
        balance -= amount;
    }

    void addMoney(double amount){
        balance += amount;
    }

    void showProfileInfo(){
        IO.println("Acount Name : " + getName());
        IO.println("Phone Number : " + getPhnNumber());
        IO.println("Your Pin : " + pin);
        IO.println("Your Current Balance : " + balance);
    }





}
