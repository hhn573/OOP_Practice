import java.util.*;

class Warehouse {
    private Map<String, Integer> prices = new HashMap<>();
    private Map<String, Integer> stocks = new HashMap<>();

    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);  
    }

    public int price(String product) {
        return prices.getOrDefault(product, -99);
    }
}
public class COLLECTION001 {
    public static  void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 7);
        System.out.println("prices:");
        System.out.println("milk: " + warehouse.price("milk"));     
        System.out.println("coffee: " + warehouse.price("coffee")); 
        System.out.println("sugar: " + warehouse.price("sugar")); 
    }
}
