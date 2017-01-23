package arraysAndStrings;

public class Anagram {
	public static boolean isAnagram(String st1, String st2){
		int checksum1=0,checksum2 =0;
		if(st1.isEmpty() || st2.isEmpty()){
			return false;
		}
		else if(st1.length()!=st2.length()){
			return false;
		}
		else{
			for(int i=0; i<st1.length(); i++){
				checksum1+=st1.charAt(i);
				checksum2+=st2.charAt(i);
			}
			if(checksum1==checksum2){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println(isAnagram("abcdeaaa", "bdeaacaa"));
		System.out.println(isAnagram("abcdaaaa", "bdaaacae"));
	}

}
