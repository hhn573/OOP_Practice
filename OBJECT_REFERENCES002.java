import java.util.Scanner;

class Song {
    private String name;
    private String author;
    private int duration; // in seconds

    public Song (String name, String author, int duration) {
        this.name = name;
        this.author = author;
        this.duration = duration;
    }

    public boolean equals(Song song) {
        if (song == null) {
            return false;
        }
        return this.name.equals(song.name) && this.author.equals(song.author) && this.duration == song.duration;
    }
}

public class OBJECT_REFERENCES002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < t; i++) {
            String[] info1 = sc.nextLine().split(" ");
            String name1 = info1[0];
            String author1 = info1[1];
            int duration1 = Integer.parseInt(info1[2]);

            
            String[] info2 = sc.nextLine().split(" ");
            String name2 = info2[0];
            String author2 = info2[1];
            int duration2 = Integer.parseInt(info2[2]);

            // Tạo đối tượng Song
            Song song1 = new Song(name1, author1, duration1);
            Song song2 = new Song(name2, author2, duration2);

           
            System.out.println(song1.equals(song2));
        }
    }
}
