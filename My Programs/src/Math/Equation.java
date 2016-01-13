package Math;

import java.util.ArrayList;

public class Equation{

	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;
	//TODO: Make getters for all of the above

	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		//sets values of leftSide and rightSide only
	}

	public boolean isLinear(){
		String variable = getHighestDegreeTerm(this.leftSide).getVariable();
		if(getHighestDegreeTerm(this.leftSide).getExponent() != 1 || getHighestDegreeTerm(this.rightSide).getExponent() != 1){
			return false;
		}
		for(Term t : this.leftSide){
			if(!t.getVariable().equals(variable) && t.isConstant() == false){
				return false;
			}
		}
		for(Term t : this.rightSide){
			if(!t.getVariable().equals(variable) && t.isConstant() == false){
				return false;
			}
		}
		return true;
		//returns 'true' if this equation is linear
		//and every term is either constant or has the same variable
	}

	public boolean isQuadratic(){
		String variable = getHighestDegreeTerm(this.leftSide).getVariable();
		if(getHighestDegreeTerm(this.leftSide).getExponent() != 2 || getHighestDegreeTerm(this.rightSide).getExponent() != 2){
			return false;
		}
		for(Term t : this.leftSide){
			if(!t.getVariable().equals(variable) && t.isConstant() == false){
				return false;
			}
		}
		for(Term t : this.rightSide){
			if(!t.getVariable().equals(variable) && t.isConstant() == false){
				return false;
			}
		}
		return true;
		//returns 'true' if this equation is quadratic
		//and every term is either constant or has the same variable
	}

	public boolean isSolveable(){
		if(isLinear() == true || isQuadratic() == true){
			return true;
		}
		return false;
		//returns 'true' if this equation is linear or quadratic, 'false' otherwise 
		//(because in this project we are not programming a means of solving anything other than linear and quadratic equations)
	}

	public boolean cancelRight(){
		if(getHighestDegreeTerm(leftSide).getCoefficient() >= getHighestDegreeTerm(rightSide).getCoefficient()){
			this.cancelRight = true;
			return true;
		}
		this.cancelRight = false;
		return false;
		//sets the value of cancelRight and
		//returns 'true' if the equation should be solved by subtracting terms from the right side, false if it is better to subtract terms on the left side
	}

	public String toString(){
		String stringToReturn = leftSide.get(0).toString();
		for(int i = 1; i < leftSide.size(); i++){
			Term t = leftSide.get(i);
			if(t.getCoefficient() > 0.0){
				stringToReturn += "+" + t.toString();
			}else{
				stringToReturn += t.toString();
			}
		}
		stringToReturn += "=" + rightSide.get(0).toString();
		for(int i = 1; i < rightSide.size(); i++){
			Term t = rightSide.get(i);
			if(t.getCoefficient() > 0.0){
				stringToReturn += "+" + t.toString();
			}else{
				stringToReturn += t.toString();
			}
		}
		return stringToReturn;
		/**
		 *Take your time on this method!
		 *There are many things to consider:
		 *Every terms should be separated by a '+' UNLESS it has a negative coefficient. 
		 *When a term is negative, the negative sign will appear as a minus.
		 */
	}


	public static Term getHighestDegreeTerm(ArrayList<Term> side){
		int exponent = 0;
		Term highestTerm = new Term(0);
		for(Term t : side){
			if(t.getExponent() > exponent){
				highestTerm = t;
			}
		}
		return highestTerm;
		//returns the term in the ArrayList that is the highest degree.
		//example
		//3x^2 + 4x^3 - 12x + x^2
		//will return 4x^3 
	}

	public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
		ArrayList<Term> addIn = new ArrayList<Term>() ;
		for(Term t: sideBeingCanceled)
		{
			addIn.add(t.getAddInverse()) ;
		}
		for(Term t: addIn)
		{
			leftSide.add(t) ;
			rightSide.add(new Term(t.getCoefficient(), t.getVariable(), t.getExponent())) ;
		}
	}

	public void simplify(ArrayList<Term> side){
		for(Term t: side)
		{
			for(Term s: side)
			{
				if(t != s && t.getCoefficient() != 0)
				{
					if(Term.areLikeTerms(s, t))
					{
						Term result = Term.combine(s, t) ;
						t.setCoefficient(result.getCoefficient()) ;
						s.setCoefficient(0) ;
					}
				}
			}
		}
		for(int i = side.size()-1 ; i > -1 ; i--)
		{
			if(side.get(i).getCoefficient() == 0)
			{
				side.remove(i) ;
			}
		}
	}
	
	
	public double solveLinear(ArrayList<Term> sideWithVariable){//ASSUMPTION: eq is in linear form ax + b = 0
//		Term constant = new Term(0);
//		Term termWithVariable = new Term(0);
//		
//		
//		for(Term t : sideWithVariable){
//			if(t.isConstant()){
//				constant = t;
//			}else{
//				termWithVariable = t;
//			}
//		}
//		leftSide.add(constant.getAddInverse());
//		rightSide.add(constant.getAddInverse());
//		multiplyScalar(leftSide, (1/termWithVariable.getCoefficient()));
//		multiplyScalar(rightSide, (1/termWithVariable.getCoefficient()));
		
		Term a = new Term(0);
		Term b = new Term(0);
		for(Term i: sideWithVariable)
		{
			if(i.isConstant())
				b = i ;
			else
				a = i ;
		}
		leftSide.add(b.getAddInverse());
		rightSide.add(b.getAddInverse());
		simplify(leftSide) ;
		simplify(rightSide) ;
		return 1/(a.getCoefficient()) ;
	}
	
	
//	public void solveQuadtratic()
//	{
//		
//	}
	
	public void multiplyScalar(ArrayList<Term> side, double scalar){
		for(Term t : side){
			t.setCoefficient(t.getCoefficient() * scalar);
		}
	}
	
	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}

	public ArrayList<Term> getRightSide() {
		return rightSide;
	}

	public boolean isCancelRight() {
		return cancelRight;
	}

	public ArrayList<Double> getSolution() {
		return solution;
	}

}

