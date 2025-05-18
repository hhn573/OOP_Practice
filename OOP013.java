import java.util.Scanner;

class Booka {
    protected String title;
    protected String author;
    protected String bookId;

    public Booka(String title, String author, String bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }
    
    public void display() {
        // Không cần hiển thị ở đây, vì sẽ override ở Borrow
    }
}

class Borrow extends Booka {
    private String borrowId;
    private String borrower;
    private int days;

    public Borrow(String bookId, String title, String author,
                  String borrowId, String borrower, int days) {
        super(title, author, bookId); // chú ý thứ tự
        this.borrowId = borrowId;
        this.borrower = borrower;
        this.days = days;
    }

    public double calculateFee() {
        return days * 5000;
    }

    @Override
    public void display() {
        System.out.println("--- Phiếu mượn sách ---");
        System.out.println("Mã phiếu: " + borrowId);
        System.out.println("Người mượn: " + borrower);
        System.out.println("Sách: " + title + " (Mã: " + bookId + ") - " + author);
        System.out.println("Số ngày mượn: " + days);
        System.out.printf("Phí mượn: %.1f\n", calculateFee());
    }
}

public class OOP013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bookId = sc.nextLine();
        String title = sc.nextLine();
        String author = sc.nextLine();
        String borrowId = sc.nextLine();
        String borrower = sc.nextLine();
        int days = Integer.parseInt(sc.nextLine());

        Borrow borrow = new Borrow(bookId, title, author, borrowId, borrower, days);
        borrow.display();
        sc.close();
    }
}
