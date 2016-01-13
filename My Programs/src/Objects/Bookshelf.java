package Objects;

import java.awt.*;
import java.util.*;

import javax.swing.JFrame;

public class Bookshelf
{
	public static void main(String[] args)
	{
		Person author1 = new Person("Noah", "Webster", true) ;
		Person author2 = new Person("George", "R. R.", "Martin", true) ;
		Person author3 = new Person("Anthony", "Burgess", true) ;
		Book book1 = new Book("The Dictionary", 1001, author1) ;
		Book book2 = new Book("Game of Thrones", 999, author2) ;
		Book book3 = new Book("A Clockwork Orange", 600, author3) ;
		book3.setJacketColor(Color.orange) ;
		
		ArrayList<Book> shelf = new ArrayList<Book>() ;
		shelf.add(book1) ;
		shelf.add(book2) ;
		shelf.add(book3) ;
		shelf.add(new Book("The Man in the High Castle", 600, author3)) ;
		Book book5 = new Book("The Minority Report", 589, author3) ;
		shelf.add(book5) ;
		
		Person person1 = new Person("Matyas", "Fenyves", true) ;
		Person person2 = new Person("Matyas2", "Fenyves2", true) ;
		Person person3 = new Person("Matyas3", "Fenyves3", true) ;
		Person person4 = new Person("Matyas4", "Fenyves4", true) ;
		Person person5 = new Person("Matyas5", "Fenyves5", true) ;
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>() ;
		libraryCardHolders.add(person1) ;
		libraryCardHolders.add(person2) ;
		libraryCardHolders.add(person3) ;
		libraryCardHolders.add(person4) ;
		libraryCardHolders.add(person5) ;
//		Collections.sort(shelf, new Comparator<Book>()
//			{
//				public int compare(Book a, Book b)
//				{
//					return a.getNumberOfPages() - b.getNumberOfPages();
//				}
//			}
//		);
//		printAll(shelf) ;
		
		
//		Collections.sort(shelf, new Comparator<Book>()
//				{
//					public int compare(Book a, Book b)
//					{
//						return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
//					}
//				}
//			);
//			printAll(shelf) ;
		
			
//			Collections.sort(shelf, new Comparator<Book>()
//				{
//					public int compare(Book a, Book b)
//					{
//						return b.getHeight() - a.getHeight();
//					}
//				}
//			);
//			printAll(shelf) ;
			
			Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

			lib.setSize(new Dimension(1000,1000));
			
//			lib.setResizable(false) ;

			lib.setVisible(true);
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize() ;
			int w = lib.getSize().width ;
			int h = lib.getSize().height ;
			int x = (dim.width - w)/2 ;
			int y = (dim.height - h)/2 ;
			lib.setLocation(x,y) ;

			lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private static void printAll(ArrayList list)
	{
		for(int i = 0 ; i < list.size() ; i++)
		{
			System.out.println(list.get(i)) ;
		}
	}
	public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf)
	{
		
		Collections.sort(shelf, new Comparator<Book>()
				{
					public int compare(Book a, Book b)
					{
						if(ascending)
							return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
						else
							return b.getAuthor().getLastName().compareTo(a.getAuthor().getLastName());
					}
				}
			);
			printAll(shelf) ;
	}
	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf)
	{
		Collections.sort(shelf, new Comparator<Book>()
				{
					public int compare(Book a, Book b)
					{
						if(ascending)
							return a.getNumberOfPages() - b.getNumberOfPages();
						else
							return b.getNumberOfPages() - a.getNumberOfPages();
					}
				}
			);
			printAll(shelf) ;
	}
	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf)
	{
		Collections.sort(shelf, new Comparator<Book>()
				{
					public int compare(Book a, Book b)
					{
						if(ascending)
							return a.getHeight() - b.getHeight();
						else
							return b.getHeight() - a.getHeight();
					}
				}
			);
			printAll(shelf) ;
	}
	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf)
	{
		Collections.sort(shelf, new Comparator<Book>()
				{
					public int compare(Book a, Book b)
					{
						if(ascending)
							return a.getTitle().compareTo(b.getTitle());
						else
							return b.getTitle().compareTo(a.getTitle());
					}
				}
			);
			printAll(shelf) ;
	}
	private static void ArrayListStuff()
	{
		//		System.out.println(book1) ;
//		System.out.println(book2) ;
//		System.out.println(book3) ;
//		author1.printName() ;
//		System.out.println("") ;
//		author2.printName() ;
//		System.out.println("") ;
//		author3.printName() ;
//		System.out.println("") ;
//		book1.printInfo() ;
//		System.out.println("") ;
		
//		
//		ArrayList<Book> shelf = new ArrayList<Book>() ;
//		shelf.add(book1) ;
//		shelf.add(book2) ;
//		shelf.add(book3) ;
//		shelf.add(new Book("The Man in the High Castle", 600, author3)) ;
		
		
		
//		System.out.println("The first book on the shelf is " + shelf.get(0)) ;
		
//		for(Book b: shelf)
//			b.printInfo() ;
//		
//		System.out.println("") ;
//		System.out.println("The length (size) of the shelf is " + shelf.size() + " books.") ;
//		System.out.println("") ;
//		
//		Book book5 = new Book("The Minority Report", 589, author3) ;
//		shelf.add(0,  book5) ;
//		shelf.remove(4) ;
//		shelf.remove(book1) ;
		//remove all books with "THE" in the title
//		for(int j = 0 ; j < shelf.size() ; j++)
//		{
//			while(j < shelf.size() && shelf.get(j).getTitle().toLowerCase().contains("the"))
//			{
//				shelf.remove(shelf.get(j)) ;
//			}
//		}
//		ArrayList<Book> creepyBooks = new ArrayList<Book>() ;
//		for(Book b: shelf)
//		{
//			if(b.getAuthor().getName().equals("Anthony Burgess"))
//			{
//				creepyBooks.add(b) ;
//				b.setOnFire() ;
//				b.printInfo() ;
//			}
//		}
//		for(int i = 0 ; i < shelf.size() ; i++)
//		{
////			System.out.println(shelf.get(i)) ;
//			shelf.get(i).printInfo() ;
//		}
//		System.out.println("") ;
//		System.out.println("The length (size) of the shelf is " + shelf.size() + " books.") ;
//		System.out.println("") ;
//		if(shelf.contains(book2))
//		{
//			System.out.println(book2.getTitle() + " is book # " + (shelf.indexOf(book2)+1) + " on the shelf") ;
//		}
	}
}