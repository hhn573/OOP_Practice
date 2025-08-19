import java.util.*;

class Vehicle {
    protected double price;

    public Vehicle(double price) {
        this.price = price;
    }

    public double caculateTax() {
        return price;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return "Danh sách phương tiện và thuế:";
    }
}

class Car extends Vehicle {
    private int numberOfSeats;

    public Car(double price, int numberOfSeats) {
        super(price);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public double caculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getType() {
        return "Car - Giá:" + String.format("%.2f", getPrice()) + ", Số ghế: " + numberOfSeats + " - Thuế: " + String.format("%.2f", caculateTax());
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(double price, double loadCapacity) {
        super(price);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double caculateTax() {
        return getPrice() * 0.1 + loadCapacity * 1000;
    }

    @Override
    public String getType() {
        return "Truck - Giá: " + String.format("%.2f", getPrice()) + ", Tải trong: " + loadCapacity + ", Thuế: " + String.format("%.2f", caculateTax());
    }
}


public class INHERITANCE014 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while (t-- > 0) {
        String[] parts = sc.nextLine().split("\\s+");  // tách theo khoảng trắng
        String type = parts[0];
        double price = Double.parseDouble(parts[1]);
        if (type.equals("Car")) {
            int numberOfSeats = Integer.parseInt(parts[2]);
            Car car = new Car(price, numberOfSeats);
            System.out.println(car.getType());
        } else if (type.equals("Truck")) {
            double loadCapacity = Double.parseDouble(parts[2]);
            Truck truck = new Truck(price, loadCapacity);
            System.out.println(truck.getType());
        }
    }
    sc.close();
}
}

 