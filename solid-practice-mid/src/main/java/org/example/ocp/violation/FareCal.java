package org.example.ocp.violation;

public class FareCal {
    void cal(String type){
        if(type.equals("BUS")) {
            IO.println("40 taka");
        }

        if(type.equals("CNG")) {
            IO.println("400 taka");
        }
    }
}
