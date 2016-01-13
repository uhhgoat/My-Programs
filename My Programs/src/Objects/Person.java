package Objects ;

import java.util.ArrayList;

public class Person
{
	private String firstName ;
	private String middleName ;
	private String lastName ;
	public static int MAX_ALLOWED_BOOKS = 3;
	ArrayList<Book> checkedOutBooks ;
	static boolean male ;
	Balance balance; 
	
	public Balance getBalance() {
		return balance;
	}
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	public static boolean isMale() {
		return male;
	}
	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	//constructor
	//no return type: it "returns"(constructs) a Person
	public Person(String firstName, String lastName, boolean male)
	{
		this.firstName = firstName ;
		this.middleName = "" ;
		this.lastName = lastName ;
		this.checkedOutBooks = checkedOutBooks ;
		this.male = male ;
		this.checkedOutBooks = new ArrayList<Book>() ;
		this.balance = new Balance() ;
	}
	public Person(String firstName, String middleName, String lastName, boolean male)
	{
		this.firstName = firstName ;
		this.middleName = middleName ;
		this.lastName = lastName ;
		this.checkedOutBooks = checkedOutBooks ;
		this.male = male ;
		this.checkedOutBooks = new ArrayList<Book>() ;
		this.balance = new Balance() ;
	}
	
	public void checkOutBook(Book book)
	{
		book.setCheckedOut(true) ;
		book.setCheckOutDate(System.currentTimeMillis()) ;
		book.setDueDate(System.currentTimeMillis()+30000) ;
		checkedOutBooks.add(book) ;
	}
	public void returnBook(Book book)
	{
		book.setCheckedOut(false) ;
		book.updateCondition(System.currentTimeMillis());
		balance.subtractLateFees(book.getDueDate()-System.currentTimeMillis());
		book.setCheckOutDate(0) ;
		book.setDueDate(0) ;
		checkedOutBooks.remove(book) ;
	}
	
	public void renewBook(Book book)
	{
		book.setDueDate(System.currentTimeMillis()+30000) ;
	}
	public String getGenderPosessivePronoun()
	{
		if(male)
			return "his" ;
		return "her" ;
	}
	public String getLibraryDescription(){
		return firstName +" is thinking of barrowing a book and his balance is $" + balance.getAmount() + "0" ; 
	}
	
	public void printName()
	{
		if(middleName.equals(""))
		{
			System.out.println(firstName + " " + lastName) ;
		}
		else
		{
			System.out.println(firstName + " " + middleName + " " + lastName) ;
		}
	}
	public String getName()
	{
		if(middleName.equals(""))
		{
			return firstName + " " + lastName ;
		}
		else
		{
			return firstName + " " + middleName + " " + lastName ;
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String toString()
	{
		if(middleName.equals(""))
		{
			return firstName + " " + lastName ;
		}
		else
		{
			return firstName + " " + middleName + " " + lastName ;
		}
	}
}
