package Math;

import java.text.DecimalFormat;

public class Term{
	private double coefficient;
	private String variable;
	private int exponent;
	private boolean constant;

	public Term(double coefficient, String var, int exp){
		this.coefficient = coefficient;
		this.variable = var;
		this.exponent = exp;
		if(!var.equals("")){
			this.constant = false;
		}else{
			this.constant = true;
		}
		if(coefficient == 0){
			this.variable = "";
			this.exponent = 0;
			this.constant = true;
		}
	}

	/**
	 *a constructor for constant: 
	 */
	Term(double constant){
		this.coefficient = constant;
		this.variable = "";
		this.exponent = 1;
		this.constant = true;
	}
	public double getCoefficient() {
		return coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public boolean isConstant() {
		return constant;
	}

	/**
	 *Write getters for each field
	 *Note that the getter for the boolean should be called 'isConstant'
	 */ 

	public Term getAddInverse(){
		Term additiveInverse = new Term(this.coefficient * -1, this.variable, this.exponent);
		return additiveInverse;
	}

	public int getDegree(){
		return exponent;
	}

	public boolean isPositive(){
		if(coefficient < 0){
			return false;
		}
		return true;
	}	

	public String toString(){
		String stringToReturn;
		String exponent;
		String coefficient;
		
		if(this.coefficient == -1.0 || this.coefficient == 1.0){
			if(this.coefficient == -1.0){
				coefficient = "-";
			}else{
				coefficient = "";
			}
		}else{
			DecimalFormat noTrailingZeroesFormat = new DecimalFormat("#.#####");
			coefficient = noTrailingZeroesFormat.format(getCoefficient());
		}
		
		if(getExponent() == 1){
			exponent = "";
		}else{
			exponent = Integer.toString(getExponent());
		}
		if(!this.variable.equals("")){
			if(this.exponent != 1){
				stringToReturn = coefficient + variable + "^" + exponent; 
			}else{
				stringToReturn = coefficient + variable;
			}
		}else{
			stringToReturn = coefficient;
		}
		return stringToReturn;
		/**
		 *Some tips to consider:
		 *doubles always print with trailing zeros (i.e. 2.0) This is not desireable
		 *If a term has a coefficient of 1 or -1, the 1 should not be shown. 
		 *If a term has an exponent of 1, the 1 should not be shown
		 *For exponents, use '^'. The GUI will change it into superscript.
		 */
	}
	
	public static boolean areLikeTerms(Term s, Term t){
		if( (s.getVariable().equals(t.getVariable())) && (s.getExponent() == t.getExponent()) ){
			return true;
		}
		return false;
	}
	
	public static Term combine(Term s, Term t){
		Term combinedTerm = new Term(0);
		combinedTerm.setCoefficient(s.getCoefficient()+t.getCoefficient());
		combinedTerm.variable=s.getVariable();
		combinedTerm.exponent=s.getExponent();
		return combinedTerm;
	}
	
	public void setCoefficient(double d) {
		this.coefficient = d;
	}
}