class  Person {
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

    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }
}

class Student extends Person {
    private int credits;

    public Student(String name, String address, int credits) {
        super(name, address);
        this.credits = credits;
    }

    public void study() {
        credits++;
    }

    public int getCredits() {
        return credits;
    }
}


public class INHERITANCE008 {
    public static void main(String[] args) {
        Student student = new Student ("Ollie", " - 6381 Hollywood Blvd. Los Angele", " 90028");
        
        System.out.println(student);

    
    
    
    }
}
