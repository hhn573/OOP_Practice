import java.util.*;

class Car {
    double  price;
    int year;

    public Car (double price, int year) {
        this.price = price;
        this.year = year;
    }

    public double calculateSalePrice() {
        return price;
    }
        
    
    public String toString() {
        return "Car [price=" + String.format("%,.2f", price) + " VND, year=" + year + "]";
    }
}

class ClassicCar extends Car {
    private static final double REGISTRATION_FEE_RATE = 1.12;
    private static final double INSURANCE_FEE = 20000000;

    public ClassicCar(double price, int year) {
        super(price, year);
    }

    public double calculateSalePrice() {
        return super.calculateSalePrice() * REGISTRATION_FEE_RATE + INSURANCE_FEE;
    }   
}

class SportsCar extends Car {
    public SportsCar(double price, int year) {
        super(price, year);
    }

    public double calculateSalePrice() {
        double salePrice = price;
        if (year < 2018) {
            salePrice = price * 0.8; // 20% reduction
        } else {
            salePrice = price * 0.5; // 50% reduction
        }
        salePrice = salePrice * 0.1; // 90% reduction
        return salePrice;
    }

}

public class INHERITANCE004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            double price = sc.nextDouble();
            int year = sc.nextInt();
            Car car = new Car(price, year);
            ClassicCar classicCar = new ClassicCar(price, year);
            SportsCar sportsCar = new SportsCar(price, year);
            System.out.println("Car " + i + ": " + car.calculateSalePrice());
            System.out.println("ClassicCar " + i + ": " + classicCar.calculateSalePrice());
            System.out.println("SportsCar " + i + ": " + sportsCar.calculateSalePrice());
        }
        sc.close();
    }
}
