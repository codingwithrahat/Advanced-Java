package org.example.dip.violation;

public class PaymentProcess {
    BkashPay bkashPay = new BkashPay();

    void makePayment(double taka){
        bkashPay.pay(taka);
    }
}
