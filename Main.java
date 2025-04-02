import java.util.Scanner;

public class Main {
   
    public static String checkQty(int qty) throws Exception {
        if (qty <= 0){
            throw new Exception("Số lượng không hợp lệ");
        }
        return "ok";     
    }

    public static String name(String name) throws Exception {
        if(name == null || name.isEmpty()){
            throw new Exception("Tên không hợp lệ");
        }
        return "ok";
    }    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số lượng: ");
        int qty = scanner.nextInt();
        System.out.print(checkQty(qty));
        
        System.out.print("Nhập tên: ");
        String name = scanner.next();
        System.out.print(name(name));

        scanner.close();
    }
}