public class ReportGenerator {
    void employeeReport(Employee e, SalaryCalculator s){
        IO.println("Name : " + e.getName());
        IO.println("Salary : " + s.getSalary(e));
    }

}
