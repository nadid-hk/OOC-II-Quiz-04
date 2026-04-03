import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private final EmailService emailService;

    public BirthdayGreeter(EmployeeRepository employeeRepository,
                           Clock clock,
                           EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
        this.emailService = emailService;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();

        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(emailService::send);
    }

    private Email emailFor(Employee employee) {
        String message = String.format(
                "Happy birthday, dear %s!",
                employee.getFirstName()
        );
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }
}