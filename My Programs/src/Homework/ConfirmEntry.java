package Homework;

import java.util.Scanner ;
public class ConfirmEntry {
	
	static Scanner input = new Scanner(System.in) ;
	static String favColor ;
	static String entry ;
	public static void main(String[] args) {
		question() ;
		
	}
	public static void question(){
		System.out.println("What is your favorite color?") ;
		favColor = waitForInput() ;
		genericQuestion(2, "Oh, is " + favColor + " your favorite color?") ;
	}
	public static void question2(){
		System.out.println("Oh, is " + favColor + " your favorite color?") ;
		entry = waitForInput() ;
		if(entry.equals("yes")){
			question3() ;
		}
		else{
			if(entry.equals("no")){
				question() ;
			}
			else{
				question2() ;
			}
		}
	}
	public static void question3(){
		System.out.println("Are you sure that " + favColor + " is your favorite color?") ;
		entry = waitForInput() ;
		if(entry.equals("yes")){
			question3() ;
		}
		else{
			if(entry.equals("no")){
				question() ;
			}
			else{
				question3() ;
			}
		}
	}
	
	public static void genericQuestion(int nextQuestion, String theQuestion){
		System.out.println(theQuestion) ;
		entry = waitForInput() ;
		if(entry.equals("yes")){
			question3() ;
		}
		else{
			if(entry.equals("no")){
				genquestion() ;
			}
			else{
				if(nextQuestion==2)question2() ;
				else question3() ;
				
			}
		}
	}
	
	public static String waitForInput(){
		entry = input.nextLine() ;
		return entry ;
		
	}
}
