import java.util.*;

class Amount {
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public void add(Amount amount) {
        if (this.currency.equals(amount.currency)) {
            this.amount += amount.amount;
        } else {
            System.out.println("Currency doesn't match");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Amount)) return false;
        Amount other = (Amount) obj;
        return this.currency.equals(other.currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}

public class EXCEPTION001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < t; i++) {
            String currency1 = scanner.nextLine();
            int amount1 = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String currency2 = scanner.nextLine();
            int amount2 = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Amount am1 = new Amount(currency1, amount1);
            Amount am2 = new Amount(currency2, amount2);

            if (am1.equals(am2)) {
                am1.add(am2);
                System.out.println(am1);
            } else {
                System.out.println("Currency doesn't match");
            }
        }

        scanner.close();
    }
}
