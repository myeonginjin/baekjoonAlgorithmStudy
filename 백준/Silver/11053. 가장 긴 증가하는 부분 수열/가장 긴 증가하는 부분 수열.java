

import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] dp = new int[n];
		int ans = Integer.MIN_VALUE;
		
		dp[0] = 1;
		for(int i = 1; i<n; i++) {
			int max = 1;
			for (int j = i-1; j>=0; j--) {
				
				if(a[j] < a[i]) {
					max = Math.max(max, dp[j]+1);
				}
			}
			dp[i] = max;
			ans = Math.max(ans, max);
		}
		
		for (int i :dp) ans = Math.max(ans, i);
		
		System.out.println(ans);
	} 

}
