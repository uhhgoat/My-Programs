package Homework;

import java.util.* ;
public class printPermutations {

	/**
	 * @param args
	 */
public static void main(String[] args) {
        
    }
    
    public static String[] printPermutations(String[] s1){
        List<String> newArray = new ArrayList<>();
        for(int i = 0 ; i < s1.length ; i++) {
            for(int x = 0 ; x < s1.length ; x++) {
                newArray.add(s1[i] + s1[x]) ;
            }
        }
        for(int y = 0 ; y < newArray.size() ; y++) {
            for(int z = 0 ; z < newArray.size() ; z++) {
                if(newArray.get(y).equals(newArray.get(z)) && (y != z)) {
                    newArray.set(y, "") ;
                }
            }
        }
        for(int index = newArray.size()-1 ; index >= 0 ; index--) {
            if(newArray.get(index).equals("")) {
                newArray.remove(index) ;
            }
        }
        String[] theArray = newArray.toArray(new String[newArray.size()]) ;
        return theArray;
    }
}
