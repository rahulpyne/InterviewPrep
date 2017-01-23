package scjp.chapter2;

public class Dog extends Animal implements LivingBeing {
	int age = 10;
	// Dog doesn't have to implement the methods of LivingBeing because the parent class
	// Animal has already implemented the methods of LivingBeing
	// overriding super class method.
	public void displayAnimal(){
		System.out.println("Dog");
	}
	
	public void displayName(){
		System.out.println("Timothy");
	}
	
	public static void main(String... args){
		Animal a = new Animal();
		Animal ad = new Dog(); // Implicit or Upcasting;
		Dog d = new Dog();
		Dog da = (Dog)ad; // Legal Explicit or downcasting
		//Dog da2 = (Dog)a; // Illegal Explicit or downcasting. It will throw ClassCastException.
		System.out.println(a.age); // prints 5 as expected
		System.out.println(ad.age); // prints 5 again because variables are not overriden and the reference variable is of animal.
		System.out.println(d.age);// print 10 as expected
		System.out.println(da.age);// prints 10 because the reference variable is Dog and variables are decided during compile time.
		a.displayAnimal();// prints animal
		ad.displayAnimal();// prints dog because its overriden
		da.displayName(); // prints Timothy because ad has been downcasted to da
		
	}
}
