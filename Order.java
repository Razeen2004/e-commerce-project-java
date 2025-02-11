import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private List<Product> items;
    private LocalDateTime date;
    private PaymentMethod paymentMethod;

    public Order(List<Product> items, PaymentMethod paymentMethod) {
        this.orderId = "ORD-" + System.currentTimeMillis();
        this.items = items;
        this.date = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
    }

    public void displayOrder() {
        System.out.println("\n=== Order Summary ===");
        items.forEach(Product::displayDetails);
        System.out.printf("Total: $%.2f | Date: %s%n", 
            items.stream().mapToDouble(Product::getPrice).sum(), date);
    }
}