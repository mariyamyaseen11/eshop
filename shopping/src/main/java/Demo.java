import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

	public static void main (String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter string");
		String s = br.readLine().trim();
		//String s = "my name is mariyam yaseen";
		char firstChar = s.charAt(0);
		String result = ""; 
		result += Character.toUpperCase(firstChar);
		
		for(int i=1; i<s.length() ;i++) {
			char ch = s.charAt(i);
			
			if(ch == ' ') {
				result = result+ ch;
				i++;
				ch = s.charAt(i);
				result = result + Character.toUpperCase(ch);
			} else {
				result = result+ ch;
			}
			
		}
		
		System.out.println(result);
	}
	

}
