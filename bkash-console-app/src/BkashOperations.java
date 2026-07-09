import java.util.ArrayList;

public class BkashOperations implements Operations{

    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Agent> agentList = new ArrayList<>();

    private double cashout_crg = 20.0;

    BkashOperations(){
        userList.add(new User("Rakib", "01811111111", "1234", 5000.0));
        userList.add(new User("Rahat", "01822222222", "1234",5000.0));
        userList.add(new User("Monirul", "01833333333", "1234",5000.0));

        agentList.add(new Agent("Sarawer Enterprise", "01711111111", 50000.0));
        agentList.add(new Agent("Siam Shop Limited", "01722222222", 50000.0));
        agentList.add(new Agent("Nazmul Mayer Dowa", "01733333333", 50000.0));
    }

    boolean isPhnReg(String phnNumber){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getPhnNumber().equals(phnNumber)){
                return true;
            }
        }

        for(int i = 0; i < agentList.size(); i++){
            if(agentList.get(i).getPhnNumber().equals(phnNumber)){
                return true;
            }
        }


        return false;
    }

    boolean regUser(String name, String phnNumber, String pin){

        for(int i = 0; i<phnNumber.length(); i++){
            if(!Character.isDigit(phnNumber.charAt(i))){
                IO.println("Number should be digit");
                return false;
            }
        }

        if(phnNumber.length() != 11){
            IO.println("Phone number must be 11 digit");
            return false;
        }

        if(phnNumber.charAt(0) != '0' && phnNumber.charAt(1) != 1){
            IO.println("Phone Number must be start with 01");
            return false;
        }

        if(isPhnReg(phnNumber)){
            System.out.println("Phone number already registered");
            return false;
        }

        User newUser = new User(name, phnNumber, pin, 5000);
        userList.add(newUser);
        IO.println("Sucessfully Register");
        return true;
    }

    User loginUser(String phnNumber, String pin){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getPhnNumber().equals(phnNumber) && userList.get(i).getPin().equals(pin)){
                return userList.get(i);
            }
        }
        return null;
    }

    User findUserByNumber(String phnNumber){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getPhnNumber().equals(phnNumber)){
                return userList.get(i);
            }
        }
        return null;
    }

    Agent findAgentByNumber(String phnNumber){
        for(int i = 0; i < agentList.size(); i++){
            if(agentList.get(i).getPhnNumber().equals(phnNumber)){
                return agentList.get(i);
            }
        }
        return null;
    }

    boolean payBill(User user, String billType, String billID, double amount){
        if(amount < 0){
            IO.println("Invalid Amount");
            return false;
        }

        if(user.getBalance() < amount){
            IO.println("Insufficient balance");
            return false;
        }

        user.subtractMoney(amount);
        IO.println(billType + "Bill of Taka " + amount + "paid successfully for BILL ID " + billID);
        return true;
    }



    @Override
    public boolean sendMoney(User sender, String reciverPhnNumber, double amount) {
        if(amount < 0){
            IO.println("Invalid Amount");
            return false;
        }

        if(sender.getPhnNumber().equals(reciverPhnNumber)){
            IO.println("It's your own number, Send money not possible");
            return false;
        }

        User reciver = findUserByNumber(reciverPhnNumber);

        if(reciver == null){
            IO.println("Reciver Phone Number is not exists");
            return false;
        }

        if(sender.getBalance() < amount){
            IO.println("Insufficient balance");
            return false;
        }

        sender.subtractMoney(amount);
        reciver.addMoney(amount);

        IO.println("Taka " + amount + "succesfuly Send to " + reciver.getPhnNumber() + "(" + reciver.getName() + ")");
        return true;
    }

    @Override
    public boolean cashOut(User user, String agentNumber, double amount) {
        if(amount < 0){
            IO.println("Invalid Amount");
            return false;
        }

        Agent agent = findAgentByNumber(agentNumber);

        if(agent == null){
            IO.println("Agent number not found!");
            return false;
        }

        double charge = (amount * cashout_crg) / 1000;
        double totalAmount = amount + charge;

        if(user.getBalance() < totalAmount){
            IO.println("Insufficient balance");
            return false;
        }

        user.subtractMoney(totalAmount);
        agent.addMoney(totalAmount);

        IO.println("Cash Out Taka " + amount + "Succesful via agent" + agent.getPhnNumber() + "(" + agent.getName() + ")");
        IO.println("Charge :" + amount);
        return true;
    }

    @Override
    public boolean mobileRecharge(User user, String phnNumber, double amount) {

        for(int i = 0; i<phnNumber.length(); i++){
            if(!Character.isDigit(phnNumber.charAt(i))){
                IO.println("Number should be digit");
                return false;
            }
        }

        if(phnNumber.length() != 11){
            IO.println("Phone number must be 11 digit");
            return false;
        }

        if(phnNumber.charAt(0) != '0' && phnNumber.charAt(1) != 1){
            IO.println("Phone Number must be start with 01");
            return false;
        }

        if(amount < 20){
            IO.println("Invalid Amount! less than 20 taka is not allow");
            return false;
        }

        if(user.getBalance() < amount){
            IO.println("Insufficient balance");
            return false;
        }


        user.subtractMoney(amount);
        IO.println("Recharge taka : " + amount + "Sucecsfull to " + user.getPhnNumber());
        return true;
    }

    @Override
    public boolean payElectricity(User user, String billerID, double amount) {
        return payBill(user, "Electricity", billerID, amount);
    }

    @Override
    public boolean payGasBill(User user, String billerID, double amount) {
        return payBill(user, "Gas", billerID, amount);
    }

    @Override
    public boolean payWaterBill(User user, String billerID, double amount) {
        return payBill(user, "Water", billerID, amount);
    }


    @Override
    public void myBkash(User user) {
        user.showProfileInfo();
    }

    @Override
    public boolean resetPin(User user, String oldPin, String newPin) {
        if(!user.getPin().equals(oldPin)){
            IO.println("Old pin is inrcorrect");
            return false;
        }

        if(oldPin.equals(newPin)){
            IO.println("New pin and old pin can't be same");
            return false;
        }

        user.setPin(newPin);
        IO.println("Pin Reset Successfully");
        return true;
    }
}
