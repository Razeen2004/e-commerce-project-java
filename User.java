import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private ShoppingCart cart;
    private List<Order> orderHistory;

    public User(String username) {
        this.username = username;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public ShoppingCart getCart() { return cart; }
    public List<Order> getOrderHistory() { return orderHistory; }
}