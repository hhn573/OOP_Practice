import java.util.Scanner;

public class COBAN101 {
    // Hàm đếm số lần xuất hiện của các chữ số trong khoảng [a, b]
    public static void countDigitsInRange(int a, int b) {
        int[] digitCount = new int[10]; // Mảng đếm số lần xuất hiện của từng chữ số 0-9

        // Duyệt qua từng số từ a đến b
        for (int num = a; num <= b; num++) {
            // Chuyển số thành xâu để đếm từng chữ số
            String numStr = String.valueOf(num);
            for (char digit : numStr.toCharArray()) {
                int digitValue = digit - '0'; // Chuyển ký tự thành số
                digitCount[digitValue]++;
            }
        }

        // In ra số lần xuất hiện của từng chữ số 0-9
        for (int i = 0; i < 9; i++) {
            System.out.print(digitCount[i] + " ");
        }
        System.out.println(digitCount[9]); // In chữ số 9 và xuống dòng
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Số lượng bộ test

        // Xử lý từng bộ test
        for (int t = 0; t < T; t++) {
            int a = scanner.nextInt(); // Số bắt đầu
            int b = scanner.nextInt(); // Số kết thúc
            countDigitsInRange(a, b);
        }
        scanner.close();
    }
}