package Introduction;
import java.util.Scanner ;
public class HelloWorld {

	static int numberOfMessages = 0 ;
	static Scanner input = new Scanner(System.in) ;
	static String username ;
	static boolean running ;
	/**
	 */
	
	public static void main(String[] args) {
		print("Hello World") ;//println is OVERLOADED
		//									- same method with different arguments
		//Scanner user_input = new Scanner( System.in ) ;
		//print("Please type your name") ;
		//String name = user_input.next( );
		//print("According to you, your name is " + name + ".") ;
		/*String message = "This is a message assigned to message" ;
		double number = 1.0/2.0 ;
		int number1 = 1 ;
		int number2 = 4 ;
		int count = 1 ;
		String theWord = "time" ;
		print(message) ;
		print(number) ;
		print(number1) ;
		print(number2) ;
		print(1.1+1.3) ;
		print(9.0/4.0) ;
		while (number1 <= 10){
			print(number1) ;
			number1++ ;
		}
		while (count <= 60){
			if(count != 1){
				theWord = "times" ;
			}
			print("The numbers are " + number1 + " and " 
			+ number2 + ". Their sum is " + (number1+number2) + ". This message has been displayed " 
			+ count + " " + theWord + ".") ;
			count++ ;
		}*/
//		print("What is your favorite type of animal?") ;
//		String favoriteAnimal = waitForInput() ;
//		print("Wow, that sure sucks, " + favoriteAnimal + "s are awful!") ;
		promptName() ;
		endlessConversation() ;
	}
	public static void endlessConversation() {
		running = true ;
		while(running){
			print("What school do you go to?") ;
			String school = waitForInputProvideChoices() ;
			if(school.equals("S")){
				talkAbouBread() ;
			}
			else{
				if(school.equals("Q")){
					return ;
				}
				else{
					print("Oh, so you go to that crappy place " + school + "?") ;
				}
			}
			//print("Oh, so you go to that crappy place " + waitForInput() + "?") ;
		}
	}
	public static void talkAbouBread(){
		print("I hate bread") ;
	}
	public static void print(double d) {
		numberOfMessages++ ;
		System.out.println(/*numberOfMessages + " message " + */d) ;
		
	}
	public static void print(int i) {
		numberOfMessages++ ;
		System.out.println(/*numberOfMessages + " message " + */i) ;
		
	}
	public static void print(String string){
		numberOfMessages++ ;
		System.out.println(/*numberOfMessages + " message " + */string) ;
	}
	public static String waitForInput(){
		String entry = input.nextLine() ;
		return entry;
		
	}
	public static String waitForInputProvideChoices(){
		print("You may type the following commands:\n" +
				"\"Q\" - to quit\n" +
				"\"S\" - start over") ;
		String entry = input.nextLine() ;
		return entry;
		
	}
	public static void promptName(){
		print("Please enter your name:") ;
		username = waitForInput() ;
		print("Okay, I will call you " + username + ".") ;
	}

}
