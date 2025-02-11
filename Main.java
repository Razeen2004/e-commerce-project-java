import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeProducts();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        currentUser = new User(username);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void initializeProducts() {
        products.add(new Electronics("E1", "Laptop", 999.99, "Dell"));
        products.add(new Electronics("E2", "Smartphone", 699.99, "Samsung"));
        products.add(new Clothing("C1", "T-Shirt", 29.99, "M"));
        products.add(new Clothing("C2", "Jeans", 59.99, "L"));
    }

    private static void displayProducts() {
        System.out.println("\n=== Available Products ===");
        products.forEach(p -> {
            System.out.printf("[ID: %s] ", p.getId()); // Display product ID
            p.displayDetails();
        });
    }

    private static void addToCart(Scanner scanner) {
        displayProducts();
        System.out.print("Enter product ID to add: ");
        String productId = scanner.nextLine();

        Product selected = products.stream()
                .filter(p -> p.getId().equalsIgnoreCase(productId))
                .findFirst()
                .orElse(null);

        if (selected != null) {
            currentUser.getCart().addItem(selected);
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void viewCart() {
        System.out.println("\n=== Your Cart ===");
        currentUser.getCart().getItems().forEach(Product::displayDetails);
        System.out.printf("Total: $%.2f%n", currentUser.getCart().calculateTotal());
    }

    private static void checkout(Scanner scanner) {
        if (currentUser.getCart().getItems().isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\nChoose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        PaymentMethod payment;
        if (paymentChoice == 1) {
            payment = new CreditCard();
        } else if (paymentChoice == 2) {
            payment = new PayPal();
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        double total = currentUser.getCart().calculateTotal();
        payment.processPayment(total);

        Order order = new Order(
                new ArrayList<>(currentUser.getCart().getItems()),
                payment);
        currentUser.getOrderHistory().add(order);
        currentUser.getCart().getItems().clear();

        order.displayOrder();
    }
}