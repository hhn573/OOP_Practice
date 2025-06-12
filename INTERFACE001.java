interface Packable {
    double weight();
}

class Book implements Packable {
    protected String author;
    protected String name;
    protected double weight;

    public Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return author + ": " + name;
    }

}

class CD {
    protected String artist;
    protected String name;
    protected int publicationYear;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public String toString() {
        return artist + ": " + name + " (" + publicationYear + ")";
    }
}


public class INTERFACE001 {
    public static void main(String[] args) {
        Packable book = new Book("Fyodor Dostoevsky", "Crime and Punishment", 2);
        Packable book1 = new Book("Robert Martin", "Clean Code", 1);
        Packable book2 = new Book("Kent Beck", "Test Driven Development", 0.5);
        
        System.out.println(book.toString());
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        
        
        
    }
}   