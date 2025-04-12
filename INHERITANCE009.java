import java.util.ArrayList;

class Item {
    private String name;
    private double price;
    private double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String toString() {
        return "   " + name + " $" + String.format("%.2f", price) + " (-$" + String.format("%.2f", discount) + ")";
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class GroceryBill {
    protected ArrayList<Item> items;
    protected Employee clerk;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public String getClerk() {
        return clerk.getName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("items:\n");
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("total: $" + String.format("%.2f", getTotal()) + "\n");
        sb.append("Clerk: " + getClerk());
        return sb.toString();
    }
}

class DiscountBill extends GroceryBill {

    public DiscountBill(Employee clerk) {
        super(clerk);
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() - item.getDiscount();
        }
        return total;
    }

    public double getSubTotal() {
        double subTotal = 0;
        for (Item item : items) {
            subTotal += item.getPrice();
        }
        return subTotal;
    }

    public double getTotalDiscount() {
        return getSubTotal() - getTotal();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("items:\n");
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("sub-total: $" + String.format("%.2f", getSubTotal()) + "\n");
        sb.append("discount: $" + String.format("%.2f", getTotalDiscount()) + "\n");
        sb.append("total: $" + String.format("%.2f", getTotal()) + "\n");
        sb.append("Clerk: " + getClerk());
        return sb.toString();
    }
}

public class INHERITANCE009 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Grocery Bill");
        Employee emp2 = new Employee("Discount Bill");

        // Grocery Bill
        GroceryBill grB = new GroceryBill(emp1);
        grB.add(new Item("item 1", 2.3, 0));
        grB.add(new Item("item 2", 3.45, 0));
        System.out.println(grB.toString());

        System.out.println();

        // Discount Bill
        DiscountBill db = new DiscountBill(emp2);
        db.add(new Item("item 3", 20, 15));
        db.add(new Item("item 4", 40, 35));
        db.add(new Item("item 5", 50, 35));
        System.out.println(db.toString());
    }
}
