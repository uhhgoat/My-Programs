import java.util.Arrays ;
public class SortAlgorithms
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] test = {4, 5, 2, 1, 2, 2, 2, 2, 3, 4, 3, 4, 5, 6, 6, 5, 7, 0, 0, 9, 98, 777, 1000000} ;
//		int[] test = {4, 5, 2, 1, 2, 2, 2, 3} ;
//		selectionSort(test) ;
//		bubbleSort(test) ;
		
//		System.out.println("10! is " + factorial(10)) ;
//		System.out.println(Arrays.toString(test)) ;
//		System.out.println(Arrays.toString(mergeSort(test))) ;
		
//		System.out.println(Arrays.toString(quickSort(test))) ;
		quickSort(test, 0, test.length-1) ;
	}
	
	public static void quickSort(int[] array, int start, int end)
	{
		
		if(start == end)
			return ;
		System.out.println(Arrays.toString(array)) ;
		int pivotIndex = (end+start)/2 ;
		int pivot = array[pivotIndex] ;
		System.out.println( start + " " + end) ;
		System.out.println("pivotIndex is " + pivotIndex) ;
		System.out.println("pivot is " + pivot) ;
		int i = start ;
		int j = end ;
		while(i <= j)
		{
			if(array[i] >= pivot && array[j] <= pivot)
			{
				System.out.println("Swapping " + array[i] + " and " + array[j]) ;
				swap(array, i, j) ;
				i++ ;
				j-- ;
			}
			if(array[i] <= pivot)
			{
				i++ ;
			}
			if(array[j] > pivot)
			{
				j-- ;
			}
		}
		System.out.println(Arrays.toString(array)) ;
		quickSort(array, start, j) ;
		quickSort(array, j+1, end) ;
	}
	
	public static int factorial(int n) {
		if(n < 2)
			return 1 ;
		return n*factorial(n-1) ; //RECURSION
	}

	private static void swap(int[] array, int a, int b)
	{
		int placeHolder = array[a] ;
		array[a] = array[b] ;
		array[b] = placeHolder ;
	}
	
	public static void selectionSort(int[] array)
	{
		for(int i = 0 ; i < array.length-1 ; i++)//represents yellow
		{
			int indexOfTempMin = i ;//represents red
			for(int j = i ; j < array.length-2 ; j++)//represents blue
			{
				if(array[j] < array[indexOfTempMin])
				{
					indexOfTempMin = j ;
					System.out.println("index = " + i + " and indexOfTempMin " + j) ;
				}
			}
			System.out.println(Arrays.toString(array)) ;
			swap(array, i, indexOfTempMin) ;
			System.out.println("After Swap: " + Arrays.toString(array)) ;
		}
	}
	
	public static void bubbleSort(int[] array)
	{
		for(int i = 1 ; i < array.length-1 ; i++)
		{
			for(int j = 0 ; j < array.length-i ; j++)
			{
				if(array[j+1] < array[j])
				{
					swap(array, j, j+1) ;
				}
			}
			
		}
		System.out.println(Arrays.toString(array)) ;
	}
	
	public static void insertionSort(int[] array)
	{
//		for(int i = 1 ; i < array.length ; i++)
//		{
//			for(int j = i ; j >= 0 ; j--)
//			{
//				if(array[j] <= array[i])
//				{
//					
//				}
//			}
//		}
	}
	
	public static int[] merge(int[] a, int[] b)
	{
		int i = 0 ;
		int j = 0 ;
		int l = 0 ;
		int[] result = new int[a.length + b.length] ;
		while(i < a.length && j < b.length)
		{
			if(a[i] < b[j])
			{
				result[l] = a[i] ;
				i++ ;
			}
			else
			{
				result[l] = b[j] ;
				j++ ;
			}
			l++ ;
		}
		while(i < a.length)
		{
			result[l] = a[i] ;
			l++ ;
			i++ ;
		}
		while(j < b.length)
		{
			result[l] = b[j] ;
			l++ ;
			j++ ;
		}
		return result ;
	}
	
	public static int[] mergeSort(int[] array)
	{
		if(array.length <= 1)
		{
			return array ;
		}
		int half = (array.length/2) ;
		int[] half1 = new int[half] ;
		int[] half2 = new int[array.length-half] ;
		for(int i = 0 ; i < half1.length ; i++)
		{
			half1[i] = array[i] ;
		}
		for(int j = 0 ; j < half2.length ; j++)
		{
			half2[j] = array[j+half] ;
		}
		System.out.println(Arrays.toString(half1) + " and " + Arrays.toString(half2)) ;
		return merge(mergeSort(half1), mergeSort(half2)) ;
		
	}
}
