class Book {
  int bookID;
  String title;
  String author;
  boolean available;
  
  Book(int bookID, String title, String author, boolean available) {
    this.bookID = bookID;
    this.title = title;
    this.author = author;
    this.available = available;
  }
  
  void borrowBook() {
    this.available = false;
  }
  
  void returnBook() {
    this.available = true;
  }
  
  void displayInfo() {
    System.out.println("Book ID:\t" + this.bookID);
    System.out.println("Title:\t" + this.title);
    System.out.println("Author:\t" + this.author);
    if(this.available) {
      System.out.println("The book is available.");
    } else {
      System.out.println("The book is not available.");
    }
    System.out.println();
  }
}

class Member {
  int memberID;
  String name;
  Book borrowedBook = null;
  
  Member(int memberID, String name) {
    this.memberID = memberID;
    this.name = name;
  }
  
  void borrowBook(Book b) {
    if(b.available) {
      this.borrowedBook = b;
      b.borrowBook();
    }
  }
  
  void returnBook() {
    this.borrowedBook.returnBook();
    this.borrowedBook = null;
  }
  
  void displayInfo() {
    System.out.println("Member ID:\t" + this.memberID);
    System.out.println("Name:\t" + this.name);
    System.out.println();
    
    if(this.borrowedBook != null) {
      System.out.println("Details of borrowed book:");
      this.borrowedBook.displayInfo();
    }
  }
}

public class Library {
  public static void main(String[] args) {
    // Creating individual Book objects
    Book book1 = new Book(1, "C", "Praveen", true);
    Book book2 = new Book(2, "C++", "Sandaru", true);
    Book book3 = new Book(3, "Java", "Kasun", true);
    Book book4 = new Book(4, "Python", "Dewkith", true);
    Book book5 = new Book(5, "C#", "Nirmala", true);

    // Creating individual Member objects
    Member member1 = new Member(1, "Rasindu");
    Member member2 = new Member(2, "Rusiru");
    Member member3 = new Member(3, "Rashmi");

    // Borrowing books
    member1.borrowBook(book5);  // Rasindu borrows C#
    member2.borrowBook(book3);  // Rusiru borrows Java
    member3.borrowBook(book2);  // Rashmi borrows C++

    // Returning books
    member1.returnBook();  // Rasindu returns C#
    member3.returnBook();  // Rashmi returns C++

    // Rasindu borrows another book
    member1.borrowBook(book1);  // Rasindu borrows C

    // Displaying details of all members and their borrowed books
    System.out.println("Details of Members:\n");
    member1.displayInfo();  // Display member1 info
    member2.displayInfo();  // Display member2 info
    member3.displayInfo();  // Display member3 info

    // Displaying details of all books
    System.out.println("Details of Books:\n");
    book1.displayInfo();  // Display book1 info
    book2.displayInfo();  // Display book2 info
    book3.displayInfo();  // Display book3 info
    book4.displayInfo();  // Display book4 info
    book5.displayInfo();  // Display book5 info
  }
}