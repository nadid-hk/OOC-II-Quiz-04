public class App {
    public static void main(String[] args) {
        TransactionRepository repository = new InMemoryTransactionRepository();
        Clock clock = new Clock();
        Console console = new Console();
        PrintStatementService printService = new PrintStatementService(console);
        AccountService account = new AccountService(repository, clock, printService);
        
        account.deposit(1000);
        account.deposit(500);
        account.withdraw(200);
        account.printStatement();
    }
}