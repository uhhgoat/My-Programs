
public class CardsStuff {

	
	static int numEqualCards = 0 ;
	static long numTimesShuffled = 0 ;
	static boolean decksEqual = false ;
	public static void main(String[] args) {


	

		String[] deck = makeCards() ;
		String[] deck2 = makeCards() ;

		checkDecksForEquivalence(deck, deck2) ;
	}

	private static void checkDecksForEquivalence(String[] deck, String[] deck2) {
		while(decksEqual == false) {
			shuffle(deck) ;
			shuffle(deck2) ;
			numTimesShuffled++ ;
			numEqualCards = 0 ;
			System.out.println(numTimesShuffled) ;
			for(int f = 0; f < 52 ; f++) {
				if(deck[f].equals(deck2[f]))
				{
					numEqualCards++ ;
				}
				if(numEqualCards == 52) {
					
					decksEqual = true ;
					break ;
				}
			}
		}
		
	}

	

	private static void shuffle(String[] deck) {
		for(int w = 0 ; w < deck.length ; w++) {
			int swapCard = (int)(Math.random()*deck.length) ;
			swap(deck, w, swapCard) ;
		}
		
	}

	private static void swap(String[] deck, int x, int y) {
		String placeHolder = deck[x] ;
		deck[x] = deck[y] ;
		deck[y] = placeHolder ;
		
	}

	private static String[] makeCards() {
		String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"} ;
		String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"} ;
		String[] cards = new String[52] ;
		int n = 0 ;
		for(int a = 0 ; a < suits.length ; a++){
			String suit = suits[a] ;
			for(int b = 0 ; b < ranks.length ; b++) {
				String rank = ranks[b] ;
				cards[n] = rank + " of " + suit ;
				n++ ;
			}
		}

		return cards ;
	}

}
