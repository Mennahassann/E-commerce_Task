import java.time.LocalDate;

public class ECommerceSystem {
    public static void main(String[] args) {
        Product cheese = new ShippableProducts("Cheese", 100, 10, 0.2);
        Product biscuits = new ExpiredProducts("Biscuits", 150, 5, 0.7, LocalDate.of(2025, 12, 31));
        Product tv = new ShippableProducts("TV", 5000, 3, 3.0);
        Product scratchCard = new TechProducts("Scratch Card", 50, 20);

        Customer customer = new Customer("Menna", 10000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        

        CheckoutService.checkout(customer, cart);
    }
}
