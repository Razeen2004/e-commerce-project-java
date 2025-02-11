public class Electronics extends Product {
    private String brand;

    public Electronics(String id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.printf("[Electronics] %s | Brand: %s | Price: $%.2f%n", 
            getName(), brand, getPrice());
    }
}