import java.time.LocalDate;

public class ExpiredProducts extends Product implements shippment {
    
    private double weight;
    private LocalDate expiryDate;

    public ExpiredProducts(String name, double price, int quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getname() {
        return super.getname(); 
    }
}
