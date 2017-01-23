package scjp.chapter1;

//enums declared outside class can have only default types. To make it public, we need to have
// a seperate file.
	enum CoffeeSize{
		BIG(8),medium(4),SMALL(3,'A'); // Variables can be both uppercase or mixed but recommended to be upper
		int size;
		char lidType;
		// One cannot directly invoke enum constructors
		CoffeeSize(int size, char lidType){
			this.size = size;
			this.lidType = lidType;
		}
		// Overloading of enum constructors.
		CoffeeSize(int size){
			this.size = size;
		}
		
		public int getSize(){
			return this.size;
		}
		
		public char getLidType(){
			return this.lidType;
		}
		
	}
	
	class LocalClass{
		CoffeeSize size;
		enum Animal{DOG,HORSE}// semicolon is optional. Only public, protected, private, static allowed.
		Animal anm;
	}
public class EnumPractice {
	CoffeeSize lidType;
	
	public static void main(String[] args) {
		LocalClass lc = new LocalClass();
		lc.size = CoffeeSize.BIG;
		lc.anm = LocalClass.Animal.HORSE;// for enums declared inside a class, the enclosing class's name is required. 
		System.out.println(lc.size + " "+ lc.size.getSize()+ " "+ lc.size.getLidType());
		
		for(CoffeeSize size: CoffeeSize.values()){ //  values() is a static method of enum that returns values of the enum in an array format.
			System.out.println(size + " "+ size.getSize() + " "+ size.getLidType());
		}
		
		for(LocalClass.Animal anm: LocalClass.Animal.values()){
			System.out.println(anm);
		}
	}
	
	 

}
