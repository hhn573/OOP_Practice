import java.util.Scanner;


class NotContainVowelException extends Exception {
    public NotContainVowelException(String message) {
        super(message);
    }
}

public class VowelChecker {

 
    public static void checkVowel(String str) throws NotContainVowelException {
      
        boolean hasVowel = str.toLowerCase().matches(".*[aeiou].*");

        if (hasVowel) {
            System.out.println("String has vowels");
        } else {
            throw new NotContainVowelException("String not contain vowels");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); 
        while (t -- > 0){
            
        int n = Integer.parseInt(scanner.nextLine()); 

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            try {
                checkVowel(input);
            } catch (NotContainVowelException e) {
                System.out.println(e.getMessage());
            }
        }
        }    

        scanner.close();
    }
}
