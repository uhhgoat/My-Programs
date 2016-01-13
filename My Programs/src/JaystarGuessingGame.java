import java.util.Scanner;
public class JaystarGuessingGame {
	public static final int CONST_TRIES = 5;
	public static int guess = 0;
	public static Scanner userInput = new Scanner(System.in);
	
	public static int[][] playerStats = new int[100][3];//level attempted, tries, target
    public static int[][] display;
	
	public static void main(String[] args)
	{
		guessGame(1, 0, 0, 0, 0);
	}
	
	public static void guessGame(int currentGame, int level, int target, int tries, int tryAgain)
	{
		tries = CONST_TRIES; 
		
		while (level < 1 || level > 4)
		{
			System.out.println("\nThe Guessing Game!\n");
			System.out.println("1. Beginner Level: Between 1 and 10");
			System.out.println("2. Intermediate Level: Between 1 and 100");
			System.out.println("3. Improbable Level: Between 1 and 1,000");
			System.out.println("4. Impossible Level: Between 1 and 10,000\n");
			System.out.println("You will have " + tries + " tries. Enter a level to play:\n"); 

			level = userInput.nextInt();
		}
        
		target = (int)(Math.random() * Math.pow(10, level)) + 1;
		System.out.println("\nGame #" + currentGame);
		System.out.println("Level " + level + ":\n");
		
		System.out.println("FOR TESTING PURPOSES: " + target + "\n");
		
		guess = 0;
		while (guess != target)
		{
			guess = userInput.nextInt();
			tries--;
			
			if(guess < target)
			{
				System.out.println("Too low man, " + tries + " tries remaining");
			}
			if(guess > target)
			{
				System.out.println("Too high man, " + tries + " tries remaining");
			}
			if(guess == target)
			{
				System.out.println("\nYou win! Wanna try again? Indicate your choice by typing its number\n"
                    + "1. Play again\n"
                    + "2. Exit program\n");
				tryAgain = 0;
				
				playerStats[currentGame - 1][0] = level;
				playerStats[currentGame - 1][1] = CONST_TRIES - tries;
                playerStats[currentGame - 1][2] = target;
				
				while(tryAgain < 1 || tryAgain > 2)
				{
					tryAgain = userInput.nextInt();
					if(tryAgain == 1)
					{
						currentGame++;
						if(level < 4)
                	   	level++;
						guess = 0;
						//target = 0;
                        //tries = 5;
						guessGame(currentGame, 0, 0, 0, 0);
					}
					else
					{
                	   if(tryAgain == 2)
                 	    {
                            display = new int[currentGame][3];
                
                            //SCOREBOARD
                            System.out.println("\n===========\nSCOREBOARD\n===========");
                
                            for(int i = 0; i < display.length; i++) 
                            {
                                display[i][0] = i + 1;
                                for(int tmpIterator : playerStats[i])
                                {
                                    display[i][0] = playerStats[i][0];
                                    display[i][1] = playerStats[i][1];
                                    display[i][2] = playerStats[i][2];
                                }
                                if(display[i][1] != CONST_TRIES)
                                {
                                    System.out.println("Game# " + (i + 1) + "\nLevel " + display[i][0] + " took you " + display[i][1] 
                                        + " tries to guess the number " + display[i][2] + "\n");
                                }
                                else
                                {
                                    System.out.println("Game# " + (i + 1) + "\nLevel " + display[i][0] + ": You failed to guess the number " + display[i][2] + "\n");
                                }
                            }
                            
                                System.exit(0);
                                
                 	    }
                 	    else
                  	   {
                  	       System.out.println("Enter a valid input you doof\n");
                  	   }
					}
				}
			}
			
			if(tries == 0)
			{
				System.out.println("\nYou ran out of tries. You Lose! Wanna try again? Indicate your choice by typing its number\n"
                    + "1. Play again\n"
                    + "2. Exit program\n");
                
				playerStats[currentGame - 1][0] = level;
				playerStats[currentGame - 1][1] = CONST_TRIES - tries;
                playerStats[currentGame - 1][2] = target;
                
                tryAgain = 0;
				tries = 5;
                
				while(tryAgain < 1 || tryAgain > 2)
				{
					tryAgain = userInput.nextInt();
					if(tryAgain == 1)
					{
						currentGame++;
						guess = 0;
						target = 0;
						guessGame(currentGame, 0, 0, 0, 0);
					}
					else
					{
                	   if(tryAgain == 2)
                 	    {
                            display = new int[currentGame][3];
                
                            //SCOREBOARD
                            System.out.println("\n===========\nSCOREBOARD\n===========");
                
                            for(int i = 0; i < display.length; i++) 
                            {
                                display[i][0] = i + 1;
                                for(int tmpIterator : playerStats[i])
                                {
                                    display[i][0] = playerStats[i][0];
                                    display[i][1] = playerStats[i][1];
                                    display[i][2] = playerStats[i][2];
                                }
                                if(display[i][1] != CONST_TRIES)
                                {
                                    System.out.println("Game# " + (i + 1) + "\nLevel " + display[i][0] + " took you " + display[i][1] 
                                        + " tries to guess the number " + display[i][2] + "\n");
                                }
                                else
                                {
                                    System.out.println("Game# " + (i + 1) + "\nLevel " + display[i][0] + ": You failed to guess the number " + display[i][2] + "\n");
                                }
                            }
                            
                                System.exit(0);
                                
                 	    }
                 	    else
                  	   {
                  	       System.out.println("Enter a valid input you doof\n");
                  	   }  
					}
				}
			}	
		}
	}
}
