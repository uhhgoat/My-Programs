package Homework;

public class getInverses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] array = getInverses(values) ;
		for(int x = 0 ; x < array.length ; x++) {
			System.out.println(array[x]) ;
		}
	}
	static double[] values = {0, 1, 2, 3, 4, 5} ;
	public static double[] getInverses(double[] values) {
		double[] newValues ;
		newValues = new double[values.length] ;
		for(int i = 0 ; i < values.length ; i++) {
			if(values[i] == 0)
				newValues[i] = 0 ;
			else
				newValues[i] = 1/(values[i]) ;
		}
		return newValues ;
	}
}
