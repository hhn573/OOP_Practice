import java.util.*;
interface Identifiable {
    String getId();
}

interface Birthable {
    String getBirthday(); // Giữ tên hàm là getBirthday() để đồng nhất
}

class Citizen implements Identifiable, Birthable {
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthday() {
        return birthDate;
    }
}

class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthday() {
        return birthDate;
    }
}

public class INTERFACE005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Số lượng test case

        for (int i = 0; i < t; i++) {
            List<Birthable> birthdayEntities = new ArrayList<>();

            while (true) {
                String line = sc.nextLine();
                if (line.equals("End")) break;

                String[] tokens = line.split(" ");
                String type = tokens[0];

                if (type.equals("Citizen")) {
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    birthdayEntities.add(new Citizen(name, age, id, birthDate));
                } else if (type.equals("Pet")) {
                    String name = tokens[1];
                    String birthDate = tokens[2];
                    birthdayEntities.add(new Pet(name, birthDate));
                }
            }

            String year = sc.nextLine(); 

            for (Birthable entity : birthdayEntities) {
                if (entity.getBirthday().endsWith(year)) {
                    System.out.println(entity.getBirthday());
                }
            }
        }

        sc.close();
    }
}
