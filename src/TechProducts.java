public class TechProducts extends Product {
    public TechProducts(String name, double price, int quantity){
        super(name, price, quantity);

    }
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
