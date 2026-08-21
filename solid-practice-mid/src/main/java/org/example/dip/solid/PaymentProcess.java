package org.example.dip.solid;

public class PaymentProcess {
    Payment payment;

    public PaymentProcess(Payment payment){
        this.payment = payment;
    }

    public void makePayment(double taka){
        payment.pay(taka);
    }
}
