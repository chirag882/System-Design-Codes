// Interface
interface BankAccount {
    void validateUserIdentity();
    void calculateInterestRate();
    void registerAccount();
}

// Concrete Products
class PersonalAccount implements BankAccount {
    @Override
    public void validateUserIdentity() { System.out.println("Validating Personal Account User..."); }
    @Override
    public void calculateInterestRate() { System.out.println("Personal Account Interest: 4%"); }
    @Override
    public void registerAccount() { System.out.println("Personal Account Registered."); }
}

class BusinessAccount implements BankAccount {
    @Override
    public void validateUserIdentity() { System.out.println("Validating Business Account User..."); }
    @Override
    public void calculateInterestRate() { System.out.println("Business Account Interest: 6%"); }
    @Override
    public void registerAccount() { System.out.println("Business Account Registered."); }
}

class CheckingAccount implements BankAccount {
    @Override
    public void validateUserIdentity() { System.out.println("Validating Checking Account User..."); }
    @Override
    public void calculateInterestRate() { System.out.println("Checking Account Interest: 3%"); }
    @Override
    public void registerAccount() { System.out.println("Checking Account Registered."); }
}

// Abstract Factory
abstract class BankAccountFactory {
    public abstract BankAccount createAccount(String type);
}

// Local Factory
class LocalBankAccountFactory extends BankAccountFactory {
    @Override
    public BankAccount createAccount(String type) {
        if (type.equalsIgnoreCase("P")) return new PersonalAccount();
        if (type.equalsIgnoreCase("B")) return new BusinessAccount();
        if (type.equalsIgnoreCase("C")) return new CheckingAccount();
        System.out.println("Invalid account type for Local Branch!");
        return null;
    }
}

// Foreign Factory with custom logic
class ForeignBankAccountFactory extends BankAccountFactory {
    @Override
    public BankAccount createAccount(String type) {
        if (type.equalsIgnoreCase("P")) {
            System.out.println("Applying extra KYC for foreign Personal Account...");
            return new PersonalAccount();
        }
        if (type.equalsIgnoreCase("B")) {
            System.out.println("Extra tax compliance for foreign Business Account...");
            return new BusinessAccount();
        }
        if (type.equalsIgnoreCase("C")) {
            System.out.println("Foreign Checking Account has different policies...");
            return new CheckingAccount();
        }
        System.out.println("Invalid account type for Foreign Branch!");
        return null;
    }
}

// Branch class using Factory Method
class Branch {
    private BankAccountFactory bankAccountFactory;
    public Branch(BankAccountFactory bankAccountFactory) {
        this.bankAccountFactory = bankAccountFactory;
    }
    public BankAccount openAccount(String type) {
        BankAccount bankAccount = bankAccountFactory.createAccount(type);
        if (bankAccount != null) {
            bankAccount.validateUserIdentity();
            bankAccount.calculateInterestRate();
            bankAccount.registerAccount();
        }
        return bankAccount;
    }
}

// Test
public class FactoryMethodPattern {
    public static void main(String[] args) {
        Branch localBranch = new Branch(new LocalBankAccountFactory());
        localBranch.openAccount("P");

        System.out.println("----------------");

        Branch foreignBranch = new Branch(new ForeignBankAccountFactory());
        foreignBranch.openAccount("B");
    }
}
