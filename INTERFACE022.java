import java.util.*;
import java.util.regex.*;

interface Identifiable {
   String getId();
}

interface Payable {
    double calculateMonthPay();
}

class FullTime implements Payable, Identifiable {
    private  String name;
    private  String id;
    private  double monthlySalary;

    public FullTime(String name, String id, double monthlySalary) {
        this.name = name;
        this.id = id;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double calculateMonthPay() {
        return monthlySalary;
    }
}

class PartTime implements Payable, Identifiable {
    private  String name;
    private  String id;
    private  double hourlyRate;
    private  int hoursWorked;

    public PartTime(String name, String id, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double calculateMonthPay() {
        return hourlyRate * hoursWorked;
    }
}

public class INTERFACE022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("(FullTime|PartTime)\\s+\"([^\"]+)\"\\s+(\\S+)\\s+(\\d+(?:\\.\\d+)?)(?:\\s+(\\d+))?");

        while (testCases-- > 0) {
            List<Payable> employees = new ArrayList<>();
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("Calculate")) break;

                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String type = matcher.group(1);
                    String name = matcher.group(2);
                    String id = matcher.group(3);
                    double amount = Double.parseDouble(matcher.group(4));

                    if (type.equals("FullTime")) {
                        employees.add(new FullTime(name, id, amount));
                    } else {
                        int hours = Integer.parseInt(matcher.group(5));
                        employees.add(new PartTime(name, id, amount, hours));
                    }
                }
            }

            double total = 0;
            for (Payable e : employees) {
                total += e.calculateMonthPay();
            }
            System.out.printf("Total Monthly Payroll: %.2f\n", total);
        }
    }
}