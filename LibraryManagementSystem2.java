import java.util.ArrayList;
import java.util.Scanner;

class Books {
    private String name;
    private String author;
    private boolean isAvailable;

    public Books(String name, String author, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Books [name=" + name +
                ", author=" + author +
                ", isAvailable=" + isAvailable + "]";
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Librarys {
    private ArrayList<Books> books = new ArrayList<>();

    public void addBook(String name, String author) {
        Books book = new Books(name, author, true);
        books.add(book);
        System.out.println("The Book has Been added to library !");
        System.out.println();
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Books book : books) {
                System.out.println(book);
            }
            System.out.println();
        }
    }

    

    public void issueBook(String name) {
        for (Books book : books) {
        if (book.getName().equalsIgnoreCase(name)) {

            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("The Book " + book.getName() + " has been issued from library.");
            } else {
                System.out.println("Sorry, the Book " + book.getName() + " is not available for issue.");
            }

            return;
        }
    }
        System.out.println("The Book " + name + "  no found in Library.");

    }

    public void returnBook(String name) {
        for (Books book : books) {
        if (book.getName().equalsIgnoreCase(name)) {

            if (!book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("The Book " + book.getName() + " has been returned.");
            } else {
                System.out.println("The Book " + book.getName() + " is already available in library.");
            }

            return;
        }
    }
         System.out.println("The Book " + name + "  not found in Library.");
    }

}

public class LibraryManagementSystem2 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Librarys library = new Librarys();
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Library Management System === :");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(name, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book name to issue: ");
                    String issueName = sc.nextLine();
                    library.issueBook(issueName);
                    break;
                case 4:
                    System.out.print("Enter book name to return: ");
                    String returnName = sc.nextLine();
                    library.returnBook(returnName);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                
            }
        }
        sc.close();
    }
}