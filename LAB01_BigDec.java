import java.math.BigDecimal;
import java.util.Scanner;

public class LAB01_BigDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println(0);
                continue;
            }
            String[] nums = line.split("\\s+");
            BigDecimal sum = BigDecimal.ZERO;
            for (String numStr : nums) {
                BigDecimal num = new BigDecimal(numStr);
                BigDecimal frac = num.remainder(BigDecimal.ONE).abs();
                sum = sum.add(frac);
            }
            // Nếu tổng là số nguyên, in ra 0
            if (sum.compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(0);
            } else {
                // Loại bỏ số 0 dư ở cuối phần thập phân
                sum = sum.stripTrailingZeros();
                // Nếu là số nguyên, in ra 0
                if (sum.scale() <= 0) {
                    System.out.println(0);
                } else {
                    System.out.println(sum.toPlainString());
                }
            }
        }
        sc.close();
    }
}