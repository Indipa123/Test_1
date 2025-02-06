class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + available);
    }
}

class Member {
    private int memberID;
    private String name;
    private Book borrowedBook;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedBook = null;
    }

    public void borrowBook(Book b) {
        if (b.isAvailable()) {
            b.borrowBook();
            borrowedBook = b;
            System.out.println(name + " borrowed " + b);
        } else {
            System.out.println("Sorry, " + name + " cannot borrow " + b + " as it is already borrowed.");
        }
    }

    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returnBook();
            borrowedBook = null;
        } else {
            System.out.println(name + " has no book to return.");
        }
    }

    public void displayInfo() {
        System.out.println("Member ID: " + memberID + ", Name: " + name + ", Borrowed Book: " + (borrowedBook != null ? borrowedBook : "None"));
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book(101, "Java Programming", "James Gosling");
        Book book2 = new Book(102, "Effective Java", "Joshua Bloch");
        Book book3 = new Book(103, "Clean Code", "Robert C. Martin");

        // Creating member objects
        Member member1 = new Member(1, "Alice");
        Member member2 = new Member(2, "Bob");

        // Borrowing books
        member1.borrowBook(book1);
        member2.borrowBook(book1); // Should fail since book1 is already borrowed
        member2.borrowBook(book2);

        // Returning books
        member1.returnBook();
        member2.returnBook();

        // Displaying information
        System.out.println("\nBook Details:");
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        System.out.println("\nMember Details:");
        member1.displayInfo();
        member2.displayInfo();
    }
}