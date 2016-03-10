package Classwork;

public class Assignment80 {

	public static void main(String[] args) {
		int[][] g ={{9, 8, 7, 6},           
				{5, 4, 2, 1},
				{3, 9, 2, 3}};
		//PART 7
		posToNeg2D(g, 2, 3) ;

		for(int[] array: g)
		{
			for(int num: array)
			{
				System.out.print(num + "	") ;
			}
			System.out.println("") ;
			System.out.println("") ;
		}


		int[][] g2 ={{9, 8, 7, 6},           
				{5, 4, 2, 1},
				{3, 9, 2, 3}};

		//PART 8
		int[] g3 = rowMajorOrder(g2) ;
		for(int num: g3)
		{
			System.out.print(num + " ") ;
		}

	}

	public static int[][] posToNeg2D(int[][] mat, int x, int y)
	{
		int[][] temp = mat ;
		for(int i = 0 ; i < mat.length ; i++)
		{
			for(int j = 0 ; j < mat[i].length ; j++)
			{
				if((Math.abs(x-i) > 1 || Math.abs(y-j) > 1) || (i == x && j == y))
					continue ;
				temp[i][j] *= -1 ;
			}
		}
		return temp ;
	}

	public static int[] rowMajorOrder(int[][]nums)
	{
		int[] temp = new int[nums.length*nums[0].length] ;
		for(int i = 0 ; i < nums.length ; i++)
		{
			for(int j = 0 ; j < nums[i].length ; j++)
			{
				temp[(nums[i].length*i) + j] = nums[i][j] ;
			}
		}
		return temp ;
	}

}

