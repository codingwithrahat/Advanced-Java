public interface Operations {
    boolean sendMoney(User user, String reciverPhnNumber, double amount);
    boolean cashOut(User user, String agentNumber, double amount);
    boolean mobileRecharge(User user, String phnNumber, double amount);
    boolean payElectricity(User user, String billerID, double amount);
    boolean payGasBill(User user, String billerID, double amount);
    boolean payWaterBill(User user, String billerID, double amount);
    void myBkash(User user);
    boolean resetPin(User user, String oldPin, String newPin);
}
