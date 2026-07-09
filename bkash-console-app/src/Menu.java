import javax.xml.transform.dom.DOMSource;

public class Menu {

    BkashOperations bkash = new BkashOperations();

    public void start(){
        boolean f = true;
        while(f){

            IO.println("Bkash APP");
            IO.println("1 Register");
            IO.println("2 Login");
            IO.println("3 Exit");

            String ch = IO.readln("Chose an option : ");

            switch (ch){
                case "1" :
                    regMenu();
                    break;
                case "2":
                    loginMenu();
                    break;
                case "3":
                    f = false;
                    break;
                default :
                    IO.println("Invalid Option Try Again");
            }

        }
    }


    void regMenu(){
        IO.println("Register New Account");
        String name = IO.readln("Enter Your name: ");
        String phnNumber = IO.readln("Enter Your Phone Number : ");

        String pin =IO.readln("Set your pin: ");


        boolean f = bkash.regUser(name, phnNumber, pin);
        if(!f){
            IO.println("Failed to Regsiter! Try again");
        }


    }

    void loginMenu(){
        IO.println("Login");
        String phnNumber = IO.readln("Phone Number : ");
        String pin = IO.readln("PIN : ");

        User user = bkash.loginUser(phnNumber, pin);

        if(user == null){
            IO.println("Login Failed! Please Use Correct Phone Number and Pin");
        }else{
            IO.println("Welcome " + user.getName());
            bkashMainMenu(user);
        }
    }

    void bkashMainMenu(User user){
        boolean f = true;

        while(f){

            IO.println("Bkash");
            IO.println("1 Send Money");
            IO.println("2 Cash Out");
            IO.println("3 Mobile Recharge");
            IO.println("4 Payment Bills");
            IO.println("5 My Bkash");
            IO.println("6 Reset PIN");
            IO.println("7 Logout");

            String ch = IO.readln("Chose an option : ");

            switch (ch){
                case "1" :
                    sendMoneyMenu(user);
                    break;
                case "2":
                    cashOutMenu(user);
                    break;
                case "3":
                    mobileRechargmenu(user);
                    break;
                case "4" :
                    paymentMenu(user);
                    break;
                case "5":
                    myBkashMenu(user);
                    break;
                case "6":
                    resetPinMenu(user);
                    break;
                case "7":
                    f = false;
                    break;
                default :
                    IO.println("Invalid Option Try Again");
            }


        }
    }


    public void sendMoneyMenu(User user){
        String reciver = IO.readln("Enter Reciver Phone Number : ");
        double amount = Double.parseDouble(IO.readln("Enter amount : "));

        boolean f = bkash.sendMoney(user, reciver, amount);

        if(!f){
            IO.println("Try Again");
        }
    }

    public void cashOutMenu(User user){
        String agentNumber = IO.readln("Enter Agent Number : ");
        double amount = Double.parseDouble(IO.readln("Enter amount : "));

        boolean f = bkash.cashOut(user, agentNumber, amount);

        if(!f){
            IO.println("Try Again");
        }
    }

    public void mobileRechargmenu(User user){
        String phnNumber = IO.readln("Enter Phone Number : ");
        double amount = Double.parseDouble(IO.readln("Enter amount : "));

        boolean f = bkash.mobileRecharge(user, phnNumber, amount);

        if(!f){
            IO.println("Try Again");
        }
    }

    public void paymentMenu(User user){

        IO.println("Pay Bills");
        IO.println("1 Elctricity");
        IO.println("2 Gas");
        IO.println("3 Water");
        IO.println("4.Back");

        String ch = IO.readln("Chose and option : ");

        if(ch.equals("1") || ch.equals("2") || ch.equals("3")){
            String billID = IO.readln("Enter your BillID : ");
            double amount = Double.parseDouble(IO.readln("Enter amount : "));

            boolean f;

            if(ch == "1"){
                f = bkash.payElectricity(user, billID, amount);
            }else if(ch.equals("2")){
                f = bkash.payGasBill(user, billID, amount);
            }else if(ch.equals("3")){
                f = bkash.payWaterBill(user, billID, amount);
            }else{
                return;
            }

            if(!f){
                IO.println("Try Agin!");
            }
        }else{
            IO.println("Invalid Option");
        }

    }

    public void myBkashMenu(User user){
        bkash.myBkash(user);

    }

    public void resetPinMenu(User user){
        String oldpin = IO.readln("Enter your old pin : ");
        String newPin = IO.readln("Enter your new pin : ");

        boolean f = bkash.resetPin(user, oldpin, newPin);

        if(!f){
            IO.println("Try Agin!");
        }
    }

}
