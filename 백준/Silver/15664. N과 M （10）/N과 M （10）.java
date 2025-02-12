

import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int a[];
	static int b[];
	static boolean v[];
	static StringBuilder sb;
	static HashSet<String> hs = new HashSet<>();
	static HashSet<String> hs2 = new HashSet<>();
	
	static boolean isDuplicate() {
		int[] c = new int[m];
		int index  =  0;
		for (int t : b) c[index++] = t;
		
		Arrays.sort(c);
		String combine = "";
		
		for (int t : c) combine += String.valueOf(t) + " ";
		
		if(hs.contains(combine)) return true;
		
		else {
			hs.add(combine);
			return false;
		}
	}
	
	static void comb(int index) {
		if(index == m) {
			if(isDuplicate()) {
				
//				String str = "";
//				for (int t : b) str += String.valueOf( a[t] ) +" "; 
//				
//				System.out.println(str);
				
				return;
			}
			String str = "";
			for (int t : b) str += String.valueOf( a[t] ) +" "; 
//			
//			System.out.println(str);
			
			if(!hs2.contains(str)) {
				sb.append(str).append("\n");
				hs2.add(str);
			}
		
			return;
		}
		
		for (int i = 0; i<n; i++) {
			if(v[i]) continue;
			
			b[index] = i;
			v[i] = true;
			
			comb(index+1);
			
			v[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		sb = new StringBuilder();
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		b = new int[m];
		v = new boolean[n];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(a);
		
		
		comb(0);
		
		//System.out.println("======");
		System.out.println(sb);
		
		br.close();
	}

}
