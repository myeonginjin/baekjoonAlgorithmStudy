
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		
		int answer = 0;
		
		int cnt = 0;
		
		for (int i = 0; i<str.length()-2; i++) {
			
			if(str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') {
				cnt++;
				
				//System.out.println(cnt);
				
				if(cnt == n) {
					answer++;
					cnt--;
				}
				i++;
			} else {
				cnt = 0;
			}
			
		}
		
		System.out.println(answer);
		
		
	}

}
