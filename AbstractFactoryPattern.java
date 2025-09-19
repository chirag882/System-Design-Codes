// --- Abstract Product A
interface BankAccount {
    void open();
}

// Concrete Products A
class PersonalAccount implements BankAccount {
    public void open() { System.out.println("Local Personal Account opened"); }
}

class ForeignPersonalAccount implements BankAccount {
    public void open() { System.out.println("Foreign Personal Account opened with extra KYC"); }
}

// --- Abstract Product B
interface LoanAccount {
    void approve();
}

// Concrete Products B
class PersonalLoan implements LoanAccount {
    public void approve() { System.out.println("Local Personal Loan approved"); }
}

class ForeignPersonalLoan implements LoanAccount {
    public void approve() { System.out.println("Foreign Personal Loan approved with compliance check"); }
}

// --- Abstract Factory
interface BankFactory {
    BankAccount createBankAccount();
    LoanAccount createLoanAccount();
}

// --- Concrete Factory: Local
class LocalBankFactory implements BankFactory {
    public BankAccount createBankAccount() {
        return new PersonalAccount();
    }
    public LoanAccount createLoanAccount() {
        return new PersonalLoan();
    }
}

// --- Concrete Factory: Foreign
class ForeignBankFactory implements BankFactory {
    public BankAccount createBankAccount() {
        return new ForeignPersonalAccount();
    }
    public LoanAccount createLoanAccount() {
        return new ForeignPersonalLoan();
    }
}

// --- Client
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // Local factory
        BankFactory localFactory = new LocalBankFactory();
        BankAccount localAccount = localFactory.createBankAccount();
        LoanAccount localLoan = localFactory.createLoanAccount();
        localAccount.open();
        localLoan.approve();

        System.out.println("-------------------");

        // Foreign factory
        BankFactory foreignFactory = new ForeignBankFactory();
        BankAccount foreignAccount = foreignFactory.createBankAccount();
        LoanAccount foreignLoan = foreignFactory.createLoanAccount();
        foreignAccount.open();
        foreignLoan.approve();
    }
}
