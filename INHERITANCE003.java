class Person {
    protected String name;
    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String toString() {
        return name + " - " + address;
    }
}

class Student extends Person {
    protected int credits;
    protected int studentID;

    public Student(String name, String address, int credits, int studentID) {
        super(name, address);
        this.credits = credits;
        this.studentID = studentID;
    }

    public void study() {
        credits++;
    }

    public void getCredits() {
        System.out.println("Study credits " + credits);
    }
}
public class INHERITANCE003 {
    public static void main(String[] args) {
        Student student = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028", 0, 90028);
        System.out.println(student.toString());
        student.getCredits();
        student.study();
        student.getCredits();
    }
}
