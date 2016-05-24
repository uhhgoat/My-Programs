package sortingAlgorithms;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {6, 0, 7, 4, 3, 5, 2, 8, 9, 1} ;
		for(int i: array)
			System.out.print(i + " ") ;
		array = insertionSort(array) ;
		System.out.println("") ;
		for(int i: array)
			System.out.print(i + " ") ;
	}
	public static int[] insertionSort(int[] array)
	{
		
		for(int i = 1 ; i < array.length ; i++)
		{
			int temp = array[i] ;
			int j ;
			for(j = i-1 ; j >= 0 && temp < array[j] ; j--)
			{
				array[j+1] = array[j] ;
			}
			array[j+1] = temp ;
		}
		return array ;
	}

}
