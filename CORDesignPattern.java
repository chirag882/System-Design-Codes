
// Handler
abstract class CashDispenser {
    protected CashDispenser nextDispenser;
    public void setNextDispenser(CashDispenser next) {
        this.nextDispenser = next;
    }
    public abstract void dispense(int amount);
}

// Concrete Handler for ₹2000
class Dispenser2000 extends CashDispenser {
    public void dispense(int amount) {
        int num = amount / 2000;
        int remainder = amount % 2000;
        if (num > 0) {
            System.out.println("Dispensing " + num + " x ₹2000 notes");
        }
        if (remainder > 0 && nextDispenser != null) {
            nextDispenser.dispense(remainder);
        }
    }
}

// Concrete Handler for ₹500
class Dispenser500 extends CashDispenser {
    public void dispense(int amount) {
        int num = amount / 500;
        int remainder = amount % 500;
        if (num > 0) {
            System.out.println("Dispensing " + num + " x ₹500 notes");
        }
        if (remainder > 0 && nextDispenser != null) {
            nextDispenser.dispense(remainder);
        }
    }
}

// Concrete Handler for ₹100
class Dispenser100 extends CashDispenser {
    public void dispense(int amount) {
        int num = amount / 100;
        int remainder = amount % 100;
        if (num > 0) {
            System.out.println("Dispensing " + num + " x ₹100 notes");
        }
        if (remainder > 0 && nextDispenser != null) {
            nextDispenser.dispense(remainder);
        } else if (remainder > 0) {
            System.out.println("Cannot dispense remaining amount: " + remainder);
        }
    }
}

// Client
public class CORDesignPattern {
    public static void main(String[] args) {
        // Build chain
        CashDispenser d2000 = new Dispenser2000();
        CashDispenser d500 = new Dispenser500();
        CashDispenser d100 = new Dispenser100();

        d2000.setNextDispenser(d500);
        d500.setNextDispenser(d100);

        // Test withdrawal
        int amount = 3700;
        System.out.println("Requesting ₹" + amount);
        d2000.dispense(amount);
    }
}
