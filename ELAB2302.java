import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private int numberOfStudent;

    public Student(String name, int age, int numberOfStudent) {
        this.name = name;
        this.age = age;
        this.numberOfStudent = numberOfStudent;
    }

    public void display(){
        if (age >= 18) {
            Sypstem.out.println(name);
        }
    }
}

public class ELAB2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int a = sc.nextInt();

        

    }
}
