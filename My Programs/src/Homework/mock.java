package Homework ;

import java.util.Random ;

public class mock {

	public String getGreeting()
	{
		return "So you like Dark Souls, do you? I like to alk about Dark Souls, it's one of my favorite games!";
	}
	
	
	public static String getRandomNoneResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "Answer please." ;
		if(rand == 2)
			str = "Come on, talk! Dark Souls is a fun topic!" ;
		if(rand == 3)
			str = "If you won't say anything about Dark Souls, talk about something else!" ;
		return str ;
	}
	public static String getDeathResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "Death makes you hollow, thats when you aren't human anymore." ;
		if(rand == 2)
			str = "At least you only die in the game." ;
		if(rand == 3)
			str = "You lose all you souls when you die!" ;
		return str ;
	}
	public static String getDS2Response()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "Many people complain about Dark Souls 2, but I think it's as good as the first." ;
		if(rand == 2)
			str = "The second Dark Souls was different from the first, but still great!" ;
		if(rand == 3)
			str = "I like DS2 and DS1, but I just can't wait for the third one coming out next year!" ;
		return str ;
	}
	public static String getFriendlyPhantomResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "I love the Heirs of the sun covenant, so jolly when the phantoms are golden." ;
		if(rand == 2)
			str = "Friendly phantoms are very useful." ;
		if(rand == 3)
			str = "You have to be careful that it's not a red phantom disguised with the White Ring, those are mean." ;
		return str ;
	}
	public static String getMagicResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "My favorite use of magic is Pyromancy, fire is too fun!" ;
		if(rand == 2)
			str = "So many players who fight PvP complain that magic is overpowered..." ;
		if(rand == 3)
			str = "Miracles are especially useful in coop to help your friends out." ;
		return str ;
	}
	public static String getMcDuffResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "I ought to fetch a new ember..." ;
		if(rand == 2)
			str = "Flame, dear flame..." ;
		if(rand == 3)
			str = "Hand that ember to me. Right now, you imbecile." ;
		return str ;
	}
	public static String getNPCResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "A few NPCs are useless for certain classes." ;
		if(rand == 2)
			str = "NPC merchants overprice their stuff, then agian, they do have a monopoly on products!" ;
		if(rand == 3)
			str = "It's odd that you buy stuff with souls, that you also need to level up..." ;
		return str ;
	}
	public static String getBossResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "The Ancient Dragon boss is the hardest one by far... It took me hundreds of tries to kill him!" ;
		if(rand == 2)
			str = "Bosses can be hard, but they are very rewarding." ;
		if(rand == 3)
			str = "Luckily there are some crazy bosses that are optional, so you don't have to fight them right away." ;
		return str ;
	}
	public static String getClassResponse()
	{
		String str = "" ;
		int rand = (int)(Math.random()*3 + 1) ;
		if(rand == 1)
			str = "I like to choose classes and name my characters after movie characters." ;
		if(rand == 2)
			str = "A useful tip is to start with the explorer class, since his robes gain you extra souls per kill!." ;
		if(rand == 3)
			str = "My favorite character build is a light armor, fast rogue who can parry and counter quickly." ;
		return str ;
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = getRandomNoneResponse() ;
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "That's too bad...";
		}
		else if (findKeyword(statement, "Traps") >= 0
				|| findKeyword(statement, "Obstacles") >= 0)
		{
			response = "Those are tough aren't they?";
		}
		else if (findKeyword(statement, "white phantom") >= 0
				|| findKeyword(statement, "gold phantom") >= 0
				|| findKeyword(statement, "white") >= 0
				|| findKeyword(statement, "gold") >= 0)
		{
			response = getFriendlyPhantomResponse() ;
		}
		else if (findKeyword(statement, "Boss") >= 0
				|| findKeyword(statement, "Bosses") >= 0
				|| findKeyword(statement, "Dragon") >= 0
				|| findKeyword(statement, "Dragons") >= 0)
		{
			response = getBossResponse() ;
		}
		
		else if (findKeyword(statement, "Death") >= 0
				|| findKeyword(statement, "Dead") >= 0
				|| findKeyword(statement, "Die") >= 0)
		{
			response = getDeathResponse() ;
		}
		else if (findKeyword(statement, "2") >= 0
				|| findKeyword(statement, "Two") >= 0
				|| findKeyword(statement, "Scholar of the First Sin") >= 0
				|| findKeyword(statement, "Scholar") >= 0)
		{
			response = getDS2Response() ;
		}
		else if (findKeyword(statement, "ring", 0) >= 0)
		{
			response = "Rings are very useful, but there are too many to discuss!" ;
		}
		else if (findKeyword(statement, "Fire") >= 0
				|| findKeyword(statement, "Magic") >= 0
				|| findKeyword(statement, "Miracle") >= 0
				|| findKeyword(statement, "Pyromancy") >= 0
				|| findKeyword(statement, "Sorcery") >= 0
				|| findKeyword(statement, "Lightning") >= 0)
		{
			response = getMagicResponse() ;
		}
		else if (findKeyword(statement, "Flame") >= 0
				|| findKeyword(statement, "Ember") >= 0
				|| findKeyword(statement, "Dull Ember") >= 0)
		{
			response = getMcDuffResponse() ;
		}
		else if (findKeyword(statement, "NPC") >= 0
				|| findKeyword(statement, "Merchant") >= 0
				|| findKeyword(statement, "Companion") >= 0)
		{
			response = getNPCResponse() ;
		}
		else if (findKeyword(statement, "Class") >= 0
				|| findKeyword(statement, "Character") >= 0
				|| findKeyword(statement, "Sorcerer") >= 0
				|| findKeyword(statement, "Cleric") >= 0
				|| findKeyword(statement, "Pyromancer") >= 0
				|| findKeyword(statement, "Swordsman") >= 0
				|| findKeyword(statement, "Bandit") >= 0
				|| findKeyword(statement, "Knight") >= 0
				|| findKeyword(statement, "Explorer") >= 0
				|| findKeyword(statement, "Thief") >= 0)
		{
			response = getClassResponse() ;
		}

		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

				else
				{
					response = RandomResponses.getRandomSoulsResponse();
				}
		return response;
	}
	
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		if(restOfStatement == "kill myself")
			return "I know the feeling, but just relax, and get help from a friendly white or gold phantom!" ;
		
		return "I want that too sometimes...";
	}
	
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Many people want " + restOfStatement + ", but you can't always have " + restOfStatement ;
	}
	
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		//  Refinement--make sure the goal isn't part of a word 
		while (psn >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			
			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
			
		}
		
		return -1;
	}
	
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	
	
}
