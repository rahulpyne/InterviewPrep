package arraysAndStrings;

public class CStyle {

	public static String getReverseCStyle(String str){
		StringBuffer sb = new StringBuffer();
		for(int i = str.length(); i>=0 ;i--){
			if(i!=str.length()){
			sb.append(str.charAt(i));
			}
			else{
				sb.append('\0');
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CStyle.getReverseCStyle("abcd"));
		System.out.println(CStyle.getReverseCStyle("abcd").length());
	}

}
