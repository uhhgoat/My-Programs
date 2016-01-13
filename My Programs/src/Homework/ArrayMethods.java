package Homework ;

import java.util.Arrays ;


public class ArrayMethods {

    public static void main(String[] args) {
    
     /**
      * IMPORTANT NOTE: 
      * This homework assignment will be weighted 4x.
      * DO NOT ASSUME my tests are perfect! If you have code that you think should work, 
      * but you keep failing the tests PLEASE bring it to my attention so that I can fix the tests
      * DO NOT spend hours and hours trying to fix perfect code just because my test
      * says that it isn't perfect!
      * */
//    	TEST FOR isSorted (should work but fails test)
//    	int[] hello = {3, 4, 5, 6, 3, 7, 8, 5, 0, 9 } ;
//    	int[] hello2 = {9, 9, 9, 9, 5, 4, 3, 2, 2} ;
//    	boolean what = isSorted(hello2) ;
//    	if(what == true)
//    		System.out.println("TRUE") ;
//    	else
//    		System.out.println("FALSE") ;
    	
//    	TEST FOR getStats
//    	double[] hello = {1.1, 2.2, 3.3 } ;
//    	double[] hello2 = getStats(hello) ;
//    	for(double num : hello2)
//    		System.out.println(num) ;
//    	int[] hello = {1, 2, 3, 4, 5} ;
//    	cycleThrough(hello, 3) ;
    	int[] hello = generateDistinctItemsList(4) ;
    	for(int num : hello)
    		System.out.println(num) ;
    }
    
    public static int searchUnsorted(int[] arrayToSearch, int key){
        /**
         * this method take an unsorted int array (arrayToSearch) and returns an 
         * int corresponding to the index of a key, if it is in the array
         * if the key is not in the array, this method returns -1
         * */
        	for(int i = 0 ; i < arrayToSearch.length ; i++) {
        		if(arrayToSearch[i] == key)
        			return i ;
        	}
        	return -1 ;
        }
        
        public static int searchSorted(int[] sortedArrayToSearch, int key){
        /**
         * this method is exactly like the one above, except the parameter sortedArrayToSearch will
         * always be sorted in DESCENDING order. Again return the index of the key or return -1
         * if the key is not in the array
         * 
         * Note: You should attempt to write a method that is more efficient that searchUnsroted
         * */
        	for(int i = 0 ; i < sortedArrayToSearch.length ; i++) {
        		if(sortedArrayToSearch[i] == key)
        			return i ;
        	}
        	return -1 ;
        }
        
        public static boolean isSorted(int[] array){
            /**
             * This method takes an in array as a parameter and returns 'true' if the array is already sorted in DESCENDING order
             * */
        	Integer[] tempArr = new Integer[array.length] ;
        	for(int i = 0 ; i < array.length ; i++) {
        		tempArr[i] = array[i] ;
        	}
        	java.util.Arrays.sort(tempArr, java.util.Collections.reverseOrder()) ;
        	for(int a = 0 ; a < array.length ; a++) {
        		System.out.println(array[a]) ;
        		System.out.println(tempArr[a]) ;
        		if(array[a] != tempArr[a])
        			return false ;
        	}
            return true ;
        }
        
        
        public static double[] getStats(double[] array){
            /** 
             * This method return a double[] contain a WHOLE BUNCH of stats
             * The double array must keep the following stats about the array parameter:
             * index 0 = the mean
             * index 1 = the max
             * index 2 = the min
             * index 3 = the median
             * index 4 = the number of values greater than or equal to the mean
             * index 5 = the number of values below the mean
             * */
        	java.util.Arrays.sort(array) ;
             double[] stats = new double[6];
//             MEAN CALCULATION [0]
             double total = 0 ;
             for(double num : array)
            	 total += num ;
             double mean = total/array.length ;
             
//             MAX CALCULATION [1]
             double max = array[array.length-1] ;
//             double max = array[0] ;
//             Algorithm if array isn't sorted
//             for(int i = 1 ; i < array.length ; i++) {  
//    	         if(array[i] > max) 
//    	        	 max = array[i] ;
//             }
             
//             MIN CALCULATION [2]
             double min = array[0] ;  
//             Algorithm if array isn't sorted
//             for(int a = 1 ; a < array.length ; a++) {  
//    	         if(array[a] < min) 
//    	        	 min = array[a] ;
//             }
             
//             MEDIAN CALCULATION [3]
             double median ;
             if((array.length%2) == 1)
            	 median = array[(array.length-1)/2] ;
             else
            	 median = (array[array.length/2] + array[(array.length/2)-1])/2 ;
             
//             >= MEAN CALCULATOR [4]
             double numGrEq = 0 ;
             for(int b = 0 ; b < array.length ; b++) {
            	 if(array[b] >= mean)
            		 numGrEq++ ;
             }
             
//             < MEAN CALCULATOR
             double numLess = 0 ;
             for(int c = 0 ; c < array.length ; c++) {
            	 if(array[c] < mean)
            		 numLess++ ;
             }
             
//             DECLARE VALUES FOR stats[]
             stats[0] = mean ;
             stats[1] = max ;
             stats[2] = min ;
             stats[3] = median ;
             stats[4] = numGrEq ;
             stats[5] = numLess ;
             return stats;
        }
        
