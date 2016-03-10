package Classwork.InheritancePractice;

import java.util.ArrayList;

public class AnimalsPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Dog() ;
		Frog b = new Frog() ;
		Dog c = a ;
		Animal d = b ;
		Animal[] anims = {c, b} ;
		d.ribbit() ;
		anims[0].wagTail() ;
		
		
//		Animal z = new Dog() ;
//		Animal y = new Frog() ;
//		Animal x = new Dog() ;
//		Animal w = new Frog() ;
//		Animal v = new Dog() ;
//		Animal u = new Frog() ;
//		ArrayList<Animal> animals = new ArrayList<Animal>() ;
//		animals.add(z) ;
//		animals.add(y) ;
//		animals.add(x) ;
//		animals.add(w) ;
//		animals.add(v) ;
//		animals.add(u) ;
//		//doesn't work
//		for(Dog dog: animals)
//		{
//			
//		}
	}

}
