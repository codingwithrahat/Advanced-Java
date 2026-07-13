void main(){
    Employee e = new Employee("Rahat", 40000);
    SalaryCalculator s = new SalaryCalculator();
    ReportGenerator r = new ReportGenerator();

    r.employeeReport(e, s);

}