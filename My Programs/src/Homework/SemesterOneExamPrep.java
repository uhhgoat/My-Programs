package Homework;

public class SemesterOneExamPrep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

    }
    

    public static int getScoreToDrop(int[] pValue, double[] pScore){
        /** this method helps a teacher figure out which assignment
         * has the greatest negative impact on a student's grade
         * so that the assignment can be dropped. It does this by taking two
         * arrays as parameters. The point value of every assignment is 
         * stored in one array, pValue, and the corresponding percent 
         * score is stored in another array, pScore, at the same index.
         * You may assume pValue and pScore have the same length
         * Note that pScore is a double[] and the percentages are stored in 
         * decimal form (e.g. .63 instead of 63%)
         * The method returns the index of the assignment to be droped. 
         * This is determined to be the assignment at the index for which the PRODUCT
         * of (1.0 - pScore) and (pValue) is most (basically, greatest number of raw points MISSED)
         * and the pValue is not more than 50 points. (since assignments 
         * worth 51 points or more are exams or quizes, which cannot be dropped.)
         * You may assume that such an assignment (onwe worth less than 51 points) 
         * always exists.
         * */
         int index = 0 ;
         for(int i = 0 ; i < pValue.length ; i++)
         {
             if(((1.0 - pScore[i]) * pValue[i]) >= ((1.0 - pScore[index]) * pValue[index]) && pValue[i] <= 50)
             {
                index = i ;
             }
         }
         return index ;
    }
    
    public static String assignLetterGrade(double grade){
        /** This method assigns a letter grade based on a percetage, in decimal form
         * Grades, g,  are assigned accordingly:
         * .97 <= g <= 1.0 = A+
         * .94 <= g < .97 = A
         * .90 <= g < .94 = A-
         * .87 <= g < .90 = B+
         * .84 <= g < .87 = B
         * .80 <= g < .84 = B-
         * .77 <= g < .80 = C+
         * .74 <= g < .77 = C
         * .70 <= g < .74 = C-
         * .60 <= g < .70 = D
         * g <= .64  = F
         * */
         if(.97 <= grade && grade <= 1.0)
            return "A+" ;
         if(.94 <= grade && grade < .97)
            return "A" ;
         if(.90 <= grade && grade < .94)
            return "A-" ;
         if(.87 <= grade && grade < .90)
            return "B+" ;
         if(.84 <= grade && grade < .87)
            return "B" ;
         if(.80 <= grade && grade < .84)
            return "B-" ;
         if(.77 <= grade && grade < .80)
            return "C+" ;
         if(.74 <= grade && grade < .77)
            return "C" ;
         if(.70 <= grade && grade < .74)
            return "C-" ;
         if(.65 <= grade && grade < .70)
            return "D" ;
         return "F" ;
    }
    
        public static boolean checkSudoku(int[][] solution){
        /**this method takes a 9x9 int[][] as a parameter and checks if it is a sudoku solution
         * (It is safe to assume that "solution" is truly 9x9 and that all of the elements are also valid (1-9 only))
         * To be a solution, every row and column must contain a distinct number (1-9)
         * Furthermore, every 3x3 must contain a distinct number (1-9)
         * The 3x3 subgrids are 
         * soultion[0][0]-solution[2][2]
         * soultion[0][3]-solution[2][5]
         * soultion[0][6]-solution[2][8]
         * soultion[3][0]-solution[5][2]
         * soultion[3][3]-solution[5][5]
         * soultion[3][6]-solution[5][8]
         * soultion[6][0]-solution[8][2]
         * soultion[6][3]-solution[8][5]
         * soultion[6][6]-solution[8][8]
         * 
         * 
         * An example of a valid grid (if I typed it correctly) is:
         * [2 4 9 5 3 6 7 1 8]
         * [6 7 1 9 8 4 3 5 2]
         * [3 5 8 1 2 7 6 9 4]
         * [4 2 6 7 1 9 8 3 5]
         * [8 9 7 3 5 2 4 6 1]
         * [5 1 3 6 4 8 2 7 9]
         * [9 6 4 2 7 1 5 8 3]
         * [1 8 5 4 6 3 9 2 7]
         * [7 3 2 8 9 5 1 4 6]
         * 
         * a test has not yet been made for this method
         * */
         int temp = 0 ;
         for(int i = 0 ; i < solution.length ; i++)
         {
             temp = 0 ;
             for(int j = 0 ; j < solution.length ; j++)
             {
                 temp += solution[i][j] ;
             }
             if(temp != 45)
                return false ;
         }
         for(int i = 0 ; i < solution.length ; i++)
         {
             temp = 0 ;
             for(int j = 0 ; j < solution.length ; j++)
             {
                 temp += solution[j][i] ;
             }
             if(temp != 45)
                return false ;
         }
         //check separate boxes
         boolean[] boxes = {checkBoxes(solution, 0, 0), checkBoxes(solution, 0, 3), checkBoxes(solution, 0, 6), checkBoxes(solution, 3, 0), checkBoxes(solution, 3, 3), checkBoxes(solution, 3, 6), checkBoxes(solution, 6, 0), checkBoxes(solution, 6, 3), checkBoxes(solution, 6, 6)} ;
         for(int x = 0 ; x < boxes.length ; x++)
         {
             if(boxes[x] == false)
                return false ;
         }
         return true ;
    }
    public static boolean checkBoxes(int[][] array, int row, int column)
    {
        int temp = 0 ;
        for(int a = row ; a < row + 3 ; a++)
        {
            for(int b = column ; b < column + 3 ; b++)
            {
                temp += array[a][b] ;
            }
        }
        if(temp != 45)
            return false ;
        return true ;
    }

}
