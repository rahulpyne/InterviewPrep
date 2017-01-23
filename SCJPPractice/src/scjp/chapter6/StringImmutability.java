package scjp.chapter6;

public class StringImmutability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("abc");
		String s1 = "def";
		String s2 = s;
		s2+=s1;
		System.out.println(s);
		System.out.println(s2);
	}

}
