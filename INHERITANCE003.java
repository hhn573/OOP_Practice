class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString () {
        return name + " - " + address;
    }
}

class Student extends Person {
    private int creadits;
    private int StudentID;

    public Student(String name, String address, int creadits, int StudentID) {
        super(name, address);
        this.creadits = creadits;
        this.StudentID = StudentID;
    }

    public void study() {
        creadits++;
    }

    public int getCreadits() {
        return creadits;
    }   
}

public class INHERITANCE003 {
    public static void main(String[] args) {
        Student student = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028", 0, 123456);
        System.out.println(student.toString());
        System.out.println("Study credits " + student.getCreadits());
        student.study();
        System.out.println("Study credits " + student.getCreadits());
    }
}
