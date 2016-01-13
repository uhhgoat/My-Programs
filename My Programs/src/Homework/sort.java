package Homework;

public class sort {

	
	
	public static void main(String[] args) {
//		int[] shuffled = {2, 5, 6, 3, 7, 8, 3, 1, 9, 10, 764 } ;
//		int[] newArray = sort(shuffled) ;
//		printArrayContent(shuffled) ;
//		printArrayContent(newArray) ;
	}
	public static int[] sort(int[] shuffled) {
//		int[] temp = new int[shuffled.length] ;
//		boolean order = false ;
//		int index = 0 ;
//		int indexes = 0 ;
//		while(order = false) {
//			for(int i = 0 ; i < shuffled.length ; i++) {
//				if(shuffled[index] <= shuffled[i]) {
//					temp[index] = shuffled[index] ;
//					indexes++ ;
//					if(indexes == shuffled.length) {
//						index++ ;
//					}
//					if(index == shuffled.length) {
//						order = true ;
//					}
//				}
//				else {
//					if(shuffled[index] > shuffled[i]) {
//						temp[index] = shuffled[i] ;
//					}
//				}
//			}
//		}
//		return temp ;
		 java.util.Arrays.sort(shuffled) ;
         return shuffled ;
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
}
