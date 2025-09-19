// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

// Context
class PaymentContext {
    private PaymentStrategy strategy;
    PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    void payAmount(int amount) {
        strategy.pay(amount);
    }
}

// Usage
public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext context1 = new PaymentContext(new CreditCardPayment());
        context1.payAmount(1000); // Paid 1000 using Credit Card

        PaymentContext context2 = new PaymentContext(new UPIPayment());
        context2.payAmount(500); // Paid 500 using UPI
    }
}
