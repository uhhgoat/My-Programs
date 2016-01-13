package Homework;

public class NeighborhhodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[][] neighborhood = new boolean[10][2] ;
		neighborhood[0][0] = true ;
		int r = 0 ;
		int c = 0 ;
		int result = checkNeighbors(neighborhood, r, c) ;
		System.out.println(result) ;
	}
	public static int checkNeighbors(boolean[][] neighborhood, int r, int c) {
		if(neighborhood[r][c]) {
			
			return 0 ;
		}
		else {
		
			if(!neighborhood[r][c]) {
				if(r > 0) {
					if(neighborhood[r-1][c]){
						return 1 ;
					}
				}
				if(r < neighborhood.length-1) {
					if(neighborhood[r+1][c]){
						return 1 ;
					}
				}
				
				if(c > 0) {
					if(neighborhood[r][c-1]){
						return 1 ;
					}
				}
				if(c < neighborhood[r].length-1) {
					if(neighborhood[r][c+1]){
						return 1 ;
					}
				}
				
			}
			
			return -1 ;
		}
		
	}
}
