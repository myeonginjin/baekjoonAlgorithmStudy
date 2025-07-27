

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		String comp = "I";
		
		for (int i = 0; i<n; i++) {
			comp += "OI";
		}
		
		int answer = 0;
		int len = comp.length();
		
		for (int i = 0; i<=str.length()-len; i++) {

			if(str.substring(i, i+len).equals(comp)) {
				
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}

}
