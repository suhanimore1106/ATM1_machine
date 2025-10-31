@RestController
@RequestMapping("/api/atm")
public class AtmController {
    @Autowired
    private AtmService atmService;

    @PostMapping("/authenticate")
    public ResponseEntity<Account> authenticate(@RequestBody AuthenticationRequest request) {
        Account account = atmService.authenticate(request.getAccountNumber(), request.getPin());
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<Double> getBalance(@PathVariable String accountNumber) {
        double balance = atmService.getBalance(accountNumber);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestBody DepositRequest request) {
        atmService.deposit(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdraw(@RequestBody WithdrawRequest request) {
        atmService.withdraw(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok().build();
    }
}

class AuthenticationRequest {
    private String accountNumber;
    private String pin;

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

class DepositRequest {
    private String accountNumber;
    private double amount;

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class WithdrawRequest {
    private String accountNumber;
    private double amount;

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}