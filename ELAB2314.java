import java.util.Scanner;

class HanhTinh {
    private double khoiLuong;
    private double banKinh;
    public static final double G = 6.67300E-11;

    public HanhTinh(double khoiLuong, double banKinh) {
        this.khoiLuong = khoiLuong;
        this.banKinh = banKinh;
    }

    public double trongLucBeMat() {
        return (khoiLuong * G) / (banKinh * banKinh);
    } 

    public double khoiLuongBeMat(double khoiLuong) {
        return (trongLucBeMat() / 9.802775697614821) * khoiLuong;
    }
}

public class ELAB2314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tenHanhTinh = sc.nextLine();
        double khoiLuong = sc.nextDouble();
        double banKinh = sc.nextDouble();
        HanhTinh ht = new HanhTinh(khoiLuong, banKinh);
        System.out.println("Your weight on " + tenHanhTinh + " is " + String.format("%.2f", ht.khoiLuongBeMat(khoiLuong)));
        sc.close();
    }
}
