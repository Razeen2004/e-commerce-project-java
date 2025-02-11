public interface PaymentMethod {
    void processPayment(double amount);
}

// Concrete implementations
class CreditCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Paid $%.2f via Credit Card.%n", amount);
    }
}

class PayPal implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Paid $%.2f via PayPal.%n", amount);
    }
}