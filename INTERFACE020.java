import java.util.*;

interface Identifiable {
    String getId();
}

class Human implements Identifiable {
    private String name;
    private int age;
    private String id;

    public Human(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}

class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}

public class INTERFACE020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Số lượng test case
        List<Identifiable> identifiableEntities = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            while (true) {
                String line = sc.nextLine();
                if (line.equals("End")) {
                    break;
                }

                String[] parts = line.split(" ");
                if (parts[0].equals("Human")) {
                    // Tên có thể gồm nhiều từ, age và id là hai phần cuối
                    String id = parts[parts.length - 1];
                    int age = Integer.parseInt(parts[parts.length - 2]);
                    StringBuilder nameBuilder = new StringBuilder();
                    for (int j = 1; j < parts.length - 2; j++) {
                        nameBuilder.append(parts[j]);
                        if (j < parts.length - 3) nameBuilder.append(" ");
                    }
                    String name = nameBuilder.toString();
                    identifiableEntities.add(new Human(name, age, id));
                } else if (parts[0].equals("Robot")) {
                    // Model có thể có nhiều từ, id là phần cuối
                    String id = parts[parts.length - 1];
                    StringBuilder modelBuilder = new StringBuilder();
                    for (int j = 1; j < parts.length - 1; j++) {
                        modelBuilder.append(parts[j]);
                        if (j < parts.length - 2) modelBuilder.append(" ");
                    }
                    String model = modelBuilder.toString();
                    identifiableEntities.add(new Robot(model, id));
                }
            }

            String fakeIdEnding = sc.nextLine();
            for (Identifiable entity : identifiableEntities) {
                if (entity.getId().endsWith(fakeIdEnding)) {
                    System.out.println(entity.getId());
                }
            }
        }
        sc.close();
    }
}
