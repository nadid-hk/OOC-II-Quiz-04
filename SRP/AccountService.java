import java.util.List;
public class AccountService {
    private TransactionRepository transactionRepository;
    private Clock clock;
    private PrintStatementService printStatementService;
    
    public AccountService(TransactionRepository transactionRepository, 
                          Clock clock, 
                          PrintStatementService printStatementService) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.printStatementService = printStatementService;
    }
    
    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }
    
    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }
    
    public void printStatement() {
        List<Transaction> transactions = transactionRepository.all();
        printStatementService.printStatement(transactions);
    }
    
    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }
}