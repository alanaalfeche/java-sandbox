import java.util.ArrayList;

public class Library {
    String address;
    ArrayList<Book> books = new ArrayList<Book>();

    public Library(String libraryAddress) {
        this.address = libraryAddress;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    private static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    private void printAddress() {
        System.out.println(this.address);
    }

    private void borrowBook(String bookTitle) {
        for(Book book : books) {
            if (bookTitle == book.getTitle()){
                if(!book.isBorrowed()){
                    book.borrowed();
                    System.out.println("You successfully borrowed The Lord of the Rings");
                    return;
                } else if(book.isBorrowed()){
                    System.out.println("Sorry, this books is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

    private void returnBook(String bookTitle) {
        for (Book book: books) {
            if (bookTitle == book.getTitle()){
                book.returned();
                System.out.println("You successfully returned The Lord of the Rings");
            }
        }
    }
    
    private void printAvailableBooks() {
        if (books.size() != 0){
            for (Book book: books) {
                if(!book.isBorrowed()) {
                    System.out.println(book.title);
                }
            }    
        } else {
            System.out.println("No book in catalog");
        }
    }

    public static void main(String[] args) {
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("La Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        System.out.println("Library Hours: ");
        printOpeningHours();
        System.out.println();

        System.out.println("Library Hours:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        System.out.println("Borrowing the Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        System.out.println("Returning the Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books available in the first library");
        firstLibrary.printAvailableBooks();
    }
}