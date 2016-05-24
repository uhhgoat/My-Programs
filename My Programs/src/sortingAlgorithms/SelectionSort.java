package sortingAlgorithms;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {6, 0, 7, 4, 3, 5, 2, 8, 9, 1} ;
		for(int i: array)
			System.out.print(i + " ") ;
		array = selectionSort(array) ;
		System.out.println("") ;
		for(int i: array)
			System.out.print(i + " ") ;
	}
	public static int[] selectionSort(int[] array)
	{
		int idx = 0 ;
		int temp ;
		for(int i = 1 ; i < array.length ; i++)
		{
			
			for(int j = i ; j < array.length ; j++)
			{
				if(array[j] < array[i])
				{
					idx = j ;
					
				}
			}
			temp = array[idx] ;
			array[idx] = array[i] ;
			array[i] = temp ;
		}
		return array ;
	}

}
