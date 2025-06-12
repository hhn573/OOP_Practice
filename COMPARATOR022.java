import java.util.*;

class Student {
     String name;
     int bornYear;
     double gpa;
     int tinChi; // Số tín chỉ đã tích lũy

    public Student(String name, int bornYear, double gpa, int tinChi) {
        this.name = name;
        this.bornYear = bornYear;
        this.gpa = gpa;
        this.tinChi = tinChi;
    }

}

public class COMPARATOR022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
        int t = Integer.parseInt(sc.nextLine().trim());
        List<Student> students = new ArrayList<>();
        while (t-- > 0) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String name = parts[0];
            int bornYear = Integer.parseInt(parts[1]);
            double gpa = Double.parseDouble(parts[2]);
            int tinChi = Integer.parseInt(parts[3]);
            students.add(new Student(name, bornYear, gpa, tinChi));
        }
        String sortType = sc.nextLine().trim();
        if (sortType.equals("BY_GPA_CREDIT_NAME")) {
            students.sort(Comparator
                .comparingDouble((Student s) -> s.gpa).reversed()
                .thenComparing((Student s) -> s.tinChi, Comparator.reverseOrder())
                .thenComparing(s -> s.name)
            );
        } else if (sortType.equals("BY_BIRTH_GPA_NAME")) {
            students.sort(Comparator
                .comparingInt((Student s) -> s.bornYear)
                .thenComparing((Student s) -> s.gpa, Comparator.reverseOrder())
                .thenComparing(s -> s.name)
            );
        }
        for (Student s : students) {
            System.out.println(s.name + " " + s.bornYear + " " + s.gpa + " " + s.tinChi);
        }
        sc.close();

    }
}  