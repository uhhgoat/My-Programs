package Math;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Solver{

	static SolverGUI gui = new SolverGUI();
	//TEST EQ: 3x^2 -12x +13 = 2x^2 -17x +7
	public static void main(String[] args){
		//TODO: for now, you may use this method for testing
		//your other methods
		//Here is something to try:
		System.out.println("The terms in the equation \"3x^2 -12x +13 = 2x^2 -17x +7\" are:");
		Equation parsedEquation = interpretInput("3x^2 -12x +13 = 2x^2 -17x +7");
		for(Term t: parsedEquation.getLeftSide()){
			System.out.println(t.toString());
		}
		System.out.println("...on the left, and on the right:");
		for(Term t: parsedEquation.getRightSide()){
			System.out.println(t.toString());
		}
		
		gui.setVisible(true);
		gui.setSize(900,500);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static Equation interpretInput(String s){
		//parse s into two ArrayList<Term>
		//expect user input to appear like this:
		//3x^2 -12x +13 = 2x^2 -17x +7
		//A few things to note:
		//Assume the user will always include exactly one '=',
		//    (Invalid input will be handled by the GUI)
		//Terms are always separated by a '+','-' or '='
		//Do not consider subtraction. Rather, subtraction is ADDING a Term with a NEGATIVE coefficient
		//Recall that a term like "x" has a coefficient of '1' and an exponent of '1'
		//Recall that there is a specific constructor for constant terms
		String str = s.replaceAll("\\s","");
		//str = 3x^2 -12x +13 = 2x^2 -17x +7
		String[] twoHalves = str.split("=");
		//twoHalves = {-3x^2-12x+13, 2x^2-17x+7};
		ArrayList<Term> left = initiateAndParseAllTerms(twoHalves[0]);
		ArrayList<Term> right = initiateAndParseAllTerms(twoHalves[1]);
		return new Equation(left, right);
	}
	
	public static void factor(Equation eq)
	{
		double a = 0.0;
		double b = 0.0;
		double c = 0.0;
		for(Term t: eq.getLeftSide())
		{
			if(t.getDegree() == 2)
			{
				a = t.getCoefficient() ;
			}
			if(t.getDegree() == 1)
			{
				b = t.getCoefficient() ;
			}
			if(t.isConstant())
			{
				c = t.getCoefficient() ;
			}
		}
		b = eq.getLeftSide().get(1).getCoefficient() ;
		c = eq.getLeftSide().get(2).getCoefficient() ;
		double d = Math.sqrt(b*b - 4 *(a*c)) ;
		
		double positiveRoot = (-b+d)/(2*a) ;
		double negativeRoot = (-b-d)/(2*a) ;
		QuadraticForm qf = new QuadraticForm(-b+"", (b*b - 4 *(a*c))+"", 2*a+"") ;
		gui.addStep("The pos rot is " + positiveRoot) ;
		gui.addStep("The neg rot is " + negativeRoot) ;
	}

	/**

	 * @param sample string from user: 34a^3

	 * @return new Term representing input from user

	 * Use this method for writing interpretInput

	 */
	
	private static ArrayList<Term> initiateAndParseAllTerms(String s){
		ArrayList<Term> list = new ArrayList<Term>();
		boolean positive = true;
		int i = 0;
		if(s.startsWith("-")){
			i = 1;
			positive = false;
		}
		while(s.length() > 0){
			int endOfTerm = s.length();
			int indexOfPlus = s.indexOf("+");
			if(indexOfPlus == -1){
				indexOfPlus = endOfTerm;
			}
			
			int indexOfMinus = s.indexOf("-");
			if(indexOfMinus == -1){
				indexOfMinus = endOfTerm;
			}
			
			if(indexOfMinus < indexOfPlus){
				endOfTerm = indexOfMinus;
			}else{
				endOfTerm = indexOfPlus;
			}
			try{
				Term a = parseTerm(s.substring(i, endOfTerm));
				
				if(!positive && a!=null){
					a = a.getAddInverse();
				}
				if(a!=null){
					list.add(a);
				}
				if(indexOfMinus < indexOfPlus){
					positive = false;
				}else{
					positive = true;
				}
				
				s = s.substring(endOfTerm+1);
			}catch(Exception e){
				s = s.substring(endOfTerm);
			}
		}
		return list;
	}
	
	private static Term parseTerm(String s) {

		if(s.matches("\\d*\\w\\^\\d*|\\d*\\w|\\d+")){//regex identifies anything like 23x^2 or y^11 or 12b or z or 13

			double coef;

			String variable;

			Term t;

			if(s.matches("\\d*")){

				coef = Double.parseDouble(s);

				t = new Term(coef);

			}

			else if(s.matches("\\d*\\w+(\\^\\d+)?")){

				String noDigits = s.replaceAll("\\d", "");

				int indOfVar = s.indexOf(noDigits);

				if(s.substring(0, indOfVar).length() == 0){
					coef = 1.0;
				}else{
					coef = Double.parseDouble(s.substring(0, indOfVar));
				}

				variable=s.substring(indOfVar, indOfVar+1);

				if(s.indexOf("^")>-1){

					int exponent = Integer.parseInt(s.substring(s.indexOf("^")+1));

					t =new Term(coef,variable,exponent); 

				}else{

					t =new Term(coef,variable,1); 


				}


			}else{

				t=null;

			}

			return t;

		}

		else return null;

	}


	public static String getConfirm(Equation eq) {
		return "Your input was interpreted as " + eq.toString();

		//returns a message confirming the input given by the user, such as "Your input was interpreted as "+eq.toString();

	}



	public static String getNoTricks(String usersInput) {
		return "This equation cannot be interpretted at this time.";

		//returns a message for when the user types input that cannot be interpreted by your Solver

	}
	
	public static void solve(Equation eq) {

		gui.clearSteps();//make sure gui is a static field, and gui.addStep after each step of the process
		if(eq.isCancelRight())
		{
			eq.toZeroOnOneSide(eq.getRightSide());
			gui.addStep(eq, "This is what was done:");
			eq.simplify(eq.getLeftSide());
			gui.addStep(eq, "This is what was done:");
			eq.simplify(eq.getRightSide());
			gui.addStep(eq, "This is what was done:");
			eq.solveLinear(eq.getLeftSide());
			gui.addStep(eq, "This is what was done:");
		}
		else
		{
			eq.toZeroOnOneSide(eq.getLeftSide());
			gui.addStep(eq, "This is what was done:");
			eq.simplify(eq.getLeftSide());
			gui.addStep(eq, "This is what was done:");
			eq.simplify(eq.getRightSide());
			gui.addStep(eq, "This is what was done:");
			eq.solveLinear(eq.getRightSide());
			gui.addStep(eq, "This is what was done:");
		}
	}

}