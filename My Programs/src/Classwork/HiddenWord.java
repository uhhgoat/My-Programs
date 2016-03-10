package Classwork;

public class HiddenWord {

	/**
	 * @param args
	 */
	private String word ;
	public HiddenWord(String word)
	{
		this.word = word.toUpperCase() ;
	}
	public String getHint(String guess)
	{
		if(guess.length() > word.length())
			return "The word is " + word.length() + " letter(s) long, you guessed too many." ;
		if(guess.length() < word.length())
			return "The word is " + word.length() + " letter(s) long, you guessed too few." ;
		guess = guess.toUpperCase() ;
		String temp = "" ;
		boolean inWord = false ;
		for(int i = 0 ; i < guess.length() ; i++)
		{
			if(guess.charAt(i) == word.charAt(i))
			{
				temp += guess.charAt(i) ;
				continue ;
			}
			else
			{
				for(int j = 0 ; j < guess.length() ; j++)
				{
					if(guess.charAt(i) == word.charAt(j))
					{
						inWord = true ;
					}
					
				}
				if(inWord)
				{
					temp += "+" ;
					inWord = false ;
				}
				else
				{
					temp += "*" ;
				}
			}
		}
		return temp ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiddenWord puzzle = new HiddenWord("HARPS") ;
		
		
		System.out.println(puzzle.getHint("A")) ;
		System.out.println(puzzle.getHint("HELLOO")) ;
		System.out.println(puzzle.getHint("HEART")) ;
		System.out.println(puzzle.getHint("HARMS")) ;
		System.out.println(puzzle.getHint("haRps")) ;
	}

}
