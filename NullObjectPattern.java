interface Customer {
    String getName();
}

class RealCustomer implements Customer {
    private String name;

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class NullCustomer implements Customer {
    public String getName() {
        return "Not Available"; // neutral behavior
    }
}

class CustomerFactory {
    private static final String[] names = {"Chirag", "Raj", "Amit"};

    public static Customer getCustomer(String name) {
        for (String n : names) {
            if (n.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer(); // return a Null Object instead of null
    }
}

public class NullObjectPattern {
    public static void main(String[] args) {
        Customer c1 = CustomerFactory.getCustomer("Chirag");
        Customer c2 = CustomerFactory.getCustomer("Unknown");

        System.out.println("Customer1 : " + c1.getName());
        System.out.println("Customer2 : " + c2.getName()); // no null check needed
    }
}
