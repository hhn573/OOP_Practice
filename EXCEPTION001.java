import java.util.*;

class Amount {
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }

    public void add(Amount other) {
        if (this.currency.equals(other.currency)) {
            this.amount += other.amount;
        } else {
            System.out.println("Currency doesn't match");
        }
    }
}

public class EXCEPTION001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int t = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < t; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split("\\s+");
                if (parts.length != 4) {
                    System.out.println("Invalid input format at line " + (i + 1));
                    continue;
                }

                String currency1 = parts[0];
                int amount1 = Integer.parseInt(parts[1]);
                String currency2 = parts[2];
                int amount2 = Integer.parseInt(parts[3]);

                Amount am1 = new Amount(currency1, amount1);
                Amount am2 = new Amount(currency2, amount2);

                if (am1.getCurrency().equals(am2.getCurrency())) {
                    am1.add(am2);
                    System.out.println(am1.getAmount());
                } else {
                    System.out.println("Currency doesn't match");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter valid integers for amounts.");
        } finally {
            scanner.close();
        }
    }
}
