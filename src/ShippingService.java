import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<Shippable>items){
        System.out.println("** Shipment notice: **");
        double totalWeight = 0;

        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Double> weightMap = new HashMap<>();

        for(Shippable item :items){
            itemCount.put(item.getName(), itemCount.getOrDefault(item.getName(), 0) + 1);
            weightMap.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        for (String name : itemCount.keySet()) {
            double weightInG = weightMap.get(name) * 1000;
            System.out.printf("%dx %s %.0fg\n", itemCount.get(name), name, weightInG);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
