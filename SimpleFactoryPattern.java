import java.util.Scanner;

interface BankAccount  {
    void validateUserIdentity();
    void calculateInterestRate();
    void registerAccount();
}

class PersonalAccount implements BankAccount  {
    @Override
    public void validateUserIdentity() {
        System.out.println("Validating Personal Account User Identity...");
    }

    @Override
    public void calculateInterestRate() {
        System.out.println("Personal Account Interest Rate: 4%");
    }

    @Override
    public void registerAccount() {
        System.out.println("Personal Account Registered Successfully!");
    }
}

class BusinessAccount implements BankAccount  {
    @Override
    public void validateUserIdentity() {
        System.out.println("Validating Business Account User Identity...");
    }

    @Override
    public void calculateInterestRate() {
        System.out.println("Business Account Interest Rate: 6%");
    }

    @Override
    public void registerAccount() {
        System.out.println("Business Account Registered Successfully!");
    }
}

class CheckingAccount implements BankAccount  {
    @Override
    public void validateUserIdentity() {
        System.out.println("Validating Checking Account User Identity...");
    }

    @Override
    public void calculateInterestRate() {
        System.out.println("Checking Account Interest Rate: 3%");
    }

    @Override
    public void registerAccount() {
        System.out.println("Checking Account Registered Successfully!");
    }
}

class BankAccountFactory {
    public BankAccount createAccount(String type){
        BankAccount bankAccount = null;
        if (type.equals("P")){
            bankAccount = new PersonalAccount();
        } else if (type.equals("B")){
            bankAccount = new BusinessAccount();
        } else if (type.equals("C")){
            bankAccount = new CheckingAccount();
        } else {
            System.out.println("Invalid type");
        }
        return bankAccount;
    }
}

class Branch {

    private BankAccountFactory bankAccountFactory;

    public Branch(BankAccountFactory bankAccountFactory){
        this.bankAccountFactory = bankAccountFactory;
    }

    public BankAccount openAccount(String type) {
        BankAccount bankAccount = null;
        bankAccount = bankAccountFactory.createAccount(type);
        bankAccount.validateUserIdentity();
        bankAccount.calculateInterestRate();
        bankAccount.registerAccount();

        return bankAccount;
    }
}

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter\n" +
                " P for Personal account\n" +
                " B for Business account\n" +
                " C for Checking account\n" +
                "----------------------------");

        String type = in.nextLine();

        BankAccountFactory factory = new BankAccountFactory();
        Branch branch = new Branch(factory);
        branch.openAccount(type);

        in.close();
    }
}