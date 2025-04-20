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

    public int stocks(String product) {
        return stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int currentStock = stocks(product);
        if (currentStock > 0) {
            stocks.put(product, currentStock - 1);
            return true;
        } else {
            return false;
        }
    }
}

public class COLLECTION002 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 1);
        System.out.println("stock:");
        System.out.println("coffee: " + warehouse.stocks("coffee"));
        //System.out.println("coffee: " + warehouse.stocks("coffee"));
        System.out.println("sugar: " + warehouse.stocks("sugar"));
        System.out.println(("taking coffee " + warehouse.take("coffee")));
        System.out.println(("taking coffee " + warehouse.take("coffee")));
        System.out.println("taking sugar " + warehouse.take("sugar"));
        System.out.println("stock:");
        System.out.println("coffee: " + warehouse.stocks("coffee"));
        System.out.println("sugar: " + warehouse.stocks("sugar"));
    }
}
