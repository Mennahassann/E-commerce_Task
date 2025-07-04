
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem>items =new ArrayList<>();

    public void add(Product product, int quantity){
        if (quantity > product.getquantity())
            throw new IllegalArgumentException("Requested quantity exceeds available stock.");
        
        items.add(new CartItem(product, quantity));
    }

        public List<CartItem>getItem(){
            return items;
        }

        public boolean isEmpty(){
            return items.isEmpty();
        }
        public void clear(){
            items.clear();
        }
    
}
