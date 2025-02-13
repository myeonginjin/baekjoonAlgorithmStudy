

import java.util.*;

public class Main {
	static int[] a;
	static int[] b;
	static int n,m;
	static boolean[] v;
	static HashSet<String> hs = new HashSet<>();
	
	static void perm(int index) {
		if(index == m) {
			
			String word = "";
			
			for (int t : b) word += String.valueOf(t);
			
			hs.add(word);
			
			return;
		}
		
		for (int i = 0; i<n; i++) {
			if(v[i]) continue;
			b[index] = a[i];
			v[i] = true;
			
			perm(index+1);
			
			v[i] = false;
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		m = Integer.parseInt(sc.next());
		a = new int[n];
		b = new int[m];
		v = new boolean[n];
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		
		perm(0);
		
		System.out.println(hs.size());
	}

}
