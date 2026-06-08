import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private boolean isAvailable;

    public Book(String name, String author, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book Name: " + name +
               " | Author: " + author +
               " | Status: " + (isAvailable ? "Available" : "Issued");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String name, String author) {
        books.add(new Book(name, author, true));
        System.out.println("Book added successfully!\n");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.\n");
            return;
        }

        System.out.println("\n===== Library Books =====");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void issueBook(String name) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {

                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book \"" + book.getName() + "\" issued successfully.\n");
                } else {
                    System.out.println("Sorry, \"" + book.getName() + "\" is already issued.\n");
                }
                return;
            }
        }

        System.out.println("Book \"" + name + "\" not found in the library.\n");
    }

    public void returnBook(String name) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {

                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book \"" + book.getName() + "\" returned successfully.\n");
                } else {
                    System.out.println("Book \"" + book.getName() + "\" is already available.\n");
                }
                return;
            }
        }

        System.out.println("Book \"" + name + "\" not found in the library.\n");
    }
}

public class LibraryManagementSystem {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();
        boolean exit = false;

        while (!exit) {

            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    library.addBook(name, author);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Name to Issue: ");
                    String issueName = sc.nextLine();

                    library.issueBook(issueName);
                    break;

                case 4:
                    System.out.print("Enter Book Name to Return: ");
                    String returnName = sc.nextLine();

                    library.returnBook(returnName);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }

        sc.close();
    }
}
