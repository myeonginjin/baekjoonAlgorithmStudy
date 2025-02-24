

import java.util.*;

public class Main {
	
	static int n,m;
	static int[] a;
	
	static boolean bs(int t, int str, int end) {
		if(str > end) return false;
		
		int mid = (str + end) / 2;
		
		if(a[mid] == t) return true;
		
		if(a[mid] < t) {
			return bs(t, mid+1, end);
		} else {
			return bs(t, str, mid-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a); 
		
		m = sc.nextInt();
		
		int cnt = 0;
		for (int i = 0; i<m; i++) {
			int t = sc.nextInt();
			
			
			if(bs(t, 0, a.length-1)) System.out.println("1");
			else System.out.println("0");
		}
	
		
	}

}
