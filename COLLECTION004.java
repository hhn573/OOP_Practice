import java.util.*;

class Item {
    private String product;
    private int quantity;
    private int unitPrice;
    //private int originalQuantity;

    public Item(String product, int quantity, int unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        //this.originalQuantity = originalQuantity;
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

    /*
    public int getOriginalQuantity() {
        return originalQuantity;
    }
    */

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
    
    public void importProduct(String product, int quantity, int unitPrice) {
        Item existing = items.get(product);
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            Item item = new Item(product, quantity, unitPrice);
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
            item.setQuantity(Math.max(newQty, 0));
        }
    }

    public void decreaseQuantityInWarehouseByOne() {
        for (Item item : items.values()) {
            item.setQuantity(Math.max(0, item.getQuantity() - 1));
        }
    }

    public void takeFromItemToWarehouse(List<Item> itemsToCheck, String product, int quantity) {
        for (Item itemToCheck : itemsToCheck) {
            if (itemToCheck.getProduct().equals(product)) {
                int available = itemToCheck.getQuantity();
                int toImport = Math.min(available, quantity);
                if (toImport > 0) {
                    itemToCheck.setQuantity(available - toImport);
                    importProduct(product, toImport, itemToCheck.getUnitPrice());
                }
                return;
            }
        }
    }
}

public class COLLECTION004 {
    public static void main(String[] args) {
        
        //1
        Item milk = new Item("milk", 4, 2);
        Item buttermilk = new Item("buttermilk", 10, 2);
        milk.printItemInfo();
        buttermilk.printItemInfo();

        //2
        Warehouse warehouse = new Warehouse();
        warehouse.importProduct("milk", 10, 3);
        warehouse.importProduct("buttermilk", 10, 2);


        //3
        warehouse.removeProduct("milk", 1);
        warehouse.removeProduct("buttermilk", 3);
        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();


    }
}
