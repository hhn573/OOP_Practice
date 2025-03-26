import java.util.Scanner;

class FlightBooking {
    public String flightId = "OOP24";
    private static int seatAvailable = 180;

    // Phương thức đặt vé
    public static String bookSeat(int userId) {
        if (seatAvailable > 0) {
            seatAvailable--;
            return "[Seat Available: " + seatAvailable + "]";
        } else {
            return "No seats available";
        }
    }

    // Phương thức xác nhận vé
    public static String confirmBooking(int userId) {
        // Giả sử xác nhận không ảnh hưởng đến số ghế (chỉ cập nhật trạng thái)
        return "--User " + userId + " Confirmed--[Seat Available: " + seatAvailable + "]";
    }

    // Phương thức hủy vé
    public static String cancelBooking(int userId) {
        seatAvailable++; // Trả lại ghế
        return "[Seat Available: " + seatAvailable + "]";
    }
}

public class 1 - Booking Class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự xuống dòng sau nextInt

        for (int t = 0; t < testCases; t++) {
            String line = scanner.nextLine();
            String[] actions = line.split("\\s+"); // Tách các từ trong dòng

            // Xử lý từng hành động trong dòng
            for (int i = 0; i < actions.length; i += 2) {
                int userId = Integer.parseInt(actions[i]); // Lấy user ID
                String task = actions[i + 1]; // Lấy hành động

                // Thực hiện hành động tương ứng
                switch (task) {
                    case "Booking":
                        System.out.print(FlightBooking.bookSeat(userId));
                        break;
                    case "Confirmed":
                        System.out.print(FlightBooking.confirmBooking(userId));
                        break;
                    case "Cancel":
                        System.out.print(FlightBooking.cancelBooking(userId));
                        break;
                    default:
                        System.out.print("Invalid task");
                }
            }
            System.out.println(); // Xuống dòng sau mỗi test case
        }
        scanner.close();
    }
}