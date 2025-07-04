
interface shippment{
    String getName();
    double getWeight();
}
public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public double getprice(){
        return price;
    }
    public int getquantity(){
        return quantity;
    }
    public abstract boolean isExpired();
    public abstract boolean isShippable();

    public void AvailableAmount(int amount){
        if(amount>quantity) 
            System.out.println("Not enough quantity.");
        quantity -= amount;
    }
}
