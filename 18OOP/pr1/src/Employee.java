public class Employee extends Person {
    private double baseSalary;

    public Employee(int age, String name, double baseSary) {
        super(age, name);
        this.baseSalary = baseSary;
    }

    public double getSalary() {
        return baseSalary * 1.1;
    }

    public double getSalary(double coefficient) { // overloading
        return baseSalary * coefficient;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double value){
        this.baseSalary = value;
    }

    @Override // overriding
    public String getPersonalInfo() {
        return super.getPersonalInfo() + ", salary: " + getSalary();
    }

    @Override
    public String sayHello() {
        return null;
    }
}
