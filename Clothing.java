public class Clothing extends Product {
    private String size;

    public Clothing(String id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayDetails() {
        System.out.printf("[Clothing] %s | Size: %s | Price: $%.2f%n", 
            getName(), size, getPrice());
    }
}