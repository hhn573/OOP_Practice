import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface PricedItem {
    double getPrice();
}

interface SourceableItem {
    String getSourceName();
}

class Dish implements PricedItem, SourceableItem {
    private String name;
    private double price;
    private String restaurantName;

    public Dish(String name, double price, String restaurantName) {
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSourceName() {
        return restaurantName;
    }

    public String getName() {
        return name;
    }
}

public class INTERFACE021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        while (testCases-- > 0) {
            List<Dish> dishes = new ArrayList<>();

            while (true) {
                String line = scanner.nextLine();
                if (line.equals("Checkout")) break;

                // Tách chuỗi theo dấu ngoặc kép
                // line ví dụ: Dish "Pho Bo Tai Lan" 55000.0 "Pho Thin"
                String[] parts = line.split("\"");
                if (parts.length >= 4) {
                    String name = "\"" + parts[1] + "\""; // Thêm lại dấu ngoặc kép
                    String[] middle = parts[2].trim().split(" ");
                    double price = Double.parseDouble(middle[0]);
                    String restaurant = "\"" + parts[3] + "\"";

                    dishes.add(new Dish(name, price, restaurant));
                }
            }

            String targetRestaurant = scanner.nextLine().trim();

            for (Dish dish : dishes) {
                if (dish.getSourceName().equals(targetRestaurant)) {
                    System.out.printf("%s - %.2f\n", dish.getName(), dish.getPrice());
                }
            }
        }
        scanner.close();
    }
}