package New_Package;

import java.util.HashSet;
import java.util.Set;

public class String_Character_Count {
	
	public static void main(String args[]) {
		
		String new_string = "Hello World";
		Set set1 = new HashSet();
		
		for(int i=0;i<new_string.length();i++) {
			char ch = new_string.charAt(i);
			if(set1.contains(ch)==true) {
				continue;
			}
			if(Character.isWhitespace(ch)) {
				continue;
			}
			set1.add(ch);
			int len=1;
			for(int j=i+1;j<new_string.length();j++) {
				if(new_string.charAt(j)==ch) {
					len=len+1;
				}
			}
			System.out.println("The count of "+ ch + " is "+len);
		}
	}
	
	
}
		
		