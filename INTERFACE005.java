
interface Identifiable {
    String getId();
}

interface getBirthday {
    String getBirthday();
}

class Citizen {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getBirthDay() {
        return birthDate;
    }

}

public class INTERFACE005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Citizen> citizens = new ArrayList<>();
        int t = nextInt();
        
        sc.close();
    }
}
