    import java.util.*;

    class Amount {
        private String currency;
        private int amount;

        public Amount(String currency, int amount) {
            this.currency = currency;
            this.amount = amount;
        }

        public void add(Amount amount) {
        if(this.currency.equals(amount.currency)) {
                this.amount += amount.amount;
            } 
            else {
                System.out.println("Currency doesn't match");
            }
        }
    }

    public class EXCEPTION001 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < t; i++) {
                
                String currency1 = scanner.nextLine();
                int amount1 = scanner.nextInt();
                scanner.nextLine(); 

                String currency2 = scanner.nextLine();
                int amount2 = scanner.nextInt();
                scanner.nextLine(); 
            
                Amount am1 = new Amount(currency1, amount1);
                Amount am2 = new Amount(currency2, amount2);

                if (am1.equals(am2)) {
                    amt1.add(amt2);
                    System.out.println(am1);
                } 
                else {
                    System.out.println("Currency doesn't match");
                    
                }

            }
            scanner.close();
        }
    }
