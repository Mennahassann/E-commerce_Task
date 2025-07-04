import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.err.println("Cart is empty.");
            return;
        }
        List<CartItem> items = cart.getItem();
        List<Shippable> shippableItems = new ArrayList<>();
        double subtotal = 0;

        for (CartItem item : items) {
            Product p = item.product;
            if (p.isExpired()) {
                System.err.println("Product '" + p.getName() + "' is expired.");
                return;
            }
            if (item.quantity > p.getquantity()) {
                System.err.println("Insufficient stock for " + p.getName());
                return;
            }
            if (p.isShippable()&& p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++)
                    shippableItems.add((Shippable) p);
            }
            subtotal += item.getTotalPrice();
        }

        double shippingFee = shippableItems.isEmpty() ? 0 : 30;
        double totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount) {
            System.err.println("Insufficient balance.");
            return;
        }

        for (CartItem item : items) {
            item.product.AvailableAmount(item.quantity);
        }
        customer.deduct(totalAmount);

        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", totalAmount);
        System.out.printf("Customer Balance %.0f\n", customer.getBalance());

        cart.clear();
    }
}
