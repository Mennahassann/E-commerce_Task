
public class ShippableProducts extends Product implements Shippable {
    
    private double weight;

    public ShippableProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name; 
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
