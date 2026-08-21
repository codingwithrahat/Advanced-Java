package org.example.dip.solid;

public class NagadPay implements Payment{
    @Override
    public void pay(double taka){
        IO.println("Paid " + taka + "using Nagad");
    }
}
