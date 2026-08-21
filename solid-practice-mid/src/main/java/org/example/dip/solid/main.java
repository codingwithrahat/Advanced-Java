import org.example.dip.solid.BkashPay;
import org.example.dip.solid.NagadPay;
import org.example.dip.solid.Payment;
import org.example.dip.solid.PaymentProcess;

void main(){
    PaymentProcess process = new PaymentProcess(new BkashPay());
    PaymentProcess process1 = new PaymentProcess(new NagadPay());

    process1.makePayment(2000);
    process.makePayment(1000);
}