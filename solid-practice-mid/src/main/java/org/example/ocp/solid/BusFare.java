package org.example.ocp.solid;

public class BusFare implements FareCal {

    @Override
    public void cal() {
        IO.println("40 taka");
    }
}
