import java.util.Scanner ;
public class DungeonAdventure {
	static String username ;
	static int hitPoints = 100 ;
	static String phrase = "Your HP is now at " ;
	static Scanner input = new Scanner(System.in) ;
	static String choice = "" ;
	static  String introText = "You find yourself at home in bed in the morning. Would you like to GETDRESSED or SHOWER?" ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		promptUserName() ;
		System.out.println(phrase + hitPoints) ;
		introduction() ;
		
	}
	public static String waitForInput(){
		String entry = input.nextLine() ;
		return entry;
		
	}
	public static void checkHP(){
		if(hitPoints <= 0){
			System.out.println("You died, would you like to start over? YES or NO?") ;
			choice = waitForInput() ;
			if(choice.equals("YES")){
				hitPoints = 100 ;
				promptUserName() ;
				System.out.println(phrase + hitPoints) ;
				introduction() ;
			}
			else{
				if(choice.equals("NO")){
					System.out.println("Okay, goodbye loser") ;
					return ;
				}
				else {
					System.out.println("That is not an option, please try again") ;
					checkHP() ;
				}
			}
		}
		
	}
	public static void promptUserName(){
		System.out.println("Please enter your desired username:") ;
		username = waitForInput() ;
		System.out.println("Okay, " + username + ", your story begins. Please type everything is CAPS.") ;
	}
	public static String event(String eventText, String choiceText1, String choiceText2, int lostHP, String method1, String method2, String currentMethod ) {
		System.out.println(eventText) ;
		hitPoints -= lostHP ;
		checkHP() ;
		choice = waitForInput() ;
		if(choice.equals(choiceText1)) {
			return method1 ;
		}
		else {
			if(choice.equals(choiceText2)) {
				return method2 ;
			}
			else {
				System.out.println("That is not an option, please try again") ; 
				return currentMethod ;
			}
		}
		
	}
	public static void introduction(){
		event(introText, "GETDRESSED", "SHOWER", 0, "getDressed() ;", "shower() ;", "introduction() ;") ;
	}
	public static void shower() {
		System.out.println("SHOWERRRRR") ;
	}
	/*public static void introduction(){
		
		System.out.println("You find yourself at home in bed in the morning. Would you like to GETDRESSED or SHOWER?") ;
		choice = waitForInput() ;
		if(choice.equals("GETDRESSED")){
			getDressed() ;
		}
		else{
			if(choice.equals("SHOWER")){
				shower() ;
			}
			else{
				System.out.println("That is not an option, please try again") ;
				introduction() ;
			}
		}
			
	}
	public static void shower(){
		System.out.println("You get in the shower and shower slowly, but all of a sudden you hear a bang " +
		"from outside. You must quickly get out and GETDRESSED.") ;
		choice = waitForInput() ;
		if(choice.equals("GETDRESSED")){
			getDressed() ;
		}
		else{
			System.out.println("That is not an option, please try again") ;
			shower() ;
		}
	}
	public static void getDressed(){
		System.out.println("You get dressed and there is banging at the door. Now you must either GODOWNSTAIRS or LOOKOUTTHEWINDOW.") ;
		choice = waitForInput() ;
		if(choice.equals("LOOKOUTTHEWINDOW")){
			lookOutTheWindow() ;
		}
		else{
			if(choice.equals("GODOWNSTAIRS")){
				goDownStairs() ;
			}
			else{
				System.out.println("That is not an option, please try again") ;
				getDressed() ;
			}
		}
	}
	public static void lookOutTheWindow(){
		System.out.println("You look out the window, you see a man banging at the front door " +
		"repeatedly. You can either GODOWNSTAIRS or JUMPONTHEMAN (lose 10 hp).") ;
		choice = waitForInput() ;
		if(choice.equals("GODOWNSTAIRS")){
			goDownStairs() ;
		}
		else{
			if(choice.equals("JUMPONTHEMAN")){
				jumpOnTheMan() ;
			}
			else{
				System.out.println("That is not an option, please try again") ;
				lookOutTheWindow() ;
			}
		}
	}
	public static void goDownStairs(){
		System.out.println("You go downstairs and the door gets kicked open. A policeman steps in and yells \"freeze!\"" +
		"Now you can either SURRENDER or ATTACKHIM.") ;
		choice = waitForInput() ;
		if(choice.equals("SURRENDER")){
			surrender() ;
		}
		else{
			if(choice.equals("ATTACKHIM")){
				attackHim() ;
			}
			else{
				goDownStairs() ;
			}
		}
	}
	public static void jumpOnTheMan(){
		hitPoints -= 10 ;
		System.out.println(phrase + hitPoints) ;
		System.out.println("You jump down, it hurt, but you get up and the man is uder you." +
		" He was wearing a police unifom.... You can either RUN or GOINSIDE.") ;
	}
	public static void surrender(){
		System.out.println("As you throw your arms up and say \"I surrender!\" The man pulls out a gun " +
				"and says, \"Sorry, I\'m not a real cop!\"\n" +
				"He pulls out  his gun, and shoots you. (lose all HP)") ;
				hitPoints = 0 ;
	}
	public static void attackHim(){
		System.out.println("") ;
	}*/
}
