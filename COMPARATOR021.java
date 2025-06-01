import java.util.*;

class Job {
    private String name;
    private int priority;
    private int time; //minutes

    public Job(String name, int priority, int time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getTime() {
        return time;
    }
    
    public String toString() {
        return name + " " + priority + " " + time;
    }
}

public class COMPARATOR021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        List<Job> jobs = new ArrayList<>();
        while (t-- > 0) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String name = parts[0];
            int priority = Integer.parseInt(parts[1]);
            int time = Integer.parseInt(parts[2]);
            jobs.add(new Job(name, priority, time));
        }

         // Sắp xếp theo ưu tiên: độ ưu tiên nhỏ nhất, thời gian nhỏ nhất, tên tăng dần
        jobs.sort(Comparator.comparingInt(Job::getPriority)
                .thenComparingInt(Job::getTime)
                .thenComparing(Job::getName));

        // In ra công việc ưu tiên nhất
        if (!jobs.isEmpty()) {
            System.out.println(jobs.get(0));
        }
        sc.close();
    }
}
