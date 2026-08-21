package org.example.dip.solid;

public class BkashPay implements Payment{

    @Override
    public void pay(double taka){
        IO.println("Paid " + taka + "Using Bkash");
    }
}
