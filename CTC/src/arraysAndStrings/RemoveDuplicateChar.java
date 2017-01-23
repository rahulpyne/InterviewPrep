package arraysAndStrings;

public class RemoveDuplicateChar {
	
	public static String[] removeDuplicate(String[] str){
		int tail = 1;
		if(str==null){
			return null;
		}
		else if(str.length < 2){
			return str;
		}
		else{
			
			for(int i=1; i<str.length;i++){
				 int j;
				for(j = 0; j<tail; j++){
					if(str[i]==str[j])
						break;
				}
				if(j==tail){
					str[tail]=str[i];
					tail++;
				}
			}
			for(int k=tail;k<str.length;k++){
				str[k]="";
			}
			
			return str;

		}
	}

	public static void main(String[] args) {
		String[] str ={"a","a","b","b","c","a"} ;
		str=RemoveDuplicateChar.removeDuplicate(str);
		for (String strng : str) {
			System.out.print(strng);
		}


	}

}
