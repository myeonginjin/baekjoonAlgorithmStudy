import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_5397"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String str;

		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			StringBuilder sb = new StringBuilder();
			LinkedList<String> ans = new LinkedList<>();
			ListIterator<String> p = ans.listIterator();
			
			String type;
			for (int s = 0; s<str.length(); s++) {
				type = str.substring(s,s+1);
				
				switch(type) {
				
				case "<" :
					if(p.hasPrevious()) p.previous();
					break;
				
				case ">" :
					if(p.hasNext()) p.next();
					break;
					
				case "-" :
					if(p.hasPrevious()) {
						p.previous();
						p.remove();
					}

					break;
					
				default :
					p.add(type);
					break;
				
				}
				
			}
			for(String s : ans) sb.append(s);
			System.out.println(sb);	
		}
		
	}

}
