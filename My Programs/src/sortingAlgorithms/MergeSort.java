package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] array = {6, 0, 7, 4, 3, 5, 2, 8, 9, 1} ;
		for(int i: array)
			System.out.print(i + " ") ;
		array = mergeSort(array) ;
		System.out.println("") ;
		for(int i: array)
			System.out.print(i + " ") ;
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
			return array ;
		int[] half1 = new int[array.length/2] ;
		int[] half2 = new int[array.length-half1.length] ;
		for(int i = 0 ; i < half1.length ; i++)
			half1[i] = array[i] ;
		for(int j = 0 ; j < half2.length ; j++)
			half2[j] = array[j+half1.length] ;
		return merge(mergeSort(half1), mergeSort(half2)) ;
		
	}

}
