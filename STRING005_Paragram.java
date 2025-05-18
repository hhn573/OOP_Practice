    import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Set;

    public clSTRING005_ParagramG005 {
        public static void main(String[] arg) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String s = sc.nextLine();
                Set<Character> set = new HashSet<>();
                for (char c : s.toCharArray()) {
                    set.add(c);
                }
                if (set.size() == 26)
                    System.out.println("true");
                else
                    System.out.println("false");
            }

        }
    }
