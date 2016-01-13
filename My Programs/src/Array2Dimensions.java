
public class Array2Dimensions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] grid3x3 = new int[3][3] ;
//		grid3x3[1][0] = 1 ;
//		Arrays.printArrayContent(grid3x3[0]) ;
//		Arrays.printArrayContent(grid3x3[1]) ;
//		Arrays.printArrayContent(grid3x3[2]) ;
//		System.out.println("") ;
//		print2DArrayContent(grid3x3) ;
//		checkAdjacentValues() ;
		
	}
	public static void checkAdjacentValues() {
		boolean[][] mines = new boolean[3][3] ;
		mines[2][1] = true ;
		int row = getRandomInt(2) ;
		int column = getRandomInt(2) ;
		int typeOfSpace = checkSpace(mines, row, column) ;
		if(typeOfSpace == 0) {
			System.out.println("At row " + row + ", column" + column + ", the mine was found!");
		}
		if(typeOfSpace == 1) {
			System.out.println("At row " + row + ", column" + column + ", there is a mine nearby!");
		}
		if(typeOfSpace == 2) {
			System.out.println("At row " + row + ", column" + column + ", there are no mines nearby!");
		}
	}
	
	private static int checkNeighbors(boolean[][] neighborhood, int r, int c) {
		if(neighborhood[r][c])
			return 0 ;
		else {
		
			if(!neighborhood[r][c]) {
				if(r > 0) {
					if(neighborhood[r-1][c]){
						return 1 ;
					}
				}
				if(r < neighborhood[r].length) {
					if(neighborhood[r+1][c]){
						return 1 ;
					}
				}
				
				if(c > 0) {
					if(neighborhood[r][c-1]){
						return 1 ;
					}
				}
				if(c < neighborhood.length) {
					if(neighborhood[r][c+1]){
						return 1 ;
					}
				}
				
			}
			else {
				return -1 ;
			}
		}
		
	}
	
	
	public static int getRandomInt(int max) {
		int random = (int)((Math.random()*max)+1) ;
		return random;
	}
	public static void print2DArrayContent(int[][] array) {
		for(int[] x: array) {
			Arrays.printArrayContent(x) ;
		}
	}
	public static void print2DArrayContent(boolean[][] array) {
		for(boolean[] x: array) {
			Arrays.printArrayContent(x) ;
		}
	}
}
