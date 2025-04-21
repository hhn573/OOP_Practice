import java.util.Scanner;

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void getInfor() {
        System.out.println("Họ tên: " + name);
        
    }

    public double calculateSalary() {
        return salary;
    }
}

class FullTimeEmployee extends Employee {
    protected double bonus;

    public FullTimeEmployee(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public void getInfor() {
        System.out.println("Loại: FullTime");
        System.out.println("Họ tên: " + name);
        System.out.printf("Lương cơ bản: %.1f\n", salary);
        System.out.printf("Thưởng: %.1f\n", bonus);
        System.out.printf("=> Lương thực nhận: %.1f\n", calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    protected int hourWorked;
    protected double hourlyRate;

    public PartTimeEmployee(String name, double salary, int hourWorked, double hourlyRate) {
        super(name, salary);
        this.hourWorked = hourWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourWorked * hourlyRate;
    }

    @Override
    public void getInfor() {
        System.out.println("Loại: PartTime");
        System.out.println("Họ tên: " + name);
        System.out.printf("Lương cơ bản: %.1f\n", salary);
        System.out.println("Số giờ làm việc: " + hourWorked + " giờ");
        System.out.printf("Tiền công mỗi giờ: %.1f\n", hourlyRate);
        System.out.printf("=> Lương thực nhận: %.1f\n", calculateSalary());
    }
}

public class INHERITANCE012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[2];

        System.out.println("--- Thông tin nhân viên ---");
        for (int i = 0; i < 2; i++) {
            String type = scanner.nextLine();
            String name = scanner.nextLine();

            if (type.equals("FullTime")) {
                double salary = Double.parseDouble(scanner.nextLine());
                double bonus = Double.parseDouble(scanner.nextLine());
                employees[i] = new FullTimeEmployee(name, salary, bonus);
            } else if (type.equals("PartTime")) {
                double salary = Double.parseDouble(scanner.nextLine()); 
                int hours = Integer.parseInt(scanner.nextLine());
                double rate = Double.parseDouble(scanner.nextLine());
                employees[i] = new PartTimeEmployee(name, salary, hours, rate);
            }

            employees[i].getInfor();
            if (i == 0) System.out.println(); 
        }

        scanner.close();
    }
}
