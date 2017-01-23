package arraysAndStrings;

public class RemoveSpaces {
	public static String removeSp(String str){
		if(str.isEmpty()){
			return str;
		}
		else{StringBuffer sb = new StringBuffer(); // O(1) for amortized complexity for dynamic resizing.
			for(int i =0; i<str.length();i++){// O(n) where n is the number of characters
				if(str.charAt(i)==' '){ 
					sb.append("%20"); // It takes  O(1) coz it just adds to the end of the  buffer
				}
				else{
					sb.append(str.charAt(i));
				}
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(removeSp("ass asas asas"));

	}

}
