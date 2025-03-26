import java.util.Scanner;


public class KTIP001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            String s = sc.next();
            System.out.println(countValidIPv4(s));
        }
        sc.close();
        }
    
    
    public static int countValidIPv4(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return 0; // Độ dài không hợp lệ cho IPv4 (ít nhất 4, tối đa 12 chữ số)
        }
        return countIPv4Helper(s, 0, 4);
    }

    // Hàm đệ quy: đếm số cách chia từ vị trí start, với numParts phần còn lại cần chia
    private static int countIPv4Helper(String s, int start, int numParts) {
        // Trường hợp cơ sở: đã chia đủ 4 phần và dùng hết xâu
        if (numParts == 0 && start == s.length()) {
            return 1;
        }
        // Nếu không đủ chữ số hoặc còn phần nhưng hết xâu thì không hợp lệ
        if (start >= s.length() || numParts <= 0) {
            return 0;
        }

        int count = 0;
        // Thử các độ dài 1, 2, 3 cho phần hiện tại
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String part = s.substring(start, start + len);
            if (isValidPart(part)) {
                count += countIPv4Helper(s, start + len, numParts - 1);
            }
        }
        return count;
    }

    // Kiểm tra xem một đoạn có hợp lệ làm octet không
    private static boolean isValidPart(String part) {
        // Không được có số 0 đứng đầu nếu độ dài > 1
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        // Chuyển thành số và kiểm tra phạm vi [0, 255]
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }
    
}
