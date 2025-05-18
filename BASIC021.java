import java.math.BigInteger;
import java.util.Scanner;

public class BASIC021 {
    // Hàm tính giai thừa của một số nguyên n
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        // Nhập khoảng [a, b]
        int a = sc.nextInt();
        //int b = sc.nextInt();
        System.out.println("Factorials of numbers from 1 to " + a + ":\n");
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= a; i++) {
            
            BigInteger fact = factorial(i);
            System.out.println(i + "! = " + fact + "\n");
            sum = sum.add(fact);
        }
        System.out.println("The sum of these factorials is: " + sum );
        sc.close();
    }
}