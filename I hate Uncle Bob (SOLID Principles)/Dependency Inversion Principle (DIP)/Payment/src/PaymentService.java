public class PaymentService {
    PaymentProcessor p;
    double amount;

    PaymentService(PaymentProcessor p, double amount){
        this.p = p;
        this.amount = amount;
    }

    void paymentPay(){
        p.pay(amount);
    }
}
