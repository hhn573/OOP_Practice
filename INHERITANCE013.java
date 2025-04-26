import java.util.*;

class Teacher {
    protected String name;
    protected double baseSalary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getInfo() {
        return name;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class PermanentLecturer extends Teacher {
    protected double researchAllowance;

    public PermanentLecturer(String name, double baseSalary, double researchAllowance) {
        super(name, baseSalary);
        this.researchAllowance = researchAllowance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + researchAllowance;
    }
}

class VisitingLecturer extends Teacher {
    protected int teachingHours;
    protected double paymentPerHour;

    public VisitingLecturer(String name, int teachingHours, double paymentPerHour) {
        super(name, 0); // Không dùng baseSalary
        this.teachingHours = teachingHours;
        this.paymentPerHour = paymentPerHour;
    }

    @Override
    public double calculateSalary() {
        return teachingHours * paymentPerHour;
    }
}

public class INHERITANCE013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Thông tin giảng viên ---");

        Vector<String> data = new Vector<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;
            data.add(input);
        }
        scanner.close();

        for (int i = 0; i + 3 < data.size(); i += 4) {
            String type = data.get(i);
            String name = data.get(i + 1);
            double val1 = Double.parseDouble(data.get(i + 2));
            double val2 = Double.parseDouble(data.get(i + 3));

            if (type.equals("PermanentLecturer")) {
                PermanentLecturer pl = new PermanentLecturer(name, val1, val2);
                System.out.println("Loại giảng viên: Permanent");
                System.out.println("Họ tên: " + pl.getInfo());
                System.out.println("Lương thực nhận: " + pl.calculateSalary());
            } else if (type.equals("VisitingLecturer")) {
                VisitingLecturer vl = new VisitingLecturer(name, (int) val1, val2);
                System.out.println("Loại giảng viên: Visiting");
                System.out.println("Họ tên: " + vl.getInfo());
                System.out.println("Lương thực nhận: " + vl.calculateSalary());
            } else {
                System.out.println("Loại giảng viên không hợp lệ.");
            }
        }
    }
}
