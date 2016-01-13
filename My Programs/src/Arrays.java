public class Arrays {

	/**
	 * @param args
	 */
	static int numEqualCards = 0 ;
	static long numTimesShuffled = 0 ;
	static boolean decksEqual = false ;
	public static void main(String[] args) {
		/*int[] piDigits = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3} ;
		int[] eDigits = new int[4] ;
		eDigits[0] = 2 ;
		eDigits[1] = 7 ;
		eDigits[2] = 1 ;
		eDigits[3] = 8 ;
		
		System.out.println("The number of pi digits we have is " + piDigits.length) ;
		System.out.println("The number of e digits we have is " + eDigits.length) ;
		System.out.println(piDigits) ;
		printArrayContent(piDigits) ;
		*/
//		long startTime = System.currentTimeMillis();
//		int[] newArray = generateArray(1000) ;
//		printArrayContent(newArray) ;
//		long endTime = System.currentTimeMillis();
//		System.out.println("The Method took " + (endTime - startTime) + " milliseconds.") ;
//		String[] deck = makeCards() ;
//		String[] deck2 = makeCards() ;
//		shuffle(deck) ;
//		shuffle(deck2) ;
//		printArrayContent(deck) ;
//		printArrayContent(deck2) ;
		
//		System.out.println(numEqualCards) ;
//		checkDecksForEquivalence(deck, deck2) ;
		
		countPrimes(100) ;
		
	}

	private static void countPrimes(int max) {
		boolean[] theNumbers = new boolean[max+1] ;
		for(int index = 2; index < theNumbers.length ; index++){
			theNumbers[index] = true ;
		}
		for(int b = 2 ; b < theNumbers.length ; b++) {
			if(theNumbers[b]) {
				for(int c = b+b ; c < theNumbers.length ; c += b) { // c is the index of every multiple of b
					theNumbers[c] = false ;
				}
			}
		}
		String statement = "" ;
		int count = 0 ;
		for(int d = 0 ; d < theNumbers.length ; d++) {
			if(theNumbers[d]) {
				count++ ;
				statement += " " + d + "," ;
				
			}
		}
		statement += "\nThere are " + count + " primes between 1 and " + max + "." ;
		System.out.println(statement) ;
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
//		for(int f = 0 ; f < 52 ; f++) {
//			System.out.println(cards[f]) ;
//		}
		//printArrayContent(cards) ;
		return cards ;
	}

	private static int[] generateArray(int arrayLength) {
		int[] array = new int[arrayLength] ;
		for(int c = 0 ; c < arrayLength ; c++) {
			array[c] = c + 1 ;
		}
		return array ;
	}

	public static void printArrayContent(int[] array) {
		String arrayContent = "[" ;
		for(int i = 0 ; i < array.length ; i++) {
			arrayContent = arrayContent + array[i] ;
			if(i < array.length-1)
				arrayContent = arrayContent + ", " ;
		}
		arrayContent = arrayContent + "]" ;
		System.out.println(arrayContent) ;
	}
	public static void printArrayContent(String[] array) {
		String arrayContent = "[" ;
		for(int i = 0 ; i < array.length ; i++) {
			arrayContent = arrayContent + array[i] ;
			if(i < array.length-1)
				arrayContent = arrayContent + ", " ;
		}
		arrayContent = arrayContent + "]" ;
		System.out.println(arrayContent) ;
	}
	public static void printArrayContent(boolean[] array) {
		String arrayContent = "[" ;
		for(int i = 0 ; i < array.length ; i++) {
			arrayContent = arrayContent + array[i] ;
			if(i < array.length-1)
				arrayContent = arrayContent + ", " ;
		}
		arrayContent = arrayContent + "]" ;
		System.out.println(arrayContent) ;
	}

}
