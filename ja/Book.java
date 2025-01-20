class Book{
   int bookId;
   String title;
   String auther;
   static boolean available=true;
   Book(int bookId,String title,String auther,boolean available){
      this.bookId=bookId;
	  this.title=title;
	  this.auther=auther;
	  this.available=available;
}
   public void borrowedBook(){
	   available=false;
   }
   public void returnBook(){
	   available=true;
   }
   public void displayInfo(){
	   System.out.println("BookId:"+this.bookId+" "+"Booktitle:"+this.title+" "+"auther: "+this.auther+""+"availability:"+available);
   }
}
class Member{
  int memberId;
  String name;
  Book borrowedBook;
  Member(int memberId,String name){
	  this.name=name;
	  this.memberId=memberId;
  }
  public void borrowBook(Book b){
	  borrowedBook=b;
  }
  
  public void displayInfo(){
	  System.out.println("MemberId:"+memberId+"  "+"Name:"+name);
  }
  

}
class LibraryManagement{
	public static void main(String[]args){
		Book b1=new Book(1,"book1","auther1",true);
		Book b2=new Book(2,"book2","auther2",false);
		Book b3=new Book(3,"book3","auther3",false);
		Member m1=new Member(1,"Nadun");
		Member m2=new Member(2,"Sandeepa");
		m1.borrowBook(b1);
		m2.borrowBook(b2);
		m1.displayInfo();
		m2.displayInfo();
		b1.displayInfo();
		b2.displayInfo();
		}
}