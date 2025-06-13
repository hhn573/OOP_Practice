import java.util.*;

class Item {
    private String product;
    private int quantity;
    private int unitPrice;
    private int originalQuantity;

    public Item(String product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = price;
        this.originalQuantity = quantity;
    }

    public Item(String product, int quantity) {
        this(product, quantity, 0);
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return quantity * unitPrice;
    }

    public void printItemInfo() {
        System.out.println("Product: " + product + " has quantity " + quantity + " with price: " + getTotalPrice());
    }
}

class Warehouse {
    private HashMap<String, Item> items = new HashMap<>();

    public void importProduct(Item item) {
        String product = item.getProduct();
        if (items.containsKey(product)) {
            Item existing = items.get(product);
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            items.put(product, item);
        }
    }

    public Item getItem(String product) {
        return items.get(product);
    }

    public void removeProduct(String product, int quantity) {
        Item item = items.get(product);
        if (item != null) {
            int newQty = item.getQuantity() - quantity;
            item.setQuantity(Math.max(0, newQty));
        }
    }

    public void decreaseQuantityInWarehouseByOne() {
        for (Item item : items.values()) {
            if (item.getQuantity() > 0) {
                item.setQuantity(item.getQuantity() - 1);
            }
        }
    }

    public void takeFromToWarehouse(List<Item> itemsToCheck, String product, int quantity) {
        Item itemToCheck = null;
        for (Item item : itemsToCheck) {
            if (item.getProduct().equals(product)) {
                itemToCheck = item;
                break;
            }
        }

        if (itemToCheck != null && itemToCheck.getQuantity() > 0) {
            int available = itemToCheck.getQuantity();
            int quantityToAdd = Math.min(quantity, available);

            
            itemToCheck.setQuantity(available - quantityToAdd);

            
            if (items.containsKey(product)) {
                Item itemInWarehouse = items.get(product);
                itemInWarehouse.setQuantity(itemInWarehouse.getQuantity() + quantityToAdd);
            } else {
                items.put(product, new Item(product, quantityToAdd));
            }
        }
    }

    public void printWarehouseInfo() {
        for (Item item : items.values()) {
            item.printItemInfo();
        }
    }
}
public class COLLECTION004 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

       
        Item milk = new Item("milk", 4, 2);
        Item buttermilk = new Item("buttermilk", 10, 2);

        milk.printItemInfo();
        buttermilk.printItemInfo();

        //System.out.println("------");

        
        warehouse.importProduct(milk);
        warehouse.importProduct(buttermilk);

        
        warehouse.removeProduct("milk", 1);
        warehouse.removeProduct("buttermilk", 3);

        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();

        //System.out.println("------");

       
        warehouse.decreaseQuantityInWarehouseByOne();

        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();

        //System.out.println("------");

       
        List<Item> itemsToCheck = new ArrayList<>();
        itemsToCheck.add(new Item("milk", 2));
        itemsToCheck.add(new Item("buttermilk", 6));

        
        warehouse.takeFromToWarehouse(itemsToCheck, "milk", 5);
        warehouse.takeFromToWarehouse(itemsToCheck, "buttermilk", 1);

        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();
    }
}
