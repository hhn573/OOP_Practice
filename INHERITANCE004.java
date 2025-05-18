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
    public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double maxSalePrice = 0;
        while (n-- > 0) {
            String inp = sc.nextLine();
            String lString[] = inp.split(" ");
            String type = lString[0];
            double price = Double.parseDouble(lString[1]);
            int year = Integer.parseInt(lString[2]);
            Car car = createCar(type, price, year);
            double salePrice = car.calculateSalePrice();
            maxSalePrice = Math.max(maxSalePrice, salePrice);
            System.out.printf("Price: %,.2f VND | Year: %d\n", salePrice, car.year);
        }
        System.out.printf("Most Expensive: %,.2f VND\n", maxSalePrice);
        sc.close();
    }

    public static Car createCar(String type, double price, int year) {
        if (type.equals("SC")) {
            return new SportCar(price, year);
        } else {
            return new ClassicCar(price, year);
        }
    }
}

}
