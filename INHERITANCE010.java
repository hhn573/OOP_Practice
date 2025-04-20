abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public abstract double calculateCost(int quantity);

    public void displayDetails() {
        System.out.println("Product: " + name + ", Price: $" + String.format("%.2f", price) + ", Quantity: " + quantity);
    }
}

class Book extends Product {
    private String author;

    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    @Override
    public double calculateCost(int quantity) {
        return price * quantity; 
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Author: " + author);
    }
}

class Electronic extends Product {
    private String brand;

    public Electronic(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    @Override
    public double calculateCost(int quantity) {
        return price * quantity * 1.1; 
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Brand: " + brand);
    }
}

class User {
    private String username;
    private double totalSpent; 

    public User(String username) {
        this.username = username;
        this.totalSpent = 0;
    }

    public String getUsername() {
        return username;
    }

    public double getTotalSpent() {
        return totalSpent;
    }


    public void buyProduct(Product product, int quantity) {
        if (quantity <= product.quantity) {
            double totalPrice = product.calculateCost(quantity);
            totalSpent += totalPrice;
            product.quantity -= quantity; // Reduce product quantity after purchase
            System.out.println("User: " + username + " bought " + quantity + " " + product.name + " for $" + totalPrice);
        } else {
            System.out.println("Insufficient quantity of " + product.name + " available.");
        }
    }
}

public class INHERITANCE010 {
    public static void main(String[] args) {
        
        Electronic laptop = new Electronic("Laptop", 20, 10, "Dell"); 
        Book book = new Book("Harry Potter", 10, 12, "camnh");
            
        laptop.displayDetails();
        book.displayDetails();
        System.out.println();

      
    }
}
