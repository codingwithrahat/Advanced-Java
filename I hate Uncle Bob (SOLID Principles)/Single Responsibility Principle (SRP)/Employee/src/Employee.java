public class Employee {
    private String name;
    private double basicSalary;

    Employee(String name,  double basicSalary){
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}
