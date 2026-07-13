public class SalaryCalculator {

    double houseCost = 1000;
    double healtCost = 500;

    double getSalary(Employee e){
        return houseCost + healtCost + e.getBasicSalary();
    }

}
