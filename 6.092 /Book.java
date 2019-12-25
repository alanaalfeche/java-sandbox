public class Book {
    String title;
    boolean borrowed;

    // creates a new book
    public Book(String bookTitle) {
        this.title = bookTitle;
        this.borrowed = false;
    }

    // marks the book as rented
    public void borrowed() {
        this.borrowed = true;
    }

    // marks the book as not rented
    public void returned() {
        this.borrowed = false;
    }

    // returns true if book is rented, false otherwise
    public boolean isBorrowed() {
        return borrowed;
    }

    // returns the title of the book 
    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}