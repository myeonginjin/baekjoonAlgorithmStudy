

import java.util.*;


public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next());
		String str;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<num; i++) {
			
			int c = Integer.parseInt(sc.next());
			int n = Integer.parseInt(sc.next());
			
			sb.append(calcul(n, c)).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static long calcul(int n , int c) {
		
		long result = 1;
		
		for (int i = 0; i<c; i++) {
			result *= (n-i);
			result /= (i+1);
		}
		
		return result;
		
	}

}
