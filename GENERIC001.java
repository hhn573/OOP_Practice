import java.util.*;

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void swap() {
        T temp = first;
        first = second;
        second = temp;
    }
}

public class GENERIC001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input
        while (t-- > 0) {
          String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            // Kiểm tra kiểu dữ liệu: số hay chuỗi
            if (isNumber(parts[0])) {
                // Xử lý kiểu số (int hoặc double)
                if (parts[0].contains(".") || parts[1].contains(".")) {
                    // double
                    Pair<Double> pair = new Pair<>(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    pair.swap();
                    System.out.printf("'%s' '%s'\n", removeTrailingZero(pair.getFirst()), removeTrailingZero(pair.getSecond()));
                } else {
                    // int
                    Pair<Integer> pair = new Pair<>(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    pair.swap();
                    System.out.printf("'%d' '%d'\n", pair.getFirst(), pair.getSecond());
                }
            } else {
                // Xử lý kiểu chuỗi
                Pair<String> pair = new Pair<>(parts[0], parts[1]);
                pair.swap();
                System.out.printf("'%s' '%s'\n", pair.getFirst(), pair.getSecond());
            }
        }
        sc.close();
    }
    
}