        public static void reverseOrder(int[] array){
            /**
             * this method reverses the order of the array passed to it.
             * Not that this method does not have a return type. You do not need to copy the array first
             * Furthermore, note that the array is not necessarily in any *particular* order. It may be 
             * in a random order, though you still need to reverse whatever order it is in
             * 
             * */
        	Integer[] tempArr = new Integer[array.length] ;
        	for(int i = 0 ; i < array.length ; i++) {
        		tempArr[i] = array[i] ;
        	}
        	java.util.Collections.reverse(Arrays.asList(tempArr)) ;
        	for(int a = 0 ; a < array.length ; a++) {
        		array[a] = tempArr[a] ;
        	}
        }
        
        public static int countDifferences(int[] array1, int[] array2){
        	 /**Here, you will write an method that returns the number of values in two arrays 
             * that are NOT the same (either in value OR location).
             * Examples:
             * countDifferences({1,2,3},{1,2,3}) returns 0, since these arrays are exactly the same
             * countDifferences({3,2,3,4},{3,2,5,4}) returns 1, since '3','2', and '4' are same value, same location, but the 3 and 5 are different
             * countDifferences({4,4,4,4},{1,2,3,4}) returns 3, since '4' is only at the same index ONE time and three others are not
             * countDifferences({1,2,3},{1,3,2}) returns 2, since '2' and '3' are both present, but different locations
             * 
             * */
        	int numSame = 0 ;
        	for(int i = 0 ; i < array1.length ; i++) {
        		if(array1[i] == array2[i])
        			numSame++ ;
        	}
        	int numDifferences = (array1.length - numSame) ;
             return numDifferences ;
        }
        

        public static int longestConsecutiveSequence(int[] array1){
            /**This method counts the longest consequtive sequence in an array.
             * It does not matter where the sequence begins
             * If there are no consecutive numbers, the method should return '1'
             * 
             * Examples:
             * longestSequence({1,2,3,4,5,8,9}) returns '5', since the sequence '1,2,3,4,5' is 5 integers long 
             * longestSequence({0,9,10,11,4,3,8,9}) returns '3', since '9,10,11' is 3 integers long
             * longestSequence({0,9,8,11,4,3,7,9}) returns '1', since there are no consecutive integers
             * */
        	int longest = 1 ;
        	int sequence = 1 ;
        	for(int i = 0 ; i < array1.length-1 ; i++) {
        		if(array1[i] == (array1[i+1]-1))
        			sequence++ ;
        		else{
        			if(sequence > longest)
        				longest = sequence ;
        			sequence = 1 ;
        		}
        	}
            return longest ;
        }

