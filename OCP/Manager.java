public class Manager implements Payable {
    private final int salary;
    private final int bonus;
    
    public Manager(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
    
    @Override
    public int calculatePay() {
        return salary + bonus;
    }
    
    // Getters if needed
    public int getSalary() {
        return salary;
    }
    
    public int getBonus() {
        return bonus;
    }
}