// Component interface
interface Coffee {
    String getDescription();
    double cost();
}

// Base component
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double cost() {
        return 5.0;
    }
}

// Abstract decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee coffee) { // new Sugar(new SimpleCoffee())
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.5;
    }
}

class CreamDecorator extends CoffeeDecorator {
    CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Cream";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 2.0;
    }
}


public class DecoraterPattern {
    public static void main(String[] args) {
        // Coffee coffee = new SimpleCoffee();
        // System.out.println(coffee.getDescription() + " -> $" + coffee.cost());

        // coffee = new MilkDecorator(coffee);
        // System.out.println(coffee.getDescription() + " -> $" + coffee.cost());

        // coffee = new SugarDecorator(coffee);
        // System.out.println(coffee.getDescription() + " -> $" + coffee.cost());

        // coffee = new CreamDecorator(coffee);
        // System.out.println(coffee.getDescription() + " -> $" + coffee.cost());
        // Coffee coffee = new CreamDecorator(new SugarDecorator(new MilkDecorator(new SimpleCoffee())));

        // input = simple + sugar
        // Coffee coffee1 = new SugarDecorator(new SimpleCoffee());
        // System.out.println(coffee1.getDescription() + " -> $" + coffee1.cost());

        // Coffee coffee2 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        // System.out.println(coffee.getDescription() + " -> $" + coffee.cost());
    }
}
