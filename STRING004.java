import java.util.Scanner;

public class STRING004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String s1 = sc.nextLine();
            StringBuffer  sb = new StringBuffer(s1);
            System.out.println(sb.length());

        }
        sc.close();
    }    
}
