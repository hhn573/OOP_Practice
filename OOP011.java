
import java.util.Scanner;

class Product {
    private  String productId;
    private  String name;
    private  double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private String orderId;
    private Product product;
    private int quantity;

    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    
    public double calculateTotal() {
        return product.getPrice() * quantity;
    }

    
    public void display() {
        System.out.println("--- Thông tin đơn hàng ---");
        System.out.println("Đơn hàng: " + orderId);
        System.out.println("Sản phẩm: " + product.getName() + " (Mã: " + product.getProductId() + ")");
        System.out.println("Giá: " + product.getPrice());
        System.out.println("Số lượng: " + quantity);
        System.out.println("Tổng tiền: " + calculateTotal());
    }
    
}

public class OOP011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String productId = sc.nextLine();         // Dòng 1
        String name = sc.nextLine();              // Dòng 2
        double price = Double.parseDouble(sc.nextLine()); // Dòng 3
        String orderId = sc.nextLine();           // Dòng 4
        int quantity = Integer.parseInt(sc.nextLine());
        Product product = new Product(productId, name, price);
        Order order = new Order(orderId, product, quantity);
        order.display();
        sc.close();
    }
    
}
