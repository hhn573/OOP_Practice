import java.util.Scanner;

public class STRING006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số dòng văn bản
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            StringBuilder capitals = new StringBuilder();

            // Duyệt từng ký tự trong dòng
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (Character.isUpperCase(ch)) {
                    capitals.append(ch);
                }
            }

            System.out.println("My initials are: " + capitals.toString());
        }

        sc.close();
    }
}
