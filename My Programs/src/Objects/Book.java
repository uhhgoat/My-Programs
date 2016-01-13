package Objects ;

import java.awt.Color;

public class Book
{
	private String title ;
	private int numberOfPages ;
	private Person author ;
	private Color jacketColor ;
	private int height ;
	private int thickness ;
	private boolean wasLitOnFire ;
	
	





	public static void setConditions(String[] conditions) {
		Book.conditions = conditions;
	}
	private boolean checkedOut ;
	private long checkOutDate ;
	private long dueDate ;
	
	String description ;
	int accumulatedUse;
	
	static public String[] conditions = {"This apears to be a brand new book! How lucky!",
			"This book is very gently used",
			"This book is a bit worn out",
			"This book is pretty old"};
	
	public Book(String title, int numOfPages, Person author)
	{
		this.title = title ;
		this.numberOfPages = numOfPages ;
		this.author = author ;
		this.jacketColor = Color.gray ;
		this.wasLitOnFire = false ;
		this.height = (int)((Math.random()*100)+150) ;
		this.thickness = numberOfPages/10 ;
		this.checkedOut = false;
		this.checkOutDate = 0;
		this.dueDate = 0;
		this.description = conditions[0];
		this.accumulatedUse = 0;
	}
	
	
	public void updateCondition(long timeOfReturn){
		accumulatedUse += (timeOfReturn-checkOutDate)/1000;
		if (accumulatedUse>30) description = conditions[1];
		if (accumulatedUse>50) description = conditions[2];
		if (accumulatedUse>60) description = conditions[3];
	}
	
	
	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public int getAccumulatedUse() {
		return accumulatedUse;
	}





	public void setAccumulatedUse(int accumulatedUse) {
		this.accumulatedUse = accumulatedUse;
	}





	public static String[] getConditions() {
		return conditions;
	}
	
	public long getSecondsRemaining()
	{
		return (int)((dueDate-System.currentTimeMillis())/1000) ;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public void setWasLitOnFire(boolean wasLitOnFire) {
		this.wasLitOnFire = wasLitOnFire;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isWasLitOnFire() {
		return wasLitOnFire;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}

	public int getHeight() {
		return height;
	}

	public int getThickness() {
		return thickness;
	}
	
	public Color getJacketColor() {
		return jacketColor;
	}

	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}

	public void printInfo()
	{
		System.out.println("\"" + title + "\" by " + author.getName() + ". " + numberOfPages + " pages.") ;
	}
	public String getTitle()
	{
		return this.title ;
	}
	public int getNumberOfPages()
	{
		return this.numberOfPages ;
	}
	
	public Person getAuthor()
	{
		return author;
	}

	public String toString()
	{
		if(wasLitOnFire)
			return "Author's name is charred and cannot be made out..." ;
		return "\"" + title + "\" by " + author + ". " + numberOfPages + " pages, height of " + height + "." ; 
	}
	public void setOnFire()
	{
		this.jacketColor = Color.black ;
		this.title = "The title of this book is too charred to make out" ;
		wasLitOnFire = true ;
	}
}
