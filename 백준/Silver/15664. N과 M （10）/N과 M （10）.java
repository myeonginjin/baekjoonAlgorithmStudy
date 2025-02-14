

import java.util.*;

public class Main {
	static int n,m;
	static int[] a;
	static int[] b;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hs = new HashSet<>();
	
	static void comb(int index, int str) {
		if(index == m) {
			String st = "";
			for (int t : b) st += String.valueOf(t+" ");
			
			
			if(!hs.contains(st)) {
				hs.add(st);
				sb.append(st).append("\n");
			}
			return;
		}
		
		for (int i = str; i<n; i++) {
			b[index] = a[i];
			comb(index+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new int[n];
		b = new int[m];
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		
		comb(0,0);
		System.out.println(sb);
	}

}