        public static int longestSharedSequence(int[] array1, int[] array2){
            /**This method counts the longest unbroken, shared sequence in TWO arrays.
             * The sequence does NOT have to be a consecutive sequence
             * It does not matter where the sequence begins, the arrays might not be the same length
             * 
             * Examples:
             * longestSequence({9,6,3,4,3,8,9}, {9,6,3,4,3,6,7}) returns '5', since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long 
             * longestSequence({0,9,6,3,4,3,8,9}, {1,2,9,6,3,4,3,6,7}) returns '5', 
             *          since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long, it doesn't matter that the sequence begins at different indices 
             * longestSequence({9,6,1,4,3,6,7,9}, {9,6,5,8,3,6,7,0}) returns '3', since the sequence '3,6,7' is in both arrays and is 3 integers long
             * */
        	int longest = 0 ;
        	int sequence = 0 ;
            for(int i = 0 ; i < array1.length ; i++) {
            	for(int a = 0 ; a < array2.length ; a++) {
            		if(array1[i] == array2[a]) {
            			sequence++ ;
            			int x = i + 1 ;
            			int y = a + 1 ;
            			while(x < array1.length && y < array2.length && array1[x] == array2[y]) {
            			    sequence++ ;
            			    x++ ;
            			    y++ ;
            			}
            			
                        if(sequence > longest)
        				    longest = sequence ;
        			    sequence = 0 ;
            		}
            	}
            }
            return longest ;
        }

        public static int[] generateDistinctItemsList(int n){
            /**
             * This method needs to generate an int[] of length n that contains distinct, random integers
             * between 1 and 2n 
             * The method will be tested by verifying that the array you return is n items long,
             * contains only entries between 1 and 2n (inclusive) and has no duplicates
             * 
             * */
              int[] array = new int[n] ;
              int rand ;
              for(int i = 0 ; i < n ; i++) {
                  rand = (int)((Math.random()*(2*n))+1) ;
                  for(int a = 0 ; a < n ; a++) {
                      if(rand == array[a]) {
                          rand = (int)((Math.random()*(2*n))+1) ;
                          a = -1 ;
                      }
                  }
                  array[i] = rand ;
              }
             return array;
        }
        
        
        public static void cycleThrough(int[] array, int n){
            /** This problem represents people moving through a line.
             * Once they get to the front of the line, they get what they've been waiting for, then they 
             * immediately go to the end of the line and "cycle through" again.
             * 
             * This method reorders the array so that it represents what the array would look like
             * after it had been cycled through an n number of times.
             * For example, cycleThrough({2,1,5,6}}, 1) after executing, array == {1,5,6,2} 
             * because '2' (the person at the front of the line) cycled through and is now at the end of the line
             * 
             * cycleThrough({3,7,4,2,8,6,2,9}}, 2) after executing, array == {4,2,8,6,2,9,3,7} 
             * because '3' and '7' (the TWO people at the front of the line) cycled through and are now at the end of the line
             * 
             * Likewise,
             * cycleThrough({3,7,4,2,8,6,2,9}}, 0) after executing, array == {3,7,4,2,8,6,2,9}  (no movement)
             * and the most interesting case, 
             * cycleThrough({3,7,4,2,8,6,2,9}}, 49) after executing, array == {7,4,2,8,6,2,9,3}  
             * Because after cycling through 49 times, everyone had a chance to go through 6 times, but '3'
             * was able to go through one more time than anyone else
             * 
             * CHALLENGE
             * For extra credit, make your method handle NEGATIVE n
             * */
             int[] temp = new int[array.length] ;
             if(n > 0) {
                 for(int i = 0 ; i < n ; i++) {
                     for(int a = 0 ; a < array.length-1 ; a++){
                         temp[a] = array[a+1] ;
                     }
                     temp[temp.length-1] = array[0] ;
                     for(int b = 0 ; b < array.length ; b++){
                    	 array[b] = temp[b] ;
                     }
                 }
             }
        }
    

}
