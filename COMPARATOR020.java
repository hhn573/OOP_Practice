import java.util.*;

class SanPham {
    private String name;
    private int price;
    private int stock;

    public SanPham(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + stock;
    }
}

public class COMPARATOR020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        List<SanPham> products = new ArrayList<>();

        while (t-- > 0) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            int stock = Integer.parseInt(parts[2]);

            products.add(new SanPham(name, price, stock));
        }

        String type = sc.nextLine().trim();

        if (type.equals("BY_NAME")) {
            products.sort(Comparator.comparing(SanPham::getName));
        } else if (type.equals("BY_PRICE")) {
            products.sort(Comparator.comparingInt(SanPham::getPrice)
                    .thenComparing(SanPham::getName));
        } else if (type.equals("BY_STOCK")) {
            products.sort(Comparator.comparingInt(SanPham::getStock).reversed()
                    .thenComparing(SanPham::getName));
        }

        for (SanPham sp : products) {
            System.out.println(sp);
        }

        sc.close();
    }
}
