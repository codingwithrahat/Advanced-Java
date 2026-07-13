void main(){
    PaymentProcessor p = new PayPalPayment();

    PaymentService ps = new PaymentService(p, 4000);

    ps.paymentPay();
}