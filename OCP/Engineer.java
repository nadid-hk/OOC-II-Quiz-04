public class Engineer implements Payable {
    private final int salary;
    
    public Engineer(int salary) {
        this.salary = salary;
    }
    
    @Override
    public int calculatePay() {
        return salary;
    }
    
    // Getter if needed
    public int getSalary() {
        return salary;
    }
}