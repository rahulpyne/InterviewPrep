package scjp.chapter2;

public class Animal implements LivingBeing {
	int age = 5; // default variable and can be inherited by a child class in same package
	
	public void displayAnimal(){
		System.out.println("Animal");
	}
	

	@Override
	public void displayLiving() {
		System.out.println("Living Being");
		
	}
	
	
}
