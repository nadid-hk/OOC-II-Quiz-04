import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public InMemoryEmployeeRepository() {
        employees.add(new Employee("John", "Doe",
                java.time.LocalDate.of(1995, 4, 4), "john@example.com"));

        employees.add(new Employee("Jane", "Smith",
                java.time.LocalDate.of(1990, 1, 1), "jane@example.com"));
    }

    @Override
    public List<Employee> findEmployeesBornOn(MonthDay monthDay) {
        List<Employee> result = new ArrayList<>();

        for (Employee e : employees) {
            if (MonthDay.from(e.getDateOfBirth()).equals(monthDay)) {
                result.add(e);
            }
        }

        return result;
    }
}