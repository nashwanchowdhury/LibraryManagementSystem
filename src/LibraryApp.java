import java.util.ArrayList;
import java.util.List;

public class LibraryApp {
    public static void main(String[] args) {

        Book book1 = new Book("The Giver", 1925, "F. Scott Fitzgerald", 1234);
        Book book2 = new Book("Tom Sawyer", 1960, "Harper Lee", 12345);
        DVD dvd1 = new DVD("Harry Potter and Chamber of Secrets", 2010, "Christopher Nolan", 1234456);
        DVD dvd2 = new DVD("The Lion King", 2008, "Christopher Nolan", 46578);

        LibraryManager<LibraryItem> library = new LibraryManager<>();

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd1);
        library.addItem(dvd2);

        library.displayItems();
        library.removeItem(book2);
        library.displayItems();
    }
}
abstract class LibraryItem {
    String title;
    int releaseYear;

    public LibraryItem(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }
    public abstract String getItemType();
    public abstract String getItemDetails();
}
class Book extends LibraryItem {
    String author;
    int ISBN;
    public Book(String title, int releaseYear, String author, int ISBN) {
        super(title, releaseYear);
        this.author = author;
        this.ISBN = ISBN;
    }
    @Override
    public String getItemType() {
        return "Book";
    }
    @Override
    public String getItemDetails() {
        return "Title: " + getTitle() + ", Author: " + author + ", ISBN: " + ISBN;
    }
}
class DVD extends LibraryItem {
    String director;
    int duration;

    public DVD(String title, int releaseYear, String director, int duration) {
        super(title, releaseYear);
        this.director = director;
        this.duration = duration;
    }
    @Override
    public String getItemType() {
        return "DVD";
    }
    @Override
    public String getItemDetails() {
        return "Title: " + getTitle() + ", Director: " + director + ", Duration: " + duration + " minutes";
    }
}
interface LibraryOperations<T extends LibraryItem> {
    void addItem(T item);

    void removeItem(T item);

    void displayItems();
}
class LibraryManager<T extends LibraryItem> implements LibraryOperations<T> {
    List<T> items;

    public LibraryManager() {
        items = new ArrayList<>();
    }
    @Override
    public void addItem(T item) {
        items.add(item);
    }
    @Override
    public void removeItem(T item) {
        items.remove(item);
    }
    @Override
    public void displayItems() {
            System.out.println("The current library includes:");
            for (T item : items) {
                System.out.println(item.getItemDetails());
                System.out.println();
            }
        }
    }